package leibnizGFX;

public class Controller {
	private static Controller controller;
	
	
	private Controller(){}
	
	public static Controller getInstance() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	public void buildConstrolsWith(Player player) {
		Character playerChar = (Character)player;
		playerChar.getCharacterView().setFocusTraversable(true);
		
		playerChar.setOnKeyPressed(e-> {
			if(e.getCode().equals(GameSettings.moveRightKey)) {
				player.setMoveKey(GameSettings.moveRightKey);
			}
			else if(e.getCode().equals(GameSettings.moveLeftKey)) {
				player.setMoveKey(GameSettings.moveLeftKey);
			}
		});
		
		playerChar.setOnKeyReleased(e-> {
			if(e.getCode().equals(GameSettings.moveRightKey)) {
				player.setMoveKey(null);
			}
			else if(e.getCode().equals(GameSettings.moveLeftKey)) {
				player.setMoveKey(null);
			}
		});
	}
}
