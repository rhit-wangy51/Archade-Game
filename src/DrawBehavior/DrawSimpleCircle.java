package DrawBehavior;
import java.awt.Color;
import java.awt.Graphics2D;

import Main.GameObject;

public class DrawSimpleCircle implements DrawBehavior{

	
	public void draw(Graphics2D g2d, GameObject go) {
//		System.out.println(go.color);
		g2d = (Graphics2D) g2d.create();
		g2d.setColor(go.color);
		g2d.fillOval(go.x, go.y, go.width, go.height);
		
	}

}
