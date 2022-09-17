package SpecialBehavior;

import Enemy.Enemy;

public abstract class SpecialBehavior {
	
	public int skillCount;
	public int countDown;

	public SpecialBehavior(int skillCount) {
		this.skillCount = skillCount;
	}
	
	public void start() {
		this.countDown = this.skillCount;
	}
	
	public abstract void act();
	
	public abstract void hit(Enemy e);
	
	public abstract void end();
}
