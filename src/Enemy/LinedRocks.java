package Enemy;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

import DrawBehavior.DrawSimpleCircle;
import Main.Component;
import MoveBehavior.DeleteOnceOutLeft;
import MoveBehavior.DeleteOnceOutRight;
import MoveBehavior.GoForward;
import MoveBehavior.GoRight;

public class LinedRocks extends EnemyGroup{
	int ran;

	@Override
	public void setSize() {
		for(int i = 0; i < 13; i++) {
			Enemy mr = new MovingRock();
			mr.width = 50;
			mr.height = 50;
			this.enemies.add(mr);
		}
	}

	@Override
	public void setSpeed() {
		int xVel = ThreadLocalRandom.current().nextInt(15, 20);
		this.ran = ThreadLocalRandom.current().nextInt(1, 3);
//		System.out.println(this.ran);
		if(this.ran == 1) {
			xVel = -xVel;
		}
		for(Enemy mr : this.enemies) {
			mr.xVel = xVel;
			mr.yVel = 0;
		}
	}

	@Override
	public void setLocation() {
		
		int x = -this.width;
		if(this.ran == 1) {
			x = Component.WIDTH;
		}
		for(int i = 0; i < 13; i++) {
			Enemy e = this.enemies.get(i);
			e.x = x;
			e.y = i * 50;
		}
	}

	@Override
	public void setAttackAndLives() {
		
		for(Enemy mr : this.enemies) {
			mr.attack = 1;
			mr.lives = -1;
		}
		
	}

	@Override
	public void setMoveBehavior() {
//		this.moveBehavior = new GoRight();
		for(Enemy mr : this.enemies) {
			if(this.ran == 1) {
				mr.moveBehavior = new DeleteOnceOutLeft();
			}else {	
				mr.moveBehavior = new DeleteOnceOutRight();
			}
		}
	}

	@Override
	public void setDrawBehavior() {
		for(Enemy mr : this.enemies) {
			mr.drawBehavior = new DrawSimpleCircle();
		}
		
	}

	@Override
	public void setSpecialAndColor() {
		for(Enemy mr : this.enemies) {
			mr.special = "";
		}
		int s = ThreadLocalRandom.current().nextInt(0, 13);
//		System.out.println("special is: " + s);
		this.enemies.get(s).special = "orange";
		this.enemies.get(s).color = Color.orange;
	}

	@Override
	public void remove(Enemy enemyComponent) {
		enemyComponent.width = 0;
		enemyComponent.height = 0;
	}
	
	

}
