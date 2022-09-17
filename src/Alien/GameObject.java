package Alien;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Super class of all game object
 * 
 *
 */
public abstract class GameObject {
	private int x, y;
	private int xVel, yVel;
	private int width;
	private int height;
	private boolean shouldRemove;
	
	public GameObject(int x, int y, int xVel, int yVel, int width, int height) {
		this.x = x;
		this.y = y;
		this.xVel = xVel;
		this.yVel = yVel;
		this.width = width;
		this.height = height;
		this.shouldRemove = false;
	}
	
	public abstract void drawOn(Graphics2D g2d);
	
	/**
	 * update position of game object
	 */
	public void update() {
		this.x += this.xVel;
		this.y += this.yVel;
	}
	
	/**
	 * 
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
	
	/**
	 * Stop falling
	 */
	public void stop() {
		this.y -= 5;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getxVel() {
		return xVel;
	}

	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	public int getyVel() {
		return yVel;
	}

	public void setyVel(int yVel) {
		this.yVel = yVel;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isShouldRemove() {
		return shouldRemove;
	}

	public void setShouldRemove(boolean shouldRemove) {
		this.shouldRemove = shouldRemove;
	}

	

}
