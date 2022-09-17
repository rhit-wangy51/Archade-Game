package Alien;

import java.awt.Color;

import java.awt.Graphics2D;
import java.util.Random;

import Main.Component;

/**
 * Ghost alien that fly in space and bounce each other
 *
 */
public class Alien extends GameObject {
	private int centerX, centerY;
	private int moveSpeed;
	private Color color;
//	private Component component;
	Random random=new Random();
	public static final int ALIEN_RADIUS = 12;
	public static final int ALIEN_SPEED = 5;
//	public Color ALIEN_COLOR = new Color(random.nextInt(255-110) + 110,random.nextInt(255-110) + 110,random.nextInt(255-110) + 110);
	public Color ALIEN_COLOR = Color.white;


	/**
	 * create alien of random color
	 * @param x
	 * @param y
	 * @param component
	 */
	public Alien(int x, int y) {
		super(x,y, (int) (ALIEN_SPEED - Math.random() * ALIEN_SPEED * 2),
				(int) (ALIEN_SPEED - Math.random() * ALIEN_SPEED * 2), ALIEN_RADIUS * 2, ALIEN_RADIUS * 2);
		this.centerX = x + ALIEN_RADIUS;
		this.centerY = y + ALIEN_RADIUS;
		this.moveSpeed = ALIEN_SPEED;
		this.color = ALIEN_COLOR;
		

		normalizeVelocity();
	}

	/**
	 * draw the alien
	 */
	@Override
	public void drawOn(Graphics2D g) {
		g = (Graphics2D) g.create();
//		System.out.println(this.color);
//		g.setColor(this.color);
		g.fillOval(this.getX(), this.getY(), ALIEN_RADIUS * 2, ALIEN_RADIUS * 2);
	}

	/**
	 * update the position of alien
	 */
	@Override
	public void update() {
		super.update();
		centerX += getxVel();
		centerY += getyVel();
		if (this.getX() > Component.WIDTH - ALIEN_RADIUS * 2 || this.getX() < 0) {
			this.setX((int) Math.min(Math.max(this.getX(), 0), Component.WIDTH));
			setxVel(-getxVel());
		}
		
		if (this.getY() > Component.HEIGHT - ALIEN_RADIUS * 2 || this.getY() < 0) {
			setyVel(-getyVel());
			this.setY((int) Math.min(Math.max(this.getY(), 0), Component.HEIGHT));
		}
	}

	/**
	 * Check of two Alien overlaps
	 * @param other
	 * @return
	 */
	public boolean overlapsWith(Alien other) {
		int xDiff = centerX - other.centerX;
		int yDiff = centerY - other.centerY;
		double distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
		return this.ALIEN_RADIUS + other.ALIEN_RADIUS >= distance;
	}
	
	
	/**
	 * Two alien bounce to opposite direction when collide
	 * @param other
	 */
	public void bounce(Alien other) {
		setxVel(this.centerX - other.centerX);
		setyVel(this.centerY - other.centerY);
		normalizeVelocity();
	}

	/**
	 * To ensure that the velocity is within a certain range
	 */
	public void normalizeVelocity() {
		if (this.getxVel() == 0 && this.getyVel() == 0) {
			setxVel(1);
			setyVel(1);
		}
		double vectorLength = Math.sqrt(getxVel() * getxVel() + getyVel() * getyVel());
		setxVel((int) (this.getxVel() / vectorLength * moveSpeed * 2));
		setyVel((int) (this.getyVel() / vectorLength * moveSpeed * 2));
	}


}
