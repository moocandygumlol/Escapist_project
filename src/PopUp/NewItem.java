package PopUp;

import Character.Player;
import Character.Policeman1;
import Character.Unit;
import Item.Item;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class NewItem extends GridPane{
	
	public NewItem(Unit unit) {
		this.setVgap(10);
		Pane p = new Pane();
		Item item = unit.getItem();
		p.setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));
		p.setMaxWidth(100);
		p.setMaxHeight(100);
		p.setMinWidth(100);
		p.setMinHeight(100);
		this.setBackground(new Background(new BackgroundFill(Color.GOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
		ImageView iv = new ImageView(unit.getItem().getImg());
		if(item.getName().equals("Shovel")) {;
			iv.setFitWidth(96);
			iv.setFitHeight(60);
			iv.setY(20);
			iv.setX(2);
		}
		else if(item.getName().equals("Knife")) {
			iv.setFitHeight(96);
			iv.setFitWidth(40);
			iv.setX(30);
			iv.setY(2);
		}
		else if(item.getName().equals("Ladder")) {
			iv.setFitHeight(96);
			iv.setFitWidth(60);
			iv.setX(20);
			iv.setY(2);
		}
		else if(item.getName().equals("Key")) {
			iv.setFitWidth(80);
			iv.setFitHeight(40);
			iv.setX(10);
			iv.setY(30);
		}
		else if(item.getName().equals("Moon")) {
			iv.setFitWidth(100);
			iv.setFitHeight(100);
		}
		Text title = new Text("You got new item!!");
		if(unit instanceof Policeman1) {
			title.setText("No One here tonight!!");
			Player.noOneShowed = true;
		}
		else {
			Player.recieveItem(item);
		}
		p.getChildren().add(iv);
		Text des = new Text(unit.getItem().getDescribtion());
		des.setWrappingWidth(150);
		des.setTextAlignment(TextAlignment.CENTER);
		this.setPrefWidth(180);
		this.setPrefHeight(230);
		this.add(title, 0, 0);
		super.setHalignment(title, HPos.CENTER);
		super.setValignment(title, VPos.CENTER);
		this.add(p, 0, 1);
		super.setHalignment(p, HPos.CENTER);
		super.setValignment(p, VPos.CENTER);
		this.add(des, 0, 2);
		super.setHalignment(p, HPos.CENTER);
		super.setValignment(p, VPos.CENTER);
		this.setPadding(new Insets(10));
		
	}

}
