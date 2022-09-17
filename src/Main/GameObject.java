package Main;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import DrawBehavior.DrawBase;
import DrawBehavior.DrawBehavior;
import DrawBehavior.DrawSimpleRec;
import MoveBehavior.MoveBehavior;
import MoveBehavior.Stay;


public abstract class GameObject {

	public int x, y, xVel, yVel, width, height;
	public Color color;
	public boolean shouldRemove;
	
	public MoveBehavior moveBehavior;
	public DrawBehavior drawBehavior;
	
	public GameObject() {
		this.moveBehavior = new Stay();
		this.drawBehavior = new DrawSimpleRec();
		this.color = Color.white;
	}
	
	public void drawOn(Graphics2D g2d) {
//		System.out.println(this.color);
		this.drawBehavior.draw(g2d, this);
	}
	
	/**
	 * update position of game object
	 */
	public void move() {
		this.moveBehavior.move(this);
	}
	
	/**
	 * @return a Rectangle object which is the hitBox of the game object
	 */
	public Rectangle hitBox(){
		return new Rectangle(this.x, this.y, this.width, this.height);			
	}
	
	/**
	 * See if this collide with other
	 * @param other another game object
	 * @return true if they do collide
	 */
	public boolean overlaps(GameObject other) {
		return this.hitBox().intersects(other.hitBox());
	}
}

//	public GameObject(int x, int y, int xVel, int yVel, int width, int height) {
//		this.x = x;
//		this.y = y;
//		this.xVel = xVel;
//		this.yVel = yVel;
//		this.width = width;
//		this.height = height;
//		this.shouldRemove = false;
//		this.moveBehavior = new Stay();
//	}