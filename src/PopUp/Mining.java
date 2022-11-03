package PopUp;

import Character.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.GameLogic;
import render.RenderableHolder;

public class Mining extends GridPane{
	
	public Mining() {
		this.setVgap(20);
		this.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
		Text title = new Text("Escape Plan!!");
		title.setFont(Font.font(24));
		String comp = "Complete : " + String.valueOf(Player.escape);
		Text complete = new Text(comp);
		complete.setFont(Font.font(20));
		String warn = "";
		Button mine = new Button("Mine");
		mine.setPrefSize(80, 40);
		mine.setPrefSize(80, 40);
		mine.setTextFill(Color.WHITE);
		mine.setFont(Font.font(20));
		mine.setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
		mine.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				RenderableHolder.invenSound.play(0.2);
				Player.setEscape(Player.escape + (Player.getSatamina() / 2));
				Player.setSatamina(0);
				mine.setDisable(true);
			}
		});
		if(GameLogic.police1.getTrust() >= 80) {
			if(Player.hasShovel) {
				if(Player.escape < 100) {
					mine.setDisable(false);
					warn = "No policeman here tonight.";
				}
				else {
					if(!Player.hasLadder && Player.escape >= 100){
						warn = "You need ladder to climb out.";
						mine.setDisable(true);
					}
				}
			}
			else {
				warn = "You need to have shovel for mining.";
				mine.setDisable(true);
			}
		}
		else {
			warn = "Someone keeping an eye on you.";
			mine.setDisable(true);
		}
		if(Player.getSatamina() <= 0) {
			mine.setDisable(true);
		}
		this.setAlignment(Pos.CENTER);
		Text des = new Text(warn);
		des.setFill(Color.RED);
		des.setWrappingWidth(150);
		des.setTextAlignment(TextAlignment.CENTER);
		this.setHgap(10);
		this.setPrefWidth(300);
		this.setPrefHeight(200);
		this.add(title, 0, 0);
		super.setHalignment(title, HPos.CENTER);
		super.setValignment(title, VPos.CENTER);
		this.add(complete, 0, 1);
		super.setHalignment(complete, HPos.CENTER);
		super.setValignment(complete, VPos.CENTER);
		this.add(des, 0, 2);
		super.setHalignment(des, HPos.CENTER);
		super.setValignment(des, VPos.CENTER);
		this.add(mine, 0, 3);
		super.setHalignment(mine, HPos.LEFT);
		super.setValignment(mine, VPos.CENTER);
		this.setPadding(new Insets(10));
	}

}
