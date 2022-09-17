package Enemy;

import java.awt.Graphics2D;
import java.util.ArrayList;

public abstract class EnemyGroup extends Enemy{
	ArrayList<Enemy> enemies = new ArrayList<>();

	@Override
	public void add(Enemy enemyComponent) {
		this.enemies.add(enemyComponent);
	}

	@Override
	public void remove(Enemy enemyComponent) {
		this.enemies.remove(enemyComponent);
	}

	@Override
	public Enemy getChild(int i) {
		return this.enemies.get(i);
	}

	@Override
	public void drawOn(Graphics2D g2d) {
		for(Enemy e : this.enemies) {
			e.drawOn(g2d);
		}
	}

	@Override
	public void move() {
		for(Enemy e : this.enemies) {
			e.move();
		}
	}
	
	
	
}
