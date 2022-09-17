package Enemy;

public abstract class AbstractEnemyFactory {
	
	public Enemy orderEnemy(String type) {
		
		Enemy enemy = createEnemy(type);
//		System.out.println(enemy.getClass());
		enemy.setSize();
		enemy.setSpeed();
		enemy.setLocation();
		enemy.setSpecialAndColor();
		enemy.setAttackAndLives();
		enemy.setMoveBehavior();
		enemy.setDrawBehavior();
		
		return enemy;
		
	}
	
	public abstract Enemy createEnemy(String types);
}
