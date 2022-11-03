package logic;

import javafx.scene.canvas.GraphicsContext;
import render.RenderableHolder;

public class BgSleep extends Entity{
	
	public BgSleep() {
		// TODO Auto-generated constructor stub
		this.z = 0;
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if(Background.n_bg == 9) {
			gc.drawImage(RenderableHolder.nightSprite, 0, 0);			
		}else if(Background.n_bg == 10) {
			gc.drawImage(RenderableHolder.outsideSprite, 0, 0);	
		}else if(Background.n_bg == 11) {
			gc.drawImage(RenderableHolder.deathSprite, 0, 0);	
		}
	}
	@Override
	public String toString() {
		return "BgSleep [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
}
