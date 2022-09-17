package Enemy;
import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

import DrawBehavior.DrawSimpleCircle;
import Main.Component;
import Main.Observer;
import MoveBehavior.GoForward;

public class MovingRock extends EnemyItem{
	

	@Override
	public void setSize() {
		int radius = ThreadLocalRandom.current().nextInt(15, 51);
		this.width = radius * 2;
		this.height = radius * 2;
		
	}
	
	
	@Override
	public void setSpeed() {
		this.xVel = ThreadLocalRandom.current().nextInt(7, 20);
		this.yVel = ThreadLocalRandom.current().nextInt(7, 20);
		
	}
	
	
	@Override
	public void setLocation() {
		int sideNumber = ThreadLocalRandom.current().nextInt(1, 4 + 1);
		switch(sideNumber) {
		case 1: //left
			this.x = - this.width;
			this.y = ThreadLocalRandom.current().nextInt(0, Component.HEIGHT - this.height);
			this.yVel = 0;
			break;
		case 2: //up
			this.x = ThreadLocalRandom.current().nextInt(0, Component.WIDTH - this.width);
			this.y = - this.height;
			this.xVel = 0;
			break;
		case 3: //right
			this.x = Component.WIDTH;
			this.y = ThreadLocalRandom.current().nextInt(0, Component.HEIGHT - this.height);
			this.xVel = - this.xVel;
			this.yVel = 0;
			break;
		case 4: //down
			this.x = ThreadLocalRandom.current().nextInt(0, Component.WIDTH - this.width);
			this.y = Component.HEIGHT;
			this.yVel = -this.yVel;
			this.xVel = 0;
			break;
		}
	}
	
	
//	@Override
//	public void setSpecialAndColor() {
//		if(this.special == null) {
//			this.special = "";
//		}
//		
//	}


	@Override
	public void setAttackAndLives() {
		this.attack = 1;
		this.lives = -1;//unbreakable
		
	}

	@Override
	public void setMoveBehavior() {
		this.moveBehavior = new GoForward();
		
	}

	@Override
	public void setDrawBehavior() {
		this.drawBehavior = new DrawSimpleCircle();
		
	}

	





}
