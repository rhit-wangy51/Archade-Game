package Level;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import DrawBehavior.DrawPlayerSkillRec;
import Enemy.Enemy;
import Main.Component;
import Main.GameObject;
import Main.Player;

public class LevelOne implements AbstractLevel{
	
	public Component component;
	public int slot;
	public boolean nextLevel;
	
	public ArrayList<Enemy> enemies = new ArrayList<>();
	public ArrayList<Enemy> removeEnemies = new ArrayList<>();
	public ArrayList<GameObject> iteratorCreater = new ArrayList<>();

	public LevelOne(Component component) {
		this.component = component;
		this.nextLevel = false;
	}

	@Override
	public void set() {
		this.component.label.setText("Collect orange");
		Player.player.drawBehavior = new DrawPlayerSkillRec(Player.player.drawBehavior, Color.orange);
		for(int i = 0; i < 11; i++) {
			Enemy newEnemy;
			if(i == 5) {//create one special enemy
				newEnemy = this.component.enemyFactory.orderEnemy("movingRock, orange");
//				System.out.println("new orange at" + newEnemy.x);
			}else {
				newEnemy = this.component.enemyFactory.orderEnemy("movingRock");
			}
			this.component.gameObjects.add(newEnemy);
			this.enemies.add(newEnemy);
			
			this.iteratorCreater.add(newEnemy);
		}
		
		System.out.println("0" + Player.player.specialSkill);
		
	}

	@Override
	public void clear() {
		for(Enemy e : this.enemies) {
			this.component.removeGameObjects.add(e);
		}
		this.enemies.clear();
		
		this.iteratorCreater.clear();
	}

	@Override
	public void handleCollision() {
		boolean addNew = false;
		for(Enemy e : this.enemies) {
			if(Player.player.overlaps(e)) {
				switch(e.special) {
				case "orange":
//					if(Player.player.lives < Player.MAX_LIVES) {
//						Player.player.lives++;
//					}else {
					Player.player.orange++;
//					if(Player.player.orange > 6) {
//						Player.player.orange = 6;
//					}
//					Player.player.drawBehavior = new DrawPlayerSkillRec(Player.player.drawBehavior, Color.orange);
//					}
					e.shouldRemove = true;
//					this.component.removeGameObjects.add(e);
//					this.removeEnemies.add(e);
					addNew = true;
					break;
				default:
					Player.player.collideWithEnemy(e);
				}
			}
		}
		
		for(Enemy e : this.enemies) {
			if(e.shouldRemove) {
				this.component.removeGameObjects.add(e);
				this.removeEnemies.add(e);
			}
		}
		
		
		for(Enemy e : this.removeEnemies) {
			this.enemies.remove(e);
		}
		
		if(this.enemies.isEmpty()) {
			this.nextLevel = true;
		}
		
		if(addNew) {
			Enemy newEnemy = this.component.enemyFactory.orderEnemy("movingRock, orange");
			this.component.gameObjects.add(newEnemy);
			this.enemies.add(newEnemy);
		}
		
	}

	@Override
	public boolean checkLevelUp() {
		return Player.player.orange > Player.MAX_SKILL;
	}

//	@Override
//	public Iterator<GameObject> createIterator() {
////		ArrayList<GameObject> temp = (ArrayList<GameObject>) this.enemies;
//		return this.iteratorCreater
//	}

}
