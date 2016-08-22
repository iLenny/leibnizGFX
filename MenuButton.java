package leibnizGFX;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 * 
 * @author Leibniz H. Berihuete
 * This class represents a menu button, and it was coded in a builder-pattern style.
 * The class allows you to customize the button's background size, background color, background opacity,
 * text size, text color, text family, and text opacity.
 */
public class MenuButton extends StackPane {
	// DEFAULT VALUES FOR BACKGROUND:
	public static final double DEFAULT_BACKGROUND_WIDTH = 90;
	public static final double DEFAULT_BACKGROUND_HEIGHT = 45;
	public static final double DEFAULT_BACKGROUND_UNHOVER_OPACITY = 1.0;
	public static final double DEFAULT_BACKGROUND_HOVER_OPACITY = 1.0;	
	public static final Color DEFAULT_BACKGROUND_UNHOVER_COLOR = Color.BLACK;
	public static final Color DEFAULT_BACKGROUND_HOVER_COLOR = Color.WHITE;
	
	// DEFAULT VALUES FOR TEXT:
	public static final String DEFAULT_TEXT_FONT_FAMILY = "Papyrus";
	public static final double DEFAULT_TEXT_FONT_SIZE = 12;
	public static final double DEFAULT_TEXT_UNHOVER_OPACITY = 1.0;
	public static final double DEFAULT_TEXT_HOVER_OPACITY = 1.0;
	public static final Color DEFAULT_TEXT_UNHOVER_COLOR = Color.WHITE;
	public static final Color DEFAULT_TEXT_HOVER_COLOR = Color.BLACK;
	
	
	// MenuButton's components:
	private final Rectangle background;
	private final Label buttonLabel;
	
	// Button id;
	private int id;
	private static int buttonCount = -1;
	
	// Button Opacities:
	private double unhoverBGOpacity;
	private double unhoverTextOpacity;
	private double hoverBGOpacity;
	private double hoverTextOpacity;
	
	// Button Colors:
	private Color unhoverBGColor;
	private Color unhoverTextColor;
	private Color hoverBGColor;
	private Color hoverTextColor;
	
	
	
	
	/* **********************
	 *     CONSTRUCTORS
	 * **********************/	
	// Default Constructor
	public MenuButton () {
		id = ++buttonCount;
		background = new Rectangle(DEFAULT_BACKGROUND_WIDTH, DEFAULT_BACKGROUND_HEIGHT);
		buttonLabel = new Label("Button " + id);
		
		// Initialize opacities:
		unhoverBGOpacity = DEFAULT_BACKGROUND_UNHOVER_OPACITY;
		unhoverTextOpacity = DEFAULT_TEXT_UNHOVER_OPACITY;
		hoverBGOpacity = DEFAULT_BACKGROUND_HOVER_OPACITY;
		hoverTextOpacity = DEFAULT_TEXT_HOVER_OPACITY;
	
		background.setOpacity(unhoverBGOpacity);
		buttonLabel.setOpacity(unhoverTextOpacity);
		
		// Initialize color:
		unhoverBGColor = DEFAULT_BACKGROUND_UNHOVER_COLOR;
		unhoverTextColor = DEFAULT_TEXT_UNHOVER_COLOR;
		hoverBGColor = DEFAULT_BACKGROUND_HOVER_COLOR;
		hoverTextColor = DEFAULT_TEXT_HOVER_COLOR;
		
		background.setFill(unhoverBGColor);
		buttonLabel.setTextFill(unhoverTextColor);
		
		buildHoverFunctionality();
		
		getChildren().addAll(background, buttonLabel);
		
		
	
	}
	
	// Constructor(String)
	public MenuButton(String text) {
		id = ++buttonCount;
		background = new Rectangle(DEFAULT_BACKGROUND_WIDTH, DEFAULT_BACKGROUND_HEIGHT);
		buttonLabel = new Label(text);
		
		// Initialize opacities:
		unhoverBGOpacity = DEFAULT_BACKGROUND_UNHOVER_OPACITY;
		unhoverTextOpacity = DEFAULT_TEXT_UNHOVER_OPACITY;
		hoverBGOpacity = DEFAULT_BACKGROUND_HOVER_OPACITY;
		hoverTextOpacity = DEFAULT_TEXT_HOVER_OPACITY;
	
		background.setOpacity(unhoverBGOpacity);
		buttonLabel.setOpacity(unhoverTextOpacity);
		
		// Initialize color:
		unhoverBGColor = DEFAULT_BACKGROUND_UNHOVER_COLOR;
		unhoverTextColor = DEFAULT_TEXT_UNHOVER_COLOR;
		hoverBGColor = DEFAULT_BACKGROUND_HOVER_COLOR;
		hoverTextColor = DEFAULT_TEXT_HOVER_COLOR;
		
		background.setFill(unhoverBGColor);
		buttonLabel.setTextFill(unhoverTextColor);
		
		buildHoverFunctionality();
		
		getChildren().addAll(background, buttonLabel);
	}
	
	// Constructor(double, double)
	public MenuButton(double width, double height) {
		id = ++buttonCount;
		background = new Rectangle(width, height);
		buttonLabel = new Label("Button " + id);
		
		// Initialize opacities:
		unhoverBGOpacity = DEFAULT_BACKGROUND_UNHOVER_OPACITY;
		unhoverTextOpacity = DEFAULT_TEXT_UNHOVER_OPACITY;
		hoverBGOpacity = DEFAULT_BACKGROUND_HOVER_OPACITY;
		hoverTextOpacity = DEFAULT_TEXT_HOVER_OPACITY;
	
		background.setOpacity(unhoverBGOpacity);
		buttonLabel.setOpacity(unhoverTextOpacity);
		
		// Initialize color:
		unhoverBGColor = DEFAULT_BACKGROUND_UNHOVER_COLOR;
		unhoverTextColor = DEFAULT_TEXT_UNHOVER_COLOR;
		hoverBGColor = DEFAULT_BACKGROUND_HOVER_COLOR;
		hoverTextColor = DEFAULT_TEXT_HOVER_COLOR;
		
		background.setFill(unhoverBGColor);
		buttonLabel.setTextFill(unhoverTextColor);
		
		buildHoverFunctionality();
		
		getChildren().addAll(background, buttonLabel);
	}
	
	// Constructor (String, double, double)
	public MenuButton(String text, double width, double height) {
		id = ++buttonCount;
		background = new Rectangle(width, height);
		buttonLabel = new Label(text);
		
		// Initialize opacities:
		unhoverBGOpacity = DEFAULT_BACKGROUND_UNHOVER_OPACITY;
		unhoverTextOpacity = DEFAULT_TEXT_UNHOVER_OPACITY;
		hoverBGOpacity = DEFAULT_BACKGROUND_HOVER_OPACITY;
		hoverTextOpacity = DEFAULT_TEXT_HOVER_OPACITY;
	
		background.setOpacity(unhoverBGOpacity);
		buttonLabel.setOpacity(unhoverTextOpacity);
		
		// Initialize color:
		unhoverBGColor = DEFAULT_BACKGROUND_UNHOVER_COLOR;
		unhoverTextColor = DEFAULT_TEXT_UNHOVER_COLOR;
		hoverBGColor = DEFAULT_BACKGROUND_HOVER_COLOR;
		hoverTextColor = DEFAULT_TEXT_HOVER_COLOR;
		
		background.setFill(unhoverBGColor);
		buttonLabel.setTextFill(unhoverTextColor);
		
		buildHoverFunctionality();
		
		getChildren().addAll(background, buttonLabel);
	}	
	
	
	
	/* *********************
	 *       MUTATORS
	 * *********************/
	public MenuButton setText(String text) {
		buttonLabel.setText(text);
		return this;
	}
	
	public MenuButton setUnHoverTextColor(Color unhoverTextColor) {
		this.unhoverTextColor = unhoverTextColor;
		buttonLabel.setTextFill(unhoverTextColor);
		return this;
	}
	
	public MenuButton setHoverTextColor(Color hoverTextColor) {
		this.hoverTextColor = hoverTextColor;
		return this;
	}
	
	public MenuButton setTextSize(double textSize) {
		String currentFamily = buttonLabel.getFont().getFamily();
		buttonLabel.setFont(Font.font(currentFamily, textSize));
		return this;
	}	
	
	public MenuButton setTextFamily(String family) {
		double currentTextSize = buttonLabel.getFont().getSize();
		buttonLabel.setFont(Font.font(family, currentTextSize));
		return this;
	}	
	
	public MenuButton setUnHoverTextOpacity(double unhoverTextOpacity) {
		this.unhoverTextOpacity = unhoverTextOpacity;
		buttonLabel.setOpacity(unhoverTextOpacity);
		return this;
	}
	
	public MenuButton setHoverTextOpacity(double hoverTextOpacity) {
		this.hoverTextOpacity = hoverTextOpacity;
		return this;
	}
		
	public MenuButton setBackgroundWidth(double width) {
		background.setWidth(width);
		return this;
	}
		
	public MenuButton setBackgroundHeight(double height) {
		background.setHeight(height);
		return this;
	}
		
	public MenuButton setUnHoverBGColor(Color unhoverBGColor) {
		this.unhoverBGColor = unhoverBGColor;
		background.setFill(unhoverBGColor);
		return this;
	}
	
	public MenuButton setHoverBGColor(Color hoverBGColor) {
		this.hoverBGColor = hoverBGColor;
		return this;
	}
	
	public MenuButton setUnhoverBGOpacity(double unhoverBGOpacity) {
		this.unhoverBGOpacity = unhoverBGOpacity;
		background.setOpacity(unhoverBGOpacity);
		return this;
	}
	
	public MenuButton setHoverBGOpacity(double hoverBGOpacity) {
		this.hoverBGOpacity = hoverBGOpacity;
		return this;
	}
	
	
	
	/* **********************
	 *       ACCESSORS
	 * **********************/
	public int getButtonID() {
		return id;
	}
	
	public String getText() {
		return buttonLabel.getText();
	}
	
	public Color getUnHoverTextColor() {
		return unhoverTextColor;
	}
	
	public Color getHoverTextColor() {
		return hoverTextColor;
	}
	
	public double getTextSize() {
		return buttonLabel.getFont().getSize();
	}
	
	public String getTextFamily() {
		return buttonLabel.getFont().getFamily();
	}
	
	public double getUnHoverTextOpacity() {
		return unhoverTextOpacity;
	}
	
	public double getHoverTextOpacity() {
		return hoverTextOpacity;
	}
	
	public double getBackgroundWidth() {
		return background.getWidth();
	}
	
	public double getBackgroundHeight() {
		return background.getHeight();
	}
	
	public Color getUnHoverBGColor() {
		return unhoverBGColor;
	}
	
	public Color getHoverBGColor() {
		return hoverBGColor;
	}
	
	public double getUnHoverBGOpacity() {
		return unhoverBGOpacity;
	}
	
	public double getHoverBGOpacity() {
		return hoverBGOpacity;
	}
	
	
	/* ****************************
	 *     HOVER FUNCTIONALITY
	 * ****************************/
	private void buildHoverFunctionality() {
		// HOVER:
		setOnMouseEntered(e-> {
			setScaleX(1.05);
			setScaleY(1.05);
			background.setFill(getHoverBGColor());
			background.setOpacity(getHoverBGOpacity());
			buttonLabel.setTextFill(getHoverTextColor());
			buttonLabel.setOpacity(getHoverTextOpacity());
			
		});
		
		// UNHOVER:
		setOnMouseExited(e-> {
			setScaleX(1);
			setScaleY(1);
			background.setFill(getUnHoverBGColor());
			background.setOpacity(getUnHoverBGOpacity());
			buttonLabel.setTextFill(getUnHoverTextColor());
			buttonLabel.setOpacity(getUnHoverTextOpacity());
		});		
	}
	
	
	
	
	
	
	
	
	
}
