package leibnizGFX;

import javafx.scene.input.KeyCode;

public final class GameSettings {
	// WINDOW SIZE:
	public static final int WINDOW_WIDTH = 950;
	public static final int WINDOW_HEIGHT = 600;
	
	// DEFAULT KEY CONTROLS:
	public static final KeyCode DEFAULT_MOVE_LEFT_KEY = KeyCode.LEFT;
	public static final KeyCode DEFAULT_MOVE_RIGHT_KEY = KeyCode.RIGHT;
	public static final KeyCode DEFAULT_JUMP_KEY = KeyCode.UP;
	public static final KeyCode DEFAULT_ATTACK_KEY = KeyCode.SPACE;
	
	// KEY CONTROLS:
	public static KeyCode moveLeftKey = DEFAULT_MOVE_LEFT_KEY;
	public static KeyCode moveRightKey = DEFAULT_MOVE_RIGHT_KEY;
	public static KeyCode jumpKey = DEFAULT_JUMP_KEY;
	public static KeyCode attackKey = DEFAULT_ATTACK_KEY;
}
