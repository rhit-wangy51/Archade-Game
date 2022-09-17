package Main;
import java.awt.Color;
import java.awt.Graphics2D;

import DrawBehavior.DrawPlayerLivesRec;
import Enemy.Enemy;
import MoveBehavior.GoDown;
import MoveBehavior.GoLeft;
import MoveBehavior.GoRight;
import MoveBehavior.GoUp;
import MoveBehavior.MoveBehavior;
import MoveBehavior.Stay;
import SpecialBehavior.NoSkill;
import SpecialBehavior.OrangeSkill;
import SpecialBehavior.SpecialBehavior;

public class Player extends GameObject{
	
	public static final int MAX_LIVES = 6;
	public static final int MAX_SKILL = 6;
	public static final int SKILL_COUNT = 5;
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	public static final int X_VEL = 10;
	public static final int Y_VEL = 10;
	public static final int X = 400;
	public static final int Y = 400;
	public int lives;
	public int invincibleCount;
	public int orange;
	public MoveBehavior moveLeftBehavior, moveRightBehavior, moveUpBehavior, moveDownBehavior;
	public SpecialBehavior specialSkill;
//	public PlayerCheckPoint checkPoint;
	
	public static Player player = new Player();

	private Player() {
		this.x = X;
		this.y = Y;
		this.xVel = X_VEL;
		this.yVel = Y_VEL;
		this.width = WIDTH;
		this.height = HEIGHT;
		this.lives = MAX_LIVES;
		this.shouldRemove = false;
		this.invincibleCount = 30;
		this.moveLeftBehavior = new Stay();
		this.moveRightBehavior = new Stay();
		this.moveUpBehavior = new Stay();
		this.moveDownBehavior = new Stay();
		this.drawBehavior = new DrawPlayerLivesRec(this.drawBehavior, Color.white);
		this.specialSkill = new NoSkill(SKILL_COUNT);
//		this.checkPoint = new PlayerCheckPoint();
	}
	
	public void load() {
		this.x = X;
		this.y = Y;
		this.lives = MAX_LIVES;
	}
	
	@Override
	public void move() {
		
		//key moves
		this.specialSkill.act();
		this.moveUpBehavior.move(this);
		this.moveLeftBehavior.move(this);
		this.moveRightBehavior.move(this);
		this.moveDownBehavior.move(this);
		
		this.invincibleCount--;
		if(this.invincibleCount < 0) {
			this.invincibleCount = 0;
		}
		
	}
	
	public void getHurt(int atk) {
		if(this.invincibleCount <= 0) {
			this.lives -= atk;
			this.invincibleCount = 30;
		}
	}
	
	public void collideWithEnemy(Enemy e) {
//		System.out.println("collide with enemy");
		if(this.specialSkill.countDown > 0) {
//			System.out.println("is skilled, countDown is " + this.specialSkill.countDown);
			this.specialSkill.hit(e);
		}else {
			this.getHurt(e.attack);
		}
	}


}
