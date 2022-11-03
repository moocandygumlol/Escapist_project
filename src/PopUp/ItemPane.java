package PopUp;

import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import Item.Item;
import javafx.geometry.*;

public class ItemPane extends Pane{
	
	public ItemPane() {
		this.setPrefWidth(50);
		this.setPrefHeight(50);
		this.setMinHeight(50);
		this.setMinWidth(50);
		setEmpty();
	}
	
	
	public void setEmpty() {
		this.setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void setItemOn(Item item) {
		ImageView iv = new ImageView(item.getImg());
		if(item.getName().equals("Shovel")) {;
			iv.setFitWidth(48);
			iv.setFitHeight(30);
			iv.setY(10);
			iv.setX(1);
		}
		else if(item.getName().equals("Knife")) {
			iv.setFitHeight(48);
			iv.setFitWidth(20);
			iv.setX(15);
			iv.setY(1);
		}
		else if(item.getName().equals("Ladder")) {
			iv.setFitHeight(48);
			iv.setFitWidth(30);
			iv.setX(10);
			iv.setY(1);
		}
		else if(item.getName().equals("Key")) {
			iv.setFitWidth(40);
			iv.setFitHeight(20);
			iv.setX(5);
			iv.setY(15);
		}
		this.getChildren().add(iv);
	}

}
