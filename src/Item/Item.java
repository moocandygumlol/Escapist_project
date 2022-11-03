package Item;

import javafx.scene.image.Image;
import render.RenderableHolder;

public class Item {
	
	private String name;
	private int type;
	private Image img;
	private String describtion;
	
	public Item(String name) {
		this.name = name;
		if(name.equals("Key")) {
			img = RenderableHolder.keySprite;
			type = 1;
			describtion = "Use this key to enter Maintenance room.";
		}
		else if(name.equals("Shovel")) {
			img = RenderableHolder.shovelSprite;
			type = 2;
			describtion = "use this shovel to destroy break your cell.";
		}
		else if(name.equals("Ladder")) {
			img = RenderableHolder.ladderSprite;
			type = 3;
			describtion = "Use this ladder to climb out from your cell.";
		}
		else if(name.equals("Knife")) {
			img = RenderableHolder.knifeSprite;
			type = 4;
			describtion = "Use this knife to rob someone's item.";
		}
		else if(name.equals("Burger")) {
			img = RenderableHolder.burgerSprite;
			describtion = "Eat to recieved 50 stamina, or give to someone.";
		}
		else if(name.equals("Moon")) {
			img = RenderableHolder.moonSprite;
			describtion = "I will go home tonight, I hope you will not do anything stupid.";
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Image getImg() {
		return img;
	}
	
	public void setImg(Image img) {
		this.img = img;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public String getDescribtion() {
		return describtion;
	}
	
	public void setDescribtion(String description) {
		this.describtion = description;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (describtion == null) {
			if (other.describtion != null)
				return false;
		} else if (!describtion.equals(other.describtion))
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", type=" + type + ", describtion=" + describtion + "]";
	}
	
}
