package logic;

import application.Main;
import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import render.IRenderable;
import render.RenderableHolder;


public class GameScreen extends Canvas{
	public GameScreen(double width, double height) {
		super(width, height);
		setVisible(true);
		addListener();
	}
	
	public void addListener() {
		setOnKeyPressed((KeyEvent event)->{
			InputUtility.setKeyPressed(event.getCode(), true);
		});
		
		setOnKeyReleased((KeyEvent event)->{
			InputUtility.setKeyPressed(event.getCode(), false);
		});
		
	}
	//draw
	public void paintComponent() {
		GraphicsContext gc = getGraphicsContext2D();
		for(IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			if(entity.isVisible() && !entity.isDestroyed() && Main.isStart) {
				entity.draw(gc);
			}else {
				if(entity instanceof Background) {
					entity.draw(gc);
				}
			}
		}
	}
}
	