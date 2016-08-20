package leibnizGFX;

import javafx.scene.input.KeyCode;

public interface Player {
	public void setMoveKey(KeyCode moveKey);
	public void setJumpKey(KeyCode jumpKey);
	public void setAttackKey(KeyCode attackKey);
	public KeyCode getMoveKey();
	public KeyCode getJumpKey();
	public KeyCode getAttackKey();
}
