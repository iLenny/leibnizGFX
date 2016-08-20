package leibnizGFX;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * 
 * @author Leibniz H. Berihuete
 * Map Class<br>
 * The purpose of this class is to represent the world<br>
 * in which the user can interact with.
 */
public class Map extends Pane implements Updatable {
	private ImageView backgroundView;
	private ImageView mapView;	
	private ArrayList<Node> nodeList;
	private ArrayList<CollisionObject> collisionObjList;	
	private double gravity;
	private Character player;
	private Behavior mapBehavior;
	
	/* **************************
	 *       CONSTRUCTORS
	 * **************************/	
	/**
	 * Constructor(Player player)<br>
	 * Default gravity: 9.8
	 * @param player holds the character that the user is playing with.
	 */
	public Map(Player player) {
		backgroundView = new ImageView();
		mapView = new ImageView();
		nodeList = new ArrayList<Node>();
		collisionObjList = new ArrayList<CollisionObject>();
		gravity = 9.8;
		this.player = (Character)player;
		super.getChildren().addAll(backgroundView, mapView, this.player);
	}
	
	/**
	 * Constructor(Player, ImageView, ImageView)<br>
	 * Default gravity: 9.8
	 * @param player holds the character that the user is playing with.
	 * @param backgroundView holds the background view of the map
	 * @param mapView holds the map view of the map.
	 */
	public Map(Player player, ImageView backgroundView, ImageView  mapView) {
		this.backgroundView = backgroundView;
		this.mapView = mapView;
		nodeList = new ArrayList<Node>();
		collisionObjList = new ArrayList<CollisionObject>();
		gravity = 9.8;
		this.player = (Character)player;
		super.getChildren().addAll(backgroundView, mapView, this.player);
	}
	
	/**
	 * Constructor(Player, ImageView, ImageView, Behavior)<br>
	 * Default gravity: 9.8
	 * @param player holds the character that the user is playing with.
	 * @param backgroundView holds the background view of the map
	 * @param mapView holds the map view of the map.
	 * @param mapBehavior holds the behavior of the map
	 */
	public Map(Player player, ImageView backgroundView, ImageView  mapView, Behavior mapBehavior) {
		this.backgroundView = backgroundView;
		this.mapView = mapView;
		nodeList = new ArrayList<Node>();
		collisionObjList = new ArrayList<CollisionObject>();
		gravity = 9.8;
		this.player = (Character)player;
		this.mapBehavior = mapBehavior;
		super.getChildren().addAll(backgroundView, mapView, this.player);
	}
	
	
	/* **************************
	 *         MUTATORS
	 * **************************/	
	public Map setBackgroundImage(Image backgroundImage) {
		this.backgroundView.setImage(backgroundImage);
		return this;
	}
	
	public Map setMapImage(Image mapImage) {
		this.mapView.setImage(mapImage);
		return this;
	}
	
	public Map setGravity(double gravity) {
		this.gravity = gravity;
		return this;
	}
	
	public Map setMapBehavior(Behavior mapBehavior) {
		this.mapBehavior = mapBehavior;
		return this;
	}
	
	public void setPlayer(Player player) {
		this.player = (Character) player;
	}
	
	public void addNode(Node node, double x, double y) {
		node.relocate(x, y);
		nodeList.add(node);
		super.getChildren().add(2, node);
	}
	
	public void addCollisionObject(CollisionObject obj, double x, double y) {
		obj.relocate(x, y);
		collisionObjList.add(obj);
		super.getChildren().add(2, obj);
	}
	
	/* **************************
	 *       ACCESSORS
	 * **************************/
	public ImageView getBackgroundView() {
		return backgroundView;
	}
	
	public ImageView getMapView() {
		return mapView;
	}
	
	public double getGravity() {
		return gravity;
	}
	
	public ArrayList<Node> getNodeList() {
		return nodeList;
	}
	
	public ArrayList<CollisionObject> getCollisionObjList() {
		return collisionObjList;
	}
	
	public Player getPlayer() {
		return (Player)player;
	}	
	
	
	@Override
	public void update() {
		player.update();
		if(mapBehavior != null) {
			mapBehavior.performBehavior();
		}
		
		
	}
	
}
