package Character;

import java.util.ArrayList;

import Item.Item;
import application.Main;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import logic.Background;
import logic.Entity;
import logic.GameLogic;
import logic.Map;
import render.RenderableHolder;

public class Player extends Entity{
//	private String name;
	private boolean isLeft = false;
	private boolean isRight = true;
	private boolean isBack = false;
	private boolean isPopUp = false;
	public static boolean noOneShowed = false;
	public static boolean isInven = false;
	public static Stage stage;
	public static boolean hasKey = false;
	public static boolean hasLadder = false;
	public static boolean hasShovel = false;
	public static boolean hasBurger = false;
	public static boolean hasKnife = false;
	public static boolean foodRecieved = false;
	private static int satamina;
	public static int escape = 0;	
	public static boolean isSleep = false;
	public static boolean isEnd = false;
	public static int day = 15;
	public static ArrayList<Item> itemList;
	
	public Player(int x, int y, Stage stage) {
		this.x = x;
		this.y = y;
		this.z = 10;
		this.stage = stage;
		satamina = 50;
		itemList = new ArrayList<Item>();
	}
	
	public static void setKey(boolean b) {
		hasKey = b;
	}
	
	public static int[][] field = Map.cell;
	
	public void update() {
		if(InputUtility.getKeyPressed(KeyCode.W) && !isSleep) {
			forward();
			isBack = true;
			isLeft = false;
			isRight = false;
		}else if(InputUtility.getKeyPressed(KeyCode.A) && !isSleep) {
			left();
			isBack = false;
			isLeft = true;
			isRight = false;
		}else if(InputUtility.getKeyPressed(KeyCode.D) && !isSleep) {
			right();
			isBack = false;
			isLeft = false;
			isRight = true;
		}else if(InputUtility.getKeyPressed(KeyCode.S) && !isSleep) {
			backward();
		}else if(InputUtility.getKeyPressed(KeyCode.I) && !isInven && !isSleep) {
			Main.openInven(stage);
		}else if(InputUtility.getKeyPressed(KeyCode.E) && !isSleep && !isEnd){
			if(((field[y][x+1] == -5 && isRight) || (field[y][x-1] == -5) && isLeft)) {
				if(day > 0) {
					Main.refresh();
					isSleep = true;
					Background.n_bg = 9;
					Main.justSleep(stage, this);	
					RenderableHolder.invenSound.play(0.2);
				}else {
					day--;
					isEnd = true;
					Background.n_bg = 11;
					Main.justEnd(stage, this);
				}
			}
			
		}
	}
	
	private void backward() {
		if(isPopUp) return;
		if(field[y+1][x] == 0) y++;
		else if(field[y+1][x] == 4) {
			Background.n_bg = 1;			
			field = Map.hall;
			this.x = 54;
			this.y = 17;
		}else if(field[y+1][x] == 9) {
			Background.n_bg = 1;			
			field = Map.hall;
			this.x = 7;
			this.y = 14;
		}
	}

	private void right() {
		if(isPopUp) return;
		if(field[y][x+1] == 0) x++;
		else if(field[y][x+1] == 4) {
			Background.n_bg = 1;			
			field = Map.hall;
			this.x = 1;
			this.y = 25;
		}else if(field[y][x+1] == 5) {
			Background.n_bg = 4;			
			field = Map.canteen;
			this.x = 1;
			this.y = 8;
		}
		else if(field[y][x+1] == 6) {
			Background.n_bg = 5;			
			field = Map.field;
			this.x = 1;
			this.y = 8;
		}else if(field[y][x+1] == 9) {
			Background.n_bg = 1;			
			field = Map.hall;
			this.x = 17;
			this.y = 30;
		}else if(field[y][x+1] == -1) {
			if(!isPopUp) {
				Main.interact(charUser(-1), stage, this);				
				isPopUp = true;
			}
		}else if(field[y][x+1] == -2) {
			if(!isPopUp) {
				Main.interact(charUser(-2), stage, this);				
				isPopUp = true;
			}
		}
	}

	private void left() {
		if(isPopUp) return;
		if(field[y][x-1] == 0) x--;
		else if(field[y][x-1] == 3) {
			Background.n_bg = 3;			
			field = Map.cell;
			this.x = 50;
			this.y = 22;
		}else if(field[y][x-1] == 4) {
			Background.n_bg = 1;			
			field = Map.hall;
			this.x = 55;
			this.y = 22;
		}else if(field[y][x-1] == 5) {
			Background.n_bg = 4;			
			field = Map.canteen;
			this.x = 55;
			this.y = 8;
		}else if(field[y][x-1] == -1) {
			if(!isPopUp) {
				Main.interact(charUser(-1), stage, this);				
				isPopUp = true;
			}
		}else if(field[y][x-1] == -4) {
			if(!isPopUp) {
				Main.interact(charUser(-4), stage, this);				
				isPopUp = true;
			}
		}else if(field[y][x-1] == -9 && !isEnd) {
			isEnd = true;
			Background.n_bg = 10;
			Main.justEnd(stage, this);				
		}
	}

	private void forward() {
		if(isPopUp) return;
		if(field[y-1][x] == 0)y--;
		else if(field[y-1][x] == 7 && hasKey) {
			Background.n_bg = 6;			
			field = Map.maintainance;
			this.x = 31;
			this.y = 27;
		}else if(field[y-1][x] == -1) {
			if(!isPopUp) {
				Main.interact(charUser(-1), stage, this);				
				isPopUp = true;
			}
		}else if(field[y-1][x] == -2) {
			if(!isPopUp) {
				Main.interact(charUser(-2), stage, this);				
				isPopUp = true;
			}
		}else if(field[y-1][x] == -3) {
			if(!isPopUp) {
				Main.interact(charUser(-3), stage, this);				
				isPopUp = true;
			}
		}else if(field[y-1][x] == -4) {
			if(!isPopUp) {
				Main.interact(charUser(-4), stage, this);				
				isPopUp = true;
			}
		}else if(field[y-1][x] == 8) {
			Background.n_bg = 7;			
			field = Map.toilet;
			this.x = 48;
			this.y = 28;
		}else if(field[y-1][x] == -6) {
			if(!foodRecieved && !hasBurger) {
				Main.getFood(stage, this);
				isPopUp = true;
			}
		}else if(field[y-1][x] == -7 ) {
			if(hasLadder && (escape >= 100)) {
				isBack = false;
	            isRight = false;
	            isLeft = true;
				Background.n_bg = 8;
	            field = Map.tunnel;
	            this.x = 57;
	            this.y = 10;
			}
			else {
				Main.openMine(stage, this);
				isPopUp = true;
				
			}  
        }else if(field[y-1][x] == -8 && !hasShovel) {
            Main.foundShovel(stage, this);
            isPopUp = true;
        }
	}
	
	private Unit charUser(int i) {
		if(i == -1) return GameLogic.police2;
		else if(i == -2) return GameLogic.police1;
		else if(i == -3) return GameLogic.beros;
		else if(i == -4) return GameLogic.scorfield;
		return GameLogic.beros;
	}

	@Override
	public void draw(GraphicsContext gc) {
		if(isBack) gc.drawImage(RenderableHolder.playerSpriteB, x * 16, y * 16);
		else if(isRight) gc.drawImage(RenderableHolder.playerSpriteR, x * 16, y * 16);
		else if(isLeft) gc.drawImage(RenderableHolder.playerSpriteL, x * 16, y * 16);
	}
	
	public void setDown() {
		isPopUp = false;
	}
	
	public static void setSatamina(int s) {
		if(s > 100) {
			s = 100;
		}
		else if(s < 0) {
			s = 0;
		}
		satamina = s;
	}
	
	public static int getSatamina() {
		return satamina;
	}
	
	public void setStartPlayer(int x, int y) {
		this.x = x;
		this.y = y;
		this.isBack = false;
		this.isLeft = false;
		this.isRight = true;
	}
	
	public static boolean hasItem(Item item) {
		if(item.getName().equals("Key")) {
			return hasKey;
		}
		else if(item.getName().equals("Buger")) {
			return hasBurger;
		}
		else if(item.getName().equals("Ladder")) {
			return hasLadder;
		}
		else if(item.getName().equals("Shovel")) {
			return hasShovel;
		}
		else if(item.getName().equals("Knife")) {
			return hasKnife;
		}
		else if(item.getName().equals("Moon")) {
			return noOneShowed;
		}
		return false;
	}
	
	public static void recieveItem(Item item) {
		if(!itemList.contains(item)) {
			itemList.add(item);
		}
		if(item.getName().equals("Key")) {
			hasKey = true;
		}
		else if(item.getName().equals("Burger")) {
			hasBurger = true;
		}
		else if(item.getName().equals("Ladder")) {
			hasLadder = true;
		}
		else if(item.getName().equals("Shovel")) {
			hasShovel = true;
		}
		else if(item.getName().equals("Knife")) {
			hasKnife = true;
		}
	}
	
	public static void removeItem(Item item) {
		int n = itemList.indexOf(item);
		itemList.remove(n);
		if(item.getName().equals("Key")) {
			hasKey = false;
		}
		else if(item.getName().equals("Burger")) {
			hasBurger = false;
		}
		else if(item.getName().equals("Ladder")) {
			hasLadder = false;
		}
		else if(item.getName().equals("Shovel")) {
			hasShovel = false;
		}
		else if(item.getName().equals("Knife")) {
			hasKnife = false;
		}
	}
	
	public static void setEscape(int point) {
		if(point > 100) {
			point = 100;
		}
		escape = point;
	}
	

}
