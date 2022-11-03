package Character;

import Item.Item;
import render.RenderableHolder;

public class Scofield extends Unit{
	
	public Scofield() {
		super("Scofield", RenderableHolder.scorfieldSprite ,"He is carpenter, he can craft a ladder. But he don't"
				+ " trust anyone. May be peace is not work.");
		super.item = new Item("Ladder");
	}
	
	public String getConversation() {
		if(Trust < 10) {
			return "Don't talk to me if you don't want to have any trouble";
		}
		if(Trust < 30) {
			return "Give me some food or go away from me";
		}
		if(Trust > 80) {
			return "How can I help you";
		}
		return "Hi, how are you";
	}
	
	public void interact(int point) {
		super.setTrust(getTrust() + point);
	}

	@Override
	public String toString() {
		return "Scofield [Trust=" + Trust + ", Name=" + Name + ", Describtion=" + Describtion + "]";
	}
	
	
}
