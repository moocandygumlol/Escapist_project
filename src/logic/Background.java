package logic;

import application.Main;
import javafx.scene.canvas.GraphicsContext;
import render.RenderableHolder;

public class Background extends Entity{
	public static int n_bg = 1;
	public Background() {
		// TODO Auto-generated constructor stub
		this.z = 20;
	}
	@Override
	public void draw(GraphicsContext gc) {
		if(!Main.isStart && n_bg == 1) {
			gc.drawImage(RenderableHolder.escapSprite, 0, 0);
			return;
		}else if(!Main.isStart && Background.n_bg == 2) {
			gc.drawImage(RenderableHolder.tutorial1Sprite, 0, 0);
			return;
		}else if(!Main.isStart && Background.n_bg == 3) {
			gc.drawImage(RenderableHolder.tutorial2Sprite, 0, 0);
			return;
		}
		if(n_bg == 1) {
			gc.drawImage(RenderableHolder.hallSprite, 0, 0);			
		}else if(n_bg == 3) {
			gc.drawImage(RenderableHolder.cellSprite, 0, 0);
		}else if(n_bg == 4) {
			gc.drawImage(RenderableHolder.canteenSprite, 0, 0);
		}else if(n_bg == 5) {
			gc.drawImage(RenderableHolder.fieldSprite, 0, 0);
		}else if(n_bg == 6) {
			gc.drawImage(RenderableHolder.maintainanceSprite, 0, 0);
		}else if(n_bg == 7) {
			gc.drawImage(RenderableHolder.toiletSprite, 0, 0);
		}else if(n_bg == 8) {
			gc.drawImage(RenderableHolder.tunnelSprite, 0, 0);
		}
	}
	@Override
	public String toString() {
		return "Background [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	

}
