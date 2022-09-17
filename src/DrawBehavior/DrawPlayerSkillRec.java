package DrawBehavior;

import java.awt.Color;
import java.awt.Graphics2D;

import Main.GameObject;
import Main.Player;

public class DrawPlayerSkillRec extends DrawBehaviorDecorator{

	public Color color;
//	public boolean fill;
	
	public DrawPlayerSkillRec(DrawBehavior base, Color color) {
		super(base);
		this.color = color;
//		this.fill = false;
	}

	@Override
	public void draw(Graphics2D g2d, GameObject go) {
		this.base.draw(g2d, go);
		g2d = (Graphics2D) g2d.create();
		g2d.setColor(this.color);
		
		Player p = Player.player;
		
		if(this.color.equals(Color.orange)){
			
			g2d.fillRect(p.x, p.y + p.height - (p.orange * p.height / p.MAX_SKILL), p.width, p.height / p.MAX_SKILL * p.orange);
			
		}
		
	}

}
