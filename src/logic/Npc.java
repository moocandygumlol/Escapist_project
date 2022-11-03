package logic;

import Character.Player;
import javafx.scene.canvas.GraphicsContext;
import render.RenderableHolder;

public class Npc extends Entity{
	
	public Npc() {
		// TODO Auto-generated constructor stub
		this.z = 15;
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if(Background.n_bg == 1) {
			gc.drawImage(RenderableHolder.policeSprite, 25 * 16, 14 * 16);			
		}else if(Background.n_bg == 4) {
			gc.drawImage(RenderableHolder.policeSprite, 24 * 16, 5 * 16);
		}else if(Background.n_bg == 5) {
			gc.drawImage(RenderableHolder.berosSprite, 56 * 16, 10 * 16);
		}else if(Background.n_bg == 7) {
			gc.drawImage(RenderableHolder.scorfieldSprite, 5 * 16, 11 * 16);
		}else if(Background.n_bg == 6 && !Player.hasShovel) {
            gc.drawImage(RenderableHolder.shovelSprite, 32 * 16, 13 * 16, 80, 30);
        }
	}
	@Override
	public String toString() {
		return "Npc [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
}
