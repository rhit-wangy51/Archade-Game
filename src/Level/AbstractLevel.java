package Level;

import java.util.Iterator;

import Main.Component;
import Main.GameObject;

public interface AbstractLevel {
	
//	public Component component;
//	public int slot;
//	public boolean nextLevel;
//	
//	public AbstractLevel(Component component) {
//		this.component = component;
//		this.nextLevel = false;
//	}
	
	public void set();
	
	public void clear();
	
	public void handleCollision();
	
	public boolean checkLevelUp();
	
//	public abstract Iterator<GameObject> createIterator();
}
