package Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;

import Enemy.AlienEnemyAdopter;
import Enemy.Enemy;
import Main.Component;
import Main.GameObject;
import Main.Player;

public class LevelTwo implements AbstractLevel{
	
	public ArrayList<AlienEnemyAdopter> enemies = new ArrayList<>();
	public ArrayList<Enemy> removeEnemies = new ArrayList<>();
	
	public Component component;
	public int slot;
	public boolean nextLevel;
	private Timer newEnemyTimer;
	

	public LevelTwo(Component component) {
		this.component = component;
		this.nextLevel = false;
		
		
		this.newEnemyTimer = new Timer(1000,
				
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Do this on each Tick from gameAdvanceTimer
//						System.out.println("pop");
//						nextLevel = true;
						AlienEnemyAdopter newEnemy = (AlienEnemyAdopter) component.enemyFactory.orderEnemy("bouncingBall");
						component.gameObjects.add(newEnemy);
						enemies.add(newEnemy);
					} 
				} 
			);
		
	}

	@Override
	public void set() {
		this.newEnemyTimer.start();
		this.component.label.setText("How long can you hold?");
		Player.player.orange = 0;
		for(int i = 0; i < 10; i++) {
			AlienEnemyAdopter newEnemy = (AlienEnemyAdopter) this.component.enemyFactory.orderEnemy("bouncingBall");
			this.component.gameObjects.add(newEnemy);
			this.enemies.add(newEnemy);
//			System.out.println("2" + Player.player.specialSkill);
		}
//		AlienEnemyAdopter newEnemy = (AlienEnemyAdopter) this.component.enemyFactory.orderEnemy("bouncingBall, orange");
//		this.component.gameObjects.add(newEnemy);
//		this.enemies.add(newEnemy);
		
	}

	@Override
	public void clear() {
		for(Enemy e : this.enemies) {
			this.component.removeGameObjects.add(e);
		}
		this.enemies.clear();
		this.newEnemyTimer.stop();
	}

	@Override
	public void handleCollision() {
		for(AlienEnemyAdopter e : this.enemies) {
			for(AlienEnemyAdopter e2 : this.enemies) {
				if(!e.equals(e2) && e.overlaps(e2)) {
					e.bounce(e2);
					e2.bounce(e);
				}
			}
		}
		
		for(AlienEnemyAdopter e : this.enemies) {
//			System.out.println(e.width + " " + e.height);
			if(e.overlaps(Player.player)) {
//				System.out.println("hit");
				Player.player.collideWithEnemy(e);
//				if(e.special.equals("orange")) {
//					e.shouldRemove = true;
//				}else {
//					Player.player.getHurt(e.attack);
//				}
			}
		}
		
		
		
	}

	@Override
	public boolean checkLevelUp() {
		// TODO Auto-generated method stub
		return this.nextLevel;
	}

//	@Override
//	public Iterator<GameObject> createIterator() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
