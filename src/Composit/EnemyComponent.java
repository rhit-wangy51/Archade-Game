package Composit;

public abstract class EnemyComponent {
	
	public void add(EnemyComponent enemyComponent) {
		throw new UnsupportedOperationException();
	}
	
	public void remove(EnemyComponent enemyComponent) {
		throw new UnsupportedOperationException();
	}
	
	public EnemyComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}
	
	public void update() {
		throw new UnsupportedOperationException();
	}
}
