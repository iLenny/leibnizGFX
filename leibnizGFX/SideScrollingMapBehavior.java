package leibnizGFX;

import java.util.ArrayList;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

/**
 * 
 * @author Leibniz H. Berihuete
 * Created on 8/19/2016<br>
 * This is a side scrolling map behavior. 
 */
public class SideScrollingMapBehavior implements Behavior {
	private Character player;
	private Map map;
	private ImageView backgroundView;
	private ImageView mapView;
	private ArrayList<Node> nodeList;
	private ArrayList<CollisionObject> collisionObjList;
	private KeyCode moveKey;
	
	private double rightMovingPoint;
	private double leftMovingPoint;
	private double mapViewWidth;
	
	/* ********************************
	 *         CONSTRUCTORS
	 * ********************************/
	/**
	 * Constructor(Map)<br>
	 * @param map holds an instance of the map class
	 */
	public SideScrollingMapBehavior(Map map) {
		this.map = map;
		this.player = (Character)map.getPlayer();
		this.backgroundView = map.getBackgroundView();
		this.mapView = map.getMapView();
		this.nodeList = map.getNodeList();
		this.collisionObjList = map.getCollisionObjList();
		this.moveKey = map.getPlayer().getMoveKey();
	
		rightMovingPoint = GameSettings.WINDOW_WIDTH * 0.7; // 70% of the window
		leftMovingPoint = GameSettings.WINDOW_HEIGHT * 0.3; // 30% of the window
		
		mapViewWidth = mapView.getImage().getWidth();
	}
	
	// Move all items inside the map to the left:
	public void moveEverythingToLeft(double mapX) {
		if(mapX > -(mapViewWidth)) {
			backgroundView.setTranslateX(backgroundView.getTranslateX() - player.getSpeed()/5);
			mapView.setTranslateX(mapView.getTranslateX() - player.getSpeed());
			player.setTranslateX(player.getTranslateX() - player.getSpeed());
			
			for(int i = 0; i < nodeList.size(); i++) {
				Node node = nodeList.get(i);
				node.setTranslateX(node.getTranslateX() - player.getSpeed());
			}
			
			for(int i = 0; i < collisionObjList.size(); i++) {
				CollisionObject collisionObject = collisionObjList.get(i);
				collisionObject.setTranslateX(collisionObject.getTranslateX() - player.getSpeed());
			}
		}
	}
	
	// Move all items inside the map to the right:
	private void moveEverythingToRight(double mapX) {
		if(mapX <= 0) {
			backgroundView.setTranslateX(backgroundView.getTranslateX() + player.getSpeed()/5);
			mapView.setTranslateX(mapView.getTranslateX() + player.getSpeed());
			player.setTranslateX(player.getTranslateX() + player.getSpeed());
			
			for(int i = 0; i < nodeList.size(); i++) {
				Node node = nodeList.get(i);
				node.setTranslateX(node.getTranslateX() + player.getSpeed());
			}
			
			for(int i = 0; i < collisionObjList.size(); i++) {
				CollisionObject collisionObject = collisionObjList.get(i);
				collisionObject.setTranslateX(collisionObject.getTranslateX() + player.getSpeed());
			}			
		}
	}
	
	
	
	
	
	@Override
	public void performBehavior() {
		// MapView Bounds:
		Bounds mapBounds = mapView.localToScene(mapView.getBoundsInLocal());
		double mapX = mapBounds.getMinX();
		double mapY = mapBounds.getMinY();
		
		// Player Bounds
		Bounds playerBounds = player.localToScene(player.getBoundsInLocal());
		double playerX = playerBounds.getMinX();
		double playerY = playerBounds.getMinY();
		moveKey = ((Player)player).getMoveKey();
		
		if(moveKey != null) {
			// if player is on the rightMovingPoint, and moving RIGHT
			if(playerX > rightMovingPoint && moveKey.equals(GameSettings.moveRightKey)) {
				System.out.println("TRUE TRUE TRUE");
				moveEverythingToLeft(mapX);
			}
			// if player is on the rightMovingPoint, and moving LEFT
			else if(playerX < leftMovingPoint && moveKey.equals(GameSettings.moveLeftKey)) {
				moveEverythingToRight(mapX);		
			}
		}
		
		
		System.out.println("PlayerX: " + playerX);
				
	}
}
