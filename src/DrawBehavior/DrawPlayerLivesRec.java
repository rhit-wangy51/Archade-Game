package DrawBehavior;

import java.awt.Color;
import java.awt.Graphics2D;

import Main.GameObject;
import Main.Player;

public class DrawPlayerLivesRec extends DrawBehaviorDecorator{
	
	Color color;
	
	public DrawPlayerLivesRec(DrawBehavior base, Color color) {
		super(base);
		this.color = color;
	}

	@Override
	public void draw(Graphics2D g2d, GameObject go) {
		this.base.draw(g2d, go);
		g2d = (Graphics2D) g2d.create();
		g2d.setColor(this.color);
		
		Player p = Player.player;
		
		g2d.drawRect(0, 0, p.width * p.MAX_LIVES, p.height / 2);
		g2d.fillRect(0, 0, p.width * p.lives, p.height / 2);
		
//		g2d.fillRect(go.x, go.y + ((p.MAX_LIVES - p.lives) * p.height / p.MAX_LIVES), p.width, p.height / p.MAX_LIVES * p.lives);
		
//		else if(this.color.equals(Color.orange)){
//			g2d.fillRect(p.x, p.y + p.height - (p.orange * p.height / 6), p.width, p.height / 6 * p.orange);
//		}
		
	}

}
