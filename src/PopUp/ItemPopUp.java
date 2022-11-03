package PopUp;

import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.geometry.*;

import Character.Player;

public class ItemPopUp extends GridPane{
	
	public ItemPopUp() {
		String s = "Stamina : " + String.valueOf(Player.getSatamina());
		Text t = new Text(s);
		t.setFont(Font.font(20));
		this.setAlignment(Pos.CENTER);
		this.setPrefHeight(80);
		this.setPrefWidth(330);
		this.setVgap(10);
		this.setHgap(10);
		this.setPadding(new Insets(20));
		this.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
		this.add(t,0,0,5,1);
		super.setHalignment(t, HPos.CENTER);
		super.setValignment(t, VPos.CENTER);
		showItem();
	}
	
	public void showItem() {
		int n = Player.itemList.size();
		for(int i = 0; i < n; i++) {
			ItemPane it = new ItemPane();
			it.setItemOn(Player.itemList.get(i));
			this.add(it, i, 1);
		}
		for(int i = n; i < 5; i++) {
			ItemPane it = new ItemPane();
		    this.add(it, i, 1);
		}
	}
	
	
	
}
