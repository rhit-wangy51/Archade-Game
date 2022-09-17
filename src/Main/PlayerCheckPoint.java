package Main;

import DrawBehavior.DrawBehavior;
import SpecialBehavior.SpecialBehavior;

public class PlayerCheckPoint {
	
	public DrawBehavior drawBehavior;// thing to save
	public SpecialBehavior specialBehavior;
	
	public PlayerCheckPoint() {
		this.drawBehavior = Player.player.drawBehavior;
		this.specialBehavior = Player.player.specialSkill;
	}
	
	public void save() {
		System.out.println("save "+ Player.player.specialSkill);
		this.drawBehavior = Player.player.drawBehavior;
		this.specialBehavior = Player.player.specialSkill;
	}
	
	public void load() {
		System.out.println("load "+ Player.player.specialSkill);
		Player.player.drawBehavior = this.drawBehavior;
		Player.player.specialSkill = this.specialBehavior;
		Player.player.lives = Player.MAX_LIVES;
		Player.player.orange = 0;
		System.out.println("load finish "+ Player.player.specialSkill);
	}

}
