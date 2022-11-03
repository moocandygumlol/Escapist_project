package PopUp;
import Character.Player;
import application.Main;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import render.RenderableHolder;

public class End extends GridPane{
	
	public End() {
		this.setVgap(10);
		Pane p = new Pane();
		p.setPrefSize(250, 100);
		this.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
		Text title = new Text();
		if(Player.day >= 0) {
			title.setText(" You win the game !!!");
			Main.winSound = RenderableHolder.winSound;
		}else {
			title.setText("You die !!!");
			Main.winSound = RenderableHolder.killSound;
		}
		Main.winSound.play(0.1);
		title.setFont(Font.font(24));
		this.setPrefWidth(250);
		this.setPrefHeight(100);
		this.add(title, 0, 0);
		super.setHalignment(title, HPos.CENTER);
		super.setValignment(title, VPos.CENTER);
		this.add(p, 0, 1);
		super.setHalignment(p, HPos.CENTER);
		super.setValignment(p, VPos.CENTER);
		super.setHalignment(p, HPos.CENTER);
		super.setValignment(p, VPos.CENTER);
		this.setPadding(new Insets(10));
		
	}

}

