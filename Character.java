package leibnizGFX;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
/**
 * 
 * @author Leibniz H. Berihuete
 * This class represents a character which can be used as a player or enemy.
 */
public class Character extends Pane implements Updatable{
	private String name;
	private double hp;
	private double speed;
	private double attackPower;	
	private ImageView characterView;
	private Behavior characterBehavior;
	private double currentGravityExerted = 0;
	
	
	
	/* ************************************
	 *            CONSTRUCTORS
	 * ************************************/
	/**
	 * Default Constructor<br>
	 * Default name: unknown<br>
	 * Default hp: 100.0<br>
	 * Default speed: 10.0<br>
	 * Default attackPower: 15.0<br>
	 */
	public Character() {
		name = "unknown";
		hp = 100.0;
		speed = 10;
		attackPower = 15;
		characterView = new ImageView();
		super.getChildren().add(characterView);
	}
	
	/**
	 * Character(String)
	 * Default hp: 100.0<br>
	 * Default speed: 10.0<br>
	 * Default attackPower: 15.0<br>
	 * @param name holds the name of the Character
	 */
	public Character(String name) {
		this.name = name;
		hp = 100.0;
		speed = 10;
		attackPower = 15;
		characterView = new ImageView();
		super.getChildren().add(characterView);
	}
	
	/**
	 * Character(String, double, double, double)
	 * @param name holds the name of the character
	 * @param hp holds the health points of the character
	 * @param speed holds the speed of the character
	 * @param attackPower holds the attack power of the character.
	 */
	public Character(String name, double hp, double speed, double attackPower) {
		this.name = name;
		this.hp = hp;
		this.speed = speed;
		this.attackPower = attackPower;
		characterView = new ImageView();
		super.getChildren().add(characterView);
	}
	
	/**
	 * Character(String, double, double, double, ImageView)
	 * @param name holds the name of the character
	 * @param hp holds the health points of the character
	 * @param speed holds the speed of the character
	 * @param attackPower holds the attack power of the character
	 * @param character holds the image view of the character
	 */
	public Character(String name, double hp, double speed, double attackPower, ImageView character) {
		this.name = name;
		this.hp = hp;
		this.speed = speed;
		this.attackPower = attackPower;
		this.characterView = character;
		super.getChildren().add(characterView);
	}
	
	
	/* *************************************
	 *              MUTATORS
	 * *************************************/
	public Character setName(String name) {
		this.name = name;
		return this;
	}
	
	public Character setHp(double hp) {
		this.hp = hp;
		return this;
	}
	
	public Character setSpeed(double speed) {
		this.speed = speed;
		return this;
	}
	
	public Character setAttackPower(double attackPower) {
		this.attackPower = attackPower;
		return this;
	}
	
	public Character setCharacterImg(Image characterImg) {
		this.characterView.setImage(characterImg);
		return this;
	}
	
	public Character setCharacterBehavior(Behavior characterBehavior) {
		this.characterBehavior = characterBehavior;
		return this;
	}
	
	public void setCurrentGravityExerted(double currentGravityExerted) {
		this.currentGravityExerted = currentGravityExerted;
	}
	
	/* *************************************
	 *              ACCESSORS
	 * *************************************/
	public String getName() {
		return name;
	}
	
	public double getHp() {
		return hp;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public double getAttackPower() {
		return attackPower;
	}
	
	public ImageView getCharacterView() {
		return characterView;
	}
	
	public double getCurrentGravityExerted() {
		return this.currentGravityExerted;
	}

	@Override
	public void update() {
		if(characterBehavior != null) {
			characterBehavior.performBehavior();
		}
		
	}
	

	
}
