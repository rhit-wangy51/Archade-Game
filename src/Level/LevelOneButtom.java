package Level;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import DrawBehavior.DrawPlayerSkillRec;
import Enemy.Enemy;
import Enemy.EnemyGroup;
import Main.Component;
import Main.Player;
import SpecialBehavior.OrangeSkill;

public class LevelOneButtom implements AbstractLevel{
	
	public Component component;
	public int slot;
	public boolean nextLevel;
	private Timer nextLevelTimer;
	private Timer nextEnemyTimer;
	
	public ArrayList<Enemy> enemies = new ArrayList<>();
	public ArrayList<Enemy> removeEnemies = new ArrayList<>();
	
	public LevelOneButtom(Component component) {
		this.component = component;
		this.nextLevel = false;
		
		this.nextLevelTimer = new Timer(1000 * 30,
				
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Do this on each Tick from gameAdvanceTimer
//						System.out.println("hi");
						nextLevel = true;
						nextLevelTimer.stop();
						
					} 
				} 
			);
		
		this.nextEnemyTimer = new Timer(2000,
				
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Do this on each Tick from gameAdvanceTimer
//						System.out.println("hi");
						Enemy newEnemy = component.enemyFactory.orderEnemy("linedRocks");
						component.gameObjects.add(newEnemy);
						enemies.add(newEnemy);
						
					} 
				} 
			);
		
	}

	@Override
	public void set() {
		this.component.label.setText("Press [space] to dash");
		this.nextLevelTimer.start();
		this.nextEnemyTimer.start();
//		for(int i = 0; i < 5; i++) {
			Enemy newEnemy = this.component.enemyFactory.orderEnemy("linedRocks");
			this.component.gameObjects.add(newEnemy);
			this.enemies.add(newEnemy);
//		}
		Player.player.specialSkill =  new OrangeSkill(Player.SKILL_COUNT);
		
		System.out.println("1" + Player.player.specialSkill);
	} 

	@Override
	public void clear() {
		for(Enemy e : this.enemies) {
			this.component.removeGameObjects.add(e);
		}
		this.enemies.clear();
		this.nextLevelTimer.stop();
		this.nextEnemyTimer.stop();
	}

	@Override
	public void handleCollision() {
//		System.out.println("handle collide for " + this.enemies.size());
		for(Enemy eg : this.enemies) {

			for(int i = 0; i < 13; i++) {
				Enemy e = eg.getChild(i);
				if(e.x >= this.component.WIDTH) {
//					System.out.println("out");
					e.shouldRemove = true;
//					this.removeEnemies.add(eg);
				}
				if(Player.player.overlaps(e)) {
//					System.out.println("collide");
					switch(e.special) {
					case "orange":
						System.out.println("special");
			
						Player.player.orange++;
						if(Player.player.orange > 6) {
							Player.player.orange = 6;
						}
						Player.player.drawBehavior = new DrawPlayerSkillRec(Player.player.drawBehavior, Color.orange);
	
						e.shouldRemove = true;
//						this.component.removeGameObjects.add(e);
//						this.removeEnemies.add(e);
						break;
					default:
						Player.player.collideWithEnemy(e);
					}
				}
			}
		}
		
		
		
		for(Enemy eg : this.enemies) {
			System.out.println();
			for(int i = 0; i < 12; i++) {
				Enemy e = eg.getChild(i);
				if(e.shouldRemove) {
					eg.remove(e);
				}
			}
		}
		
//		for(Enemy e : this.removeEnemies) {
//			this.enemies.remove(e);
//		}
//		
	}

	@Override
	public boolean checkLevelUp() {
		
		return this.nextLevel;
	}

}
