package SpecialBehavior;

import Enemy.Enemy;
import Main.Player;

public class OrangeSkill extends SpecialBehavior{
	
	int colorCount;
	boolean needRestore = false;
	
	public OrangeSkill(int skillCount) {
		super(skillCount);
	}
	
	
	public void act() {
//		int colorCount = Player.player.orange;
//		System.out.println("act with count down: " + this.countDown);
		if(this.countDown > 0) {
			this.countDown--;
			Player.player.xVel = 20;
			Player.player.yVel = 20;
			Player.player.orange = Player.MAX_SKILL;
		}else if(this.needRestore) {
			this.end();
		}
		
	}

	@Override
	public void hit(Enemy e) {
		e.shouldRemove = true;
	}

	@Override
	public void start() {
		System.out.println("start");
		if(Player.player.orange > 0) {
			super.start();
			this.needRestore = true;
//		System.out.println("Current orange: " + Player.player.orange);
			Player.player.orange--;
			colorCount = Player.player.orange;
		}else {
			System.out.println("no magic");
		}
		
	}
	
	@Override
	public void end() {
//		System.out.println("end");
		Player.player.xVel = 10;
		Player.player.yVel = 10;
//		System.out.println("Current orange: " + this.colorCount);
		Player.player.orange = colorCount;
		this.needRestore = false;
	}


	@Override
	public String toString() {
		
		return "orange skill";
	}
	
	
	

}
