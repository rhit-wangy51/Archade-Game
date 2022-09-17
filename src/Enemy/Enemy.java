package Enemy;

import java.awt.Color;

import Composit.EnemyComponent;
import Main.GameObject;

public abstract class Enemy extends GameObject{
	
	public int attack;
	public int lives;
	public String special;
	
	public abstract void setSize();
	
	public abstract void setSpeed();
	
	public abstract void setLocation();
	
	public void setSpecialAndColor() {
		if(this.special == null) {
			this.special = "";
		}
	}
	
	public abstract void setAttackAndLives();
	
	public abstract void setMoveBehavior();
	
	public abstract void setDrawBehavior();
	
	// now its also the EnemyComponent
	public void add(Enemy enemyComponent) {
		throw new UnsupportedOperationException();
	}
	
	public void remove(Enemy enemyComponent) {
		throw new UnsupportedOperationException();
	}
	
	public Enemy getChild(int i) {
		throw new UnsupportedOperationException();
	}
	

}
