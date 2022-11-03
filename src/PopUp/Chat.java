package PopUp;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.text.*;
import render.RenderableHolder;
import Character.*;
import application.Main;

public class Chat extends GridPane{
	
	private Text name;
	private Text trust;
	private Text conversation;
	private Text describtion;
	private ImageView image;
	
	public Chat(Unit unit) {
		Button inter = new Button();
		inter.setPrefSize(80, 40);
		inter.setTextFill(Color.WHITE);
		inter.setFont(Font.font(20));
		inter.setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
		if((unit instanceof Beros) ) {
			inter.setText("Feed");
			inter.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					RenderableHolder.invenSound.play(0.2);
					unit.interact(10);
					inter.setDisable(true);
					for(int i = 0 ;i < Player.itemList.size(); i++) {
						if(Player.itemList.get(i).getName().equals("Burger")) {
							Player.itemList.remove(i);
							Player.hasBurger = false;
						}
					}
					
				}
			});
			if(!Player.hasBurger) {
				inter.setDisable(true);
			}
		}
		else if(unit instanceof Scofield) {
			inter.setText("Rob");
			inter.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					RenderableHolder.invenSound.play(0.2);
					inter.setDisable(true);
					Main.rob(Player.stage);
				}
			});
			if(!Player.hasKnife || Player.hasLadder) {
				inter.setDisable(true);
			}
		}
		else if((unit instanceof Policeman1) || (unit instanceof Policeman2)) {
			inter.setText("Work");
			inter.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					RenderableHolder.invenSound.play(0.2);
					unit.interact(10);
					inter.setDisable(true);
					Player.setSatamina(Player.getSatamina() - 30);
				}
			});
			if(Player.getSatamina() < 30) {
				inter.setDisable(true);
			}
		}
		if(unit.isTreated()) {
			inter.setDisable(true);
		}
		this.setPrefHeight(250);
		this.setPrefWidth(500);
		this.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
		name = new Text(unit.getName());
		name.setFont(Font.font(24));
		conversation = new Text(unit.getConversation());
		conversation.setFont(Font.font(16));
		conversation.setWrappingWidth(200);
		conversation.setTextAlignment(TextAlignment.CENTER);
		describtion = new Text(unit.getDescribtion());
		describtion.setWrappingWidth(200);
		describtion.setFont(Font.font(14));
		image = new ImageView(unit.getImg());
		String t = "Trust : "+ String.valueOf(unit.getTrust()) + " %";
		trust = new Text(t);
		trust.setFont(Font.font(20));
		this.setAlignment(Pos.CENTER);
		this.setVgap(10);
		this.setHgap(30);
		this.setPadding(new Insets(10));
		this.add(inter, 1, 2);
		super.setHalignment(inter, HPos.LEFT);
		super.setValignment(inter, VPos.CENTER);
		this.add(name, 0, 0);
		super.setHalignment(name, HPos.CENTER);
		super.setValignment(name, VPos.CENTER);
		this.add(image, 0, 1);
		super.setHalignment(image, HPos.CENTER);
		super.setValignment(image, VPos.CENTER);
		this.add(trust, 1, 0);
		super.setHalignment(trust, HPos.CENTER);
		super.setValignment(trust, VPos.CENTER);
		this.add(describtion, 1, 1);
		super.setHalignment(describtion, HPos.CENTER);
		super.setValignment(describtion, VPos.CENTER);
		this.add(conversation, 0, 2);
		super.setHalignment(conversation, HPos.CENTER);
		super.setValignment(conversation, VPos.CENTER);
		
	}

	@Override
	public String toString() {
		return "Chat [name=" + name + ", trust=" + trust + ", conversation=" + conversation + ", describtion="
				+ describtion + "]";
	}

	public Text getName() {
		return name;
	}

	public void setName(Text name) {
		this.name = name;
	}

	public Text getTrust() {
		return trust;
	}

	public void setTrust(Text trust) {
		this.trust = trust;
	}

	public Text getConversation() {
		return conversation;
	}

	public void setConversation(Text conversation) {
		this.conversation = conversation;
	}

	public Text getDescribtion() {
		return describtion;
	}

	public void setDescribtion(Text describtion) {
		this.describtion = describtion;
	}

	public ImageView getImage() {
		return image;
	}

	public void setImage(ImageView image) {
		this.image = image;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chat other = (Chat) obj;
		if (conversation == null) {
			if (other.conversation != null)
				return false;
		} else if (!conversation.equals(other.conversation))
			return false;
		if (describtion == null) {
			if (other.describtion != null)
				return false;
		} else if (!describtion.equals(other.describtion))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (trust == null) {
			if (other.trust != null)
				return false;
		} else if (!trust.equals(other.trust))
			return false;
		return true;
	}
	
	

}
