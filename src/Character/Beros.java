package Character;

import Item.Item;
import render.RenderableHolder;

public class Beros extends Unit{



	public Beros() {
		super("Beros", RenderableHolder.berosSprite , "He is the biggest guy here, if you need to stay peacefully here "
				+ "you need to avoid to make him angry. And if you give him some food everyday He will trust you,"
				+ " maybe he will give you some knife to protect yourself.");
		super.item = new Item("Knife");
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
		super.treated = true;
	}
	
	@Override
	public String toString() {
		return "Beros [Trust=" + Trust + ", Name=" + Name + ", Describtion=" + Describtion + "]";
	}
}
