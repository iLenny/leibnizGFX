package leibnizGFX;

import javafx.animation.AnimationTimer;
import javafx.application.Application;

public abstract class Game extends Application implements Updatable{
	int count = 0;
	double updateLength;
	public static double fps = 0.0;
	private static AnimationTimer gameloop;
	double lastTime = 0;
	
	public Game() {		
		gameloop = new AnimationTimer() {
			@Override
			public void handle(long currentNanoTime) {					
				update();
				Game.fps = 1_000_000_000.0 /(currentNanoTime - lastTime);
				lastTime = currentNanoTime;
			}
		};
	}
	
	public static void startGameLoop() {
		gameloop.start();
	}
	
	public static void stopGameLoop() {
		gameloop.stop();
	}
}
