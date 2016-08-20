package leibnizGFX;

/**
 * 
 * @author Leibniz H. Berihuete
 * Created on 8/19/2016
 * This class represents the player behavior
 */
public class PlayerBehavior implements Behavior {
	private Character playerChar;
	private Player player;
	/**
	 * Constructor(player)
	 * @param player holds the character player
	 */
	public PlayerBehavior(Player player) {
		this.playerChar = ((Character)player);
		this.player = player;
	}
	
	@Override
	public void performBehavior() {
		if(player.getMoveKey()!= null && player.getMoveKey().equals(GameSettings.moveRightKey)) {
			playerChar.setTranslateX(playerChar.getTranslateX() + playerChar.getSpeed());
		}
		else if(player.getMoveKey()!= null && player.getMoveKey().equals(GameSettings.moveLeftKey)) {
			playerChar.setTranslateX(playerChar.getTranslateX() - playerChar.getSpeed());
		} 
	}

}
