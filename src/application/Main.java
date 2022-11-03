package application;
	
import javafx.animation.AnimationTimer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import PopUp.*;

import java.util.ArrayList;

import Character.*;
import Item.Item;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;
import logic.Background;
import logic.GameLogic;
import logic.GameScreen;
import logic.Map;
import render.RenderableHolder;

public class Main extends Application {
	public static boolean isStart = false;
	public AudioClip mainSound = RenderableHolder.beginSound;
	public AudioClip inSound = RenderableHolder.inSound;
	public static AudioClip winSound;
	// Override the start method in the Application class
	public static void main(String[] args) {
		Application.launch(args);
	}
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Escapist game");

		GameLogic logic = new GameLogic(primaryStage);
		GameScreen gameScreen = new GameScreen(1024, 640);
		root.getChildren().add(gameScreen);
		gameScreen.requestFocus();
		primaryStage.setResizable(false);
		primaryStage.show();
		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.paintComponent();
				logic.logicUpdate();
				RenderableHolder.getInstance().update();	
				if(!mainSound.isPlaying() && !isStart) {
                    mainSound.play(0.1);
                }else if(isStart && !inSound.isPlaying()) {
                    mainSound.stop();
                    inSound.play(0.1);
                }else if(Player.isEnd) {
                    inSound.stop();
                }
			}
		};
		animation.start();
		
		startPage1(primaryStage);
	}
	
	public static void interact(Unit unit, Stage stage, Player player) {
		RenderableHolder.invenSound.play(0.2);
		if(unit.getTrust() < 80 || Player.hasItem(unit.getItem())){
			Chat c = new Chat(unit);
			Popup pop = new Popup();
			Button ok = new Button("close");
			ok.setPrefSize(80, 40);
			ok.setTextFill(Color.WHITE);
			ok.setFont(Font.font(20));
			ok.setBackground(new javafx.scene.layout.Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			ok.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					pop.hide();
					player.setDown();
					RenderableHolder.invenSound.play(0.2);
				}
			});
			c.add(ok, 1, 2);
			GridPane.setValignment(ok, VPos.CENTER);
			GridPane.setHalignment(ok, HPos.RIGHT);
			pop.getContent().add(c);
			pop.show(stage);
		}
		else if (unit.getTrust() >= 80 && !Player.hasItem(unit.getItem())){
			RenderableHolder.objectCatchSound.play(0.2);
			NewItem n = new NewItem(unit);
			Popup pop = new Popup();
			Button ok = new Button("close");
			ok.setPrefSize(80, 40);
			ok.setTextFill(Color.WHITE);
			ok.setFont(Font.font(20));
			ok.setBackground(new javafx.scene.layout.Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			ok.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					pop.hide();
					player.setDown();
					RenderableHolder.invenSound.play(0.2);
				}
			});
			n.add(ok, 0, 3);
			GridPane.setHalignment(ok, HPos.CENTER);
			GridPane.setValignment(ok, VPos.CENTER);
			pop.getContent().add(n);
			pop.show(stage);
		}
	}
	
	public static void openInven(Stage stage) {
		RenderableHolder.invenSound.play(0.2);
		ItemPopUp it = new ItemPopUp();
		Popup pop = new Popup();
		Button ok = new Button("close");
		ok.setPrefSize(80, 40);
		ok.setTextFill(Color.WHITE);
		ok.setFont(Font.font(20));
		ok.setBackground(new javafx.scene.layout.Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		ok.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				pop.hide();
				Player.isInven = false;
				RenderableHolder.invenSound.play(0.2);
			}
		});
		for(int i = 0; i < Player.itemList.size(); i++) {
			if(Player.itemList.get(i).getName().equals("Burger")) {
				Pane p = new Pane();
				p.setMaxHeight(50);
				p.setMinHeight(50);
				p.setMaxWidth(50);
				p.setMinWidth(50);
				p.setOnMouseClicked(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {
						pop.hide();
						for(int j = 0; j < Player.itemList.size(); j++) {
							if(Player.itemList.get(j).getName().equals("Burger")) {
								Player.itemList.remove(j);
								Player.hasBurger = false;
								Player.setSatamina(Player.getSatamina() + 50);
								openInven(stage);
							}
						}
					}
				});
				it.add(p, i, 1);
			}
		}
		
		it.add(ok, 0, 2,5,1);
		pop.getContent().add(it);
		GridPane.setHalignment(ok, HPos.CENTER);
		GridPane.setValignment(ok, VPos.CENTER);
		pop.show(stage);
		Player.isInven = true;
	}
	
	public static void refresh() {
		RenderableHolder.invenSound.play(0.2);
		GameLogic.updateTrust();
		Player.setSatamina(50);
		Player.foodRecieved = false;
		Player.noOneShowed = false;
	}
	
	public static void getFood(Stage stage, Player player) {
		RenderableHolder.objectCatchSound.play(0.2);
		Food f = new Food();
		Popup pop = new Popup();
		Button ok = new Button("close");
		ok.setPrefSize(80, 40);
		ok.setTextFill(Color.WHITE);
		ok.setFont(Font.font(20));
		ok.setBackground(new javafx.scene.layout.Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		ok.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				pop.hide();
				player.setDown();
			}
		});
		f.add(ok, 0, 3);
		pop.getContent().add(f);
		Player.foodRecieved = true;
		Player.recieveItem(new Item("Burger"));
		GridPane.setHalignment(ok, HPos.CENTER);
		GridPane.setValignment(ok, VPos.CENTER);
		pop.show(stage);
	}
	
	public static void openMine(Stage stage, Player player) {
		RenderableHolder.invenSound.play(0.2);
		Mining m = new Mining();
		Popup pop = new Popup();
		Button ok = new Button("close");
		ok.setPrefSize(80, 40);
		ok.setTextFill(Color.WHITE);
		ok.setFont(Font.font(20));
		ok.setBackground(new javafx.scene.layout.Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		ok.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				RenderableHolder.invenSound.play(0.2);
				pop.hide();
				player.setDown();
			}
		});
		m.add(ok, 0, 3);
		GridPane.setHalignment(ok, HPos.RIGHT);
		GridPane.setValignment(ok, VPos.CENTER);
		pop.getContent().add(m);
		pop.show(stage);
	}
	
	public static void rob(Stage stage) {
		RenderableHolder.objectCatchSound.play(0.2);
		NewItem n = new NewItem(GameLogic.scorfield);
		Popup pop = new Popup();
		Button ok = new Button("close");
		ok.setPrefSize(80, 40);
		ok.setTextFill(Color.WHITE);
		ok.setFont(Font.font(20));
		ok.setBackground(new javafx.scene.layout.Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		ok.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				RenderableHolder.invenSound.play(0.2);
				pop.hide();
			}
		});
		n.add(ok, 0, 3);
		GridPane.setHalignment(ok, HPos.CENTER);
		GridPane.setValignment(ok, VPos.CENTER);
		pop.getContent().add(n);
		pop.show(stage);
	}
	
	public static void justSleep(Stage stage, Player player) {
		RenderableHolder.invenSound.play(0.2);
		Player.day--;
        Sleep f = new Sleep();
        Popup pop = new Popup();
        Button ok = new Button("Next Day");
        ok.setPrefSize(120, 50);
		ok.setTextFill(Color.WHITE);
		ok.setFont(Font.font(20));
		ok.setBackground(new javafx.scene.layout.Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        ok.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	RenderableHolder.invenSound.play(0.2);
                pop.hide();
                Background.n_bg = 3;
                Player.field = Map.cell;
                Player.isSleep = false;
            }
        });
        f.add(ok, 0, 3);
        pop.getContent().add(f);
        GridPane.setHalignment(ok, HPos.CENTER);
        GridPane.setValignment(ok, VPos.CENTER);
        pop.show(stage);
    }
	
	public static void foundShovel(Stage stage, Player player) {
		RenderableHolder.objectCatchSound.play(0.2);
		ShovelPop n = new ShovelPop();
		Popup pop = new Popup();
		Button ok = new Button("close");
		ok.setPrefSize(80, 40);
		ok.setTextFill(Color.WHITE);
		ok.setFont(Font.font(20));
		ok.setBackground(new javafx.scene.layout.Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		ok.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				RenderableHolder.invenSound.play(0.2);
				pop.hide();
				player.setDown();
			}
		});
		n.add(ok, 0, 3);
		GridPane.setHalignment(ok, HPos.CENTER);
		GridPane.setValignment(ok, VPos.CENTER);
		pop.getContent().add(n);
		pop.show(stage);
		Player.recieveItem(new Item("Shovel"));
	}
	
	public static void justEnd(Stage stage, Player player) {
        End f = new End();
        Popup pop = new Popup();
        Button rs = new Button("Restart");
        rs.setPrefSize(100, 40);
		rs.setTextFill(Color.WHITE);
		rs.setFont(Font.font(20));
		rs.setBackground(new javafx.scene.layout.Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        Button end = new Button("End");
        end.setPrefSize(100, 40);
		end.setTextFill(Color.WHITE);
		end.setFont(Font.font(20));
		end.setBackground(new javafx.scene.layout.Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
        rs.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	RenderableHolder.invenSound.play(0.2);
            	pop.hide();
            	Background.n_bg = 3;
                restart(player);
                if(winSound.isPlaying()) {
                	winSound.stop();
                }
            }
        });
        end.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	RenderableHolder.invenSound.play(0.2);
                stage.close();
            }
        });
        f.add(rs, 0, 1);
        f.add(end, 0, 1);
        pop.getContent().add(f);
        GridPane.setHalignment(end, HPos.RIGHT);
        GridPane.setValignment(end, VPos.CENTER);
        GridPane.setHalignment(rs, HPos.LEFT);
        GridPane.setValignment(rs, VPos.CENTER);
        pop.show(stage);
    }
	
	public static void startPage1(Stage stage) {
		StartH f = new StartH();
        Popup pop = new Popup();
        Pane e = new Pane();
        Button end = new Button("Start");
		end.setFont(Font.font(26));;
		end.setBackground(new javafx.scene.layout.Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
        end.setPrefSize(120, 60);
        end.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	RenderableHolder.invenSound.play(0.2);
            	pop.hide();
                Background.n_bg = 2;
                startPage2(stage);
            }
        });
        f.add(e, 0, 0);
        f.add(end, 0, 52);
        pop.getContent().add(f);

        pop.show(stage);
    }
	
	public static void startPage2(Stage stage) {
		StartH f = new StartH();
        Popup pop = new Popup();
        Pane e = new Pane();
        Button end = new Button("Next");
        end.setFont(Font.font(26));
		end.setBackground(new javafx.scene.layout.Background(new BackgroundFill(Color.GOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
        end.setPrefSize(120, 60);
        end.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	RenderableHolder.invenSound.play(0.2);
                pop.hide();
                Background.n_bg = 3;
                startPage3(stage);
            }
        });
        f.add(e, 0, 0);
        f.add(end, 0, 52);
        pop.getContent().add(f);

        pop.show(stage);
    }
	
	public static void startPage3(Stage stage) {
		StartH f = new StartH();
        Popup pop = new Popup();
        Pane e = new Pane();
        Button end = new Button("Next");
        end.setFont(Font.font(26));
		end.setBackground(new javafx.scene.layout.Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
        end.setPrefSize(120, 60);
        end.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	RenderableHolder.invenSound.play(0.2);
            	pop.hide();
            	isStart = true;
            }
        });
        f.add(e, 0, 0);
        f.add(end, 0, 52);
        pop.getContent().add(f);

        pop.show(stage);
    }
	public static void restart(Player player) {
		RenderableHolder.invenSound.play(0.2);
		GameLogic.beros = new Beros();
		GameLogic.police1 = new Policeman1();
		GameLogic.police2 = new Policeman2();
		GameLogic.scorfield = new Scofield();
		Player.hasBurger = false;
		Player.hasKey = false;
		Player.hasKnife = false;
		Player.hasLadder = false;
		Player.hasShovel = false;
		Player.day = 15;
		Player.field = Map.cell;
		Player.setSatamina(50);
		Player.setEscape(0);
		Player.itemList = new ArrayList<Item>();
		Player.isSleep = false;
		Player.isInven = false;
		Player.isEnd = false;
		Player.foodRecieved = false;
		Player.noOneShowed = false;		
		player.setStartPlayer(25, 22);
	}
}
