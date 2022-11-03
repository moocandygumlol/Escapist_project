package PopUp;

import Character.Player;
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

public class Sleep extends GridPane{
	
	public Sleep() {
		this.setVgap(10);
		Pane p = new Pane();
		p.setPrefSize(50, 200);
		this.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
		Text title = new Text(Player.day + " Days left !!!");
		title.setFill(Color.RED);
		title.setFont(Font.font(24));
		this.setPrefWidth(50);
		this.setPrefHeight(50);
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
