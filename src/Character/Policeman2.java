package Character;

import Item.Item;
import render.RenderableHolder;

public class Policeman2 extends Unit{
	
	public Policeman2() {
		super("Mahone", RenderableHolder.policeSprite, "He is incharged of protecting maintainance room. "
				+ "If you work for him, maybe he will let you enter that room.");
		super.item = new Item("Key");
	}
	
	public String getConversation() {
		if(Trust < 80) {
			return "Stay away from this room. And go to mop the floor(30 satamina)";
		}
		return "Don't steal anything from maintainance room";
	}
	
	public void interact(int point) {
		super.treated = true;
	}
	
	@Override
	public String toString() {
		return "Policeman2 [Trust=" + Trust + ", Name=" + Name + ", Describtion=" + Describtion + "]";
	}
}
