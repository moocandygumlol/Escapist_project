package Character;

import Item.Item;
import javafx.scene.image.Image;

public abstract class Unit {

	@Override
	public String toString() {
		return "Unit [Trust=" + Trust + ", Name=" + Name + ", Describtion=" + Describtion + "]";
	}

	protected int Trust;
	protected String Name;
	protected Image img;
	protected String Describtion;
	protected Item item;
	protected boolean treated;
	
	public Unit(String Name, Image img, String des) {
		setName(Name);
		setTrust(50);
		setImg(img);
		Describtion = des;
		treated = false;
	}
	
	public abstract String getConversation();
	
	public abstract void interact(int point);

	public int getTrust() {
		return Trust;
	}

	public void setTrust(int trust) {
		if(trust >= 100) {
			trust = 100;
		}
		else if(trust < 0) {
			trust = 0;
		}
		Trust = trust;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	public void setImg(Image img) {
		this.img = img;
	}
	
	public Image getImg() {
		return img;
	}
	
	public String getDescribtion() {
		return Describtion;
	}
	
	public void setDescription(String description) {
		Describtion = description;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Boolean isTreated() {
		return treated;
	}
	
	public void resetTreated() {
		treated = false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unit other = (Unit) obj;
		if (Describtion == null) {
			if (other.Describtion != null)
				return false;
		} else if (!Describtion.equals(other.Describtion))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Trust != other.Trust)
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (treated != other.treated)
			return false;
		return true;
	}
	
	
}
