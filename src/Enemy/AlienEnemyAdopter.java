package Enemy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.concurrent.ThreadLocalRandom;

import Alien.Alien;
import DrawBehavior.DrawBase;
import Main.Component;
import Main.GameObject;

public class AlienEnemyAdopter extends Enemy{
	
	private Alien underlying;

	public AlienEnemyAdopter() {

		int x = ThreadLocalRandom.current().nextInt(0, Component.WIDTH - underlying.ALIEN_RADIUS * 2);
		int y = ThreadLocalRandom.current().nextInt(0, Component.HEIGHT - underlying.ALIEN_RADIUS * 2);
		this.underlying = new Alien(x, y);
	}
	
	@Override
	public void setSize() {
//		System.out.println("set size");
		this.width = this.underlying.ALIEN_RADIUS * 2;
		this.height = this.underlying.ALIEN_RADIUS * 2;
//		System.out.println(this.width + " " + this.height);
	}
	
	@Override
	public void setSpeed() {
		this.xVel = this.underlying.getxVel();
		this.yVel = this.underlying.getyVel();
	}
	
	@Override
	public void setLocation() {
		this.x = this.underlying.getX();
		this.y = this.underlying.getY();
//		System.out.println(this.x);
	}
	
	@Override
	public void setSpecialAndColor() {
		super.setSpecialAndColor();
//		this.color = Color.white;
		
	}

	@Override
	public void setAttackAndLives() {
		this.attack = 1;
		this.lives = -1;//unbreakable
	}

	@Override
	public void setMoveBehavior() {
		// Stay
	}

	@Override
	public void setDrawBehavior() {
		this.drawBehavior = new DrawBase();//do noting
	}
	

	@Override
	public void drawOn(Graphics2D g2d) {
//		System.out.println(this.color);
		g2d.setColor(this.color);
		this.underlying.drawOn(g2d);
	}

	@Override
	public void move() {
		this.underlying.update();
		this.x = this.underlying.getX();
		this.y = this.underlying.getY();
	}

	
	public boolean overlaps(AlienEnemyAdopter otherEnemy) {
		Alien otherAlien = otherEnemy.underlying;
		return this.underlying.overlapsWith(otherAlien);
	}
	
	public void bounce(AlienEnemyAdopter other) {
		this.underlying.bounce(other.underlying);
	}
	
	


}
