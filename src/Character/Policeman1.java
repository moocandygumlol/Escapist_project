package Character;

import Item.Item;
import render.RenderableHolder;

public class Policeman1 extends Unit{
	
	public Policeman1() {
		super("Bratt", RenderableHolder.policeSprite , "He is an officer who keeping an eye on you every night."
				+ "If you be nice to him, maybe he will leave you alone some night.");
		super.item = new Item("Moon");
	}
	
	public String getConversation() {
		if(Trust < 80) {
			return "Don't do anything stupid tonight. And do laundry. (30 satamina)";
		}
		return "I will go home tonight.";
	}
	
	public void interact(int point) {
		super.treated = true;
	}

	@Override
	public String toString() {
		return "Policeman1 [Trust=" + Trust + ", Name=" + Name + ", Describtion=" + Describtion + "]";
	}
}
