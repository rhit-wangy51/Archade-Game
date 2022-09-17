package DrawBehavior;
import java.awt.Graphics2D;

import Main.GameObject;

public interface DrawBehavior {
	
	public void draw(Graphics2D g2d, GameObject go);
}
