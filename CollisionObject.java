package leibnizGFX;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * 
 * @author Leibniz H. Berihuete
 * Created on 8/20/2016
 * This class creates 4 rectangular bars, and together they form a single rectangle<br>
 * The bars: leftBar, rightBar, upBar, downBar can push an object left, right, up,<br>
 * and down perspectively.
 */
public class CollisionObject extends Pane implements Updatable{
	private double thickness;
	private Rectangle leftBar;
	private Rectangle rightBar;
	private Rectangle upBar;
	private Rectangle downBar;
	private Node leftNode;
	private Node rightNode;
	private Node upNode;
	private Node downNode;
	private double leftPushMagnitude;
	private double rightPushMagnitude;
	private double upPushMagnitude;
	private double downPushMagnitude;
	
	
	/* ***********************
	 *      CONSTRUCTORS
	 * ***********************/
	/**
	 * Constructor(double, double)
	 * @param width holds the width of the collision object
	 * @param height holds the height of the collision object
	 */
	public CollisionObject(double width, double height) {
		thickness = 5;
		leftBar = new Rectangle(thickness, height);
		rightBar = new Rectangle(thickness, height);
		upBar = new Rectangle(width, thickness);
		downBar = new Rectangle(width, thickness);
		
		rightBar.setTranslateX(width-thickness);
		downBar.setTranslateY(height-thickness);
		
		leftBar.setFill(Color.LIGHTBLUE);
		rightBar.setFill(Color.LIGHTBLUE);
		
		upBar.setFill(Color.CHARTREUSE);
		downBar.setFill(Color.RED);
		
		super.getChildren().addAll(leftBar, rightBar, upBar, downBar);
	}
	
	/**
	 * Constructor(Image)
	 * @param image holds the Image of the collision object
	 */
	public CollisionObject(Image image) {
		thickness = 5;
		leftBar = new Rectangle(thickness, image.getHeight());
		rightBar = new Rectangle(thickness, image.getHeight());
		upBar = new Rectangle(image.getWidth(), thickness);
		downBar = new Rectangle(image.getWidth(), thickness);
		
		rightBar.setTranslateX(image.getWidth()-thickness);
		downBar.setTranslateY(image.getHeight()-thickness);
		
		leftBar.setFill(Color.LIGHTBLUE);
		rightBar.setFill(Color.LIGHTBLUE);
		
		upBar.setFill(Color.CHARTREUSE);
		downBar.setFill(Color.RED);
		
		super.getChildren().addAll(new ImageView(image),leftBar, rightBar, upBar, downBar);
	}
	
	
	/* ***********************
	 *        MUTATORS
	 * ***********************/	
	
	public void setThickness(double thickness) {
		this.thickness = thickness;
		leftBar.setWidth(thickness);
		rightBar.setWidth(thickness);
		upBar.setHeight(thickness);
		downBar.setHeight(thickness);
		
		rightBar.setTranslateX(downBar.getWidth()-thickness);
		downBar.setTranslateY(rightBar.getHeight()-thickness);
		
	}
	public void hideBars(boolean hide) {
		leftBar.setVisible(hide);
		rightBar.setVisible(hide);
		upBar.setVisible(hide);
		downBar.setVisible(hide);		
	}
	
	public void buildLeftCollisionWith(Node leftNode, double leftPushMagnitude) {
		this.leftNode = leftNode;
		this.leftPushMagnitude = leftPushMagnitude;
	}
	
	public void buildRightCollisionWith(Node rightNode, double rightPushMagnitude) {
		this.rightNode = rightNode;
		this.rightPushMagnitude = rightPushMagnitude;
	}
	
	public void buildUpCollisionWith(Node upNode, double upPushMagnitude) {
		this.upNode = upNode;
		this.upPushMagnitude = upPushMagnitude;
	}
	
	public void buildDownCollisionWith(Node downNode, double downPushMagnitude) {
		this.downNode = downNode;
		this.downPushMagnitude = downPushMagnitude;
	}
	
	private void pushX(Node node, Rectangle bar, double magnitude) {
		Bounds nodeBounds = node.localToScene(node.getBoundsInLocal());
		Bounds barBounds = bar.sceneToLocal(bar.getBoundsInLocal());
		if(nodeBounds.intersects(barBounds)) {
			node.setTranslateX(node.getTranslateX() + magnitude);
		}
	}
	
	private void pushY(Node node, Rectangle bar, double magnitude) {
		Bounds nodeBounds = node.localToScene(node.getBoundsInLocal());
		Bounds barBounds = bar.sceneToLocal(bar.getBoundsInLocal());
		if(nodeBounds.intersects(barBounds)) {
			node.setTranslateY(node.getTranslateY() + magnitude);
		}
	}

	@Override
	public void update() {
		if(leftNode != null) {
			pushX(leftNode, leftBar, -leftPushMagnitude);
		}
		
		if(rightNode != null) {
			pushX(rightNode, rightBar, rightPushMagnitude);
		}
		
		if(upNode != null) {
			pushY(upNode, upBar, -upPushMagnitude);
		}
		
		if(downNode != null) {
			pushY(downNode, downBar, downPushMagnitude);
		}
	}
	
	
	
}
