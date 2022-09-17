package DrawBehavior;
import java.awt.Color;
import java.awt.Graphics2D;

import Main.GameObject;

public class DrawSimpleRec implements DrawBehavior{

	public void draw(Graphics2D g2d, GameObject go) {
		g2d = (Graphics2D) g2d.create();
		g2d.setColor(go.color);
		g2d.fillRect(go.x, go.y, go.width, go.height);
		
	}

}
