package PopUp;

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

public class Food extends GridPane{
	
	public Food() {
		this.setVgap(10);
		Pane p = new Pane();
		Item item = new Item("Burger");
		p.setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));
		p.setMaxWidth(100);
		p.setMaxHeight(100);
		p.setMinWidth(100);
		p.setMinHeight(100);
		this.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
		ImageView iv = new ImageView(item.getImg());
		iv.setFitWidth(90);
		iv.setFitHeight(90);
		iv.setX(5);
		iv.setY(5);
		p.getChildren().add(iv);
		Text title = new Text("Here is your food.");
		Text des = new Text(item.getDescribtion());
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
