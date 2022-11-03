package logic;

import java.util.ArrayList;
import java.util.List;

import Character.*;
import javafx.stage.Stage;
import render.RenderableHolder;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	
	private Player player;
	private Background bg;
	private Npc npc;
	public static Unit beros;
	public static Unit scorfield;
	public static Unit police1;
	public static Unit police2;
	public static BgSleep night;
	
	
	public GameLogic(Stage stage) {
		gameObjectContainer = new ArrayList<Entity>();
		police1 = new Policeman1();
		police2 = new Policeman2();
		beros = new Beros();
		scorfield = new Scofield();
		player = new Player(25, 22, stage);
		bg = new Background();
		npc = new Npc();
		night = new BgSleep();
		addNewObject(player);
		addNewObject(bg);
		addNewObject(npc);
		addNewObject(night);
		
	}
	
	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public void logicUpdate() {
		player.update();
	}
	
	public static void updateTrust() {
		if(beros.isTreated()) {
			beros.setTrust(beros.getTrust() + 10);
			beros.resetTreated();
		}else {
			beros.setTrust(beros.getTrust() - 10);
		}
		if(police1.isTreated()) {
			police1.setTrust(police1.getTrust() + 10);
			police1.resetTreated();
		}else {
			police1.setTrust(police1.getTrust() - 10);
		}
		if(police2.isTreated()) {
			police2.setTrust(police2.getTrust() + 10);
			police2.resetTreated();
		}else {
			police2.setTrust(police2.getTrust() - 10);
		}
	}

	public List<Entity> getGameObjectContainer() {
		return gameObjectContainer;
	}

	public void setGameObjectContainer(List<Entity> gameObjectContainer) {
		this.gameObjectContainer = gameObjectContainer;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Background getBg() {
		return bg;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

	public Npc getNpc() {
		return npc;
	}

	public void setNpc(Npc npc) {
		this.npc = npc;
	}

	
}
