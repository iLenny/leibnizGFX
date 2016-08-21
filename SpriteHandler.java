package leibnizGFX;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Leibniz H. Berihuete
 * Created on 8/21/2016
 */
public class SpriteHandler implements Updatable {
	private final Rectangle2D [] sprites;
	private final ImageView imageView;
	private int spriteCount = 0;
	private int delayCount = 0;
	private int delayAmount = 0;
	
	public SpriteHandler(ImageView imageView, Rectangle2D [] sprites) {
		this.sprites = sprites;
		this.imageView = imageView;
		imageView.setViewport(sprites[0]);
	}
	
	public SpriteHandler(ImageView imageView, Rectangle2D [] sprites, int delayAmount) {
		this.sprites = sprites;
		this.imageView = imageView;
		this.delayAmount = delayAmount;
		imageView.setViewport(sprites[0]);
	}
	
	
	
	@Override
	public void update() {
		if(delayCount >= delayAmount) {
			if(spriteCount < sprites.length-1) {
				spriteCount++;
				
			}
			else {
				spriteCount = 0;
			}		
			imageView.setViewport(sprites[spriteCount]);
			delayCount = 0;
		}
		else {
			delayCount++;
		}
		
	}
	
}
