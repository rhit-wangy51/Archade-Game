package Level;

import java.util.Iterator;

import Main.Component;
import Main.GameObject;
import Main.Player;

public class End implements AbstractLevel{
	
	public Component component;
	public int slot;
	public boolean nextLevel;

	public End(Component component) {
		this.component = component;
		this.nextLevel = false;
	}

	@Override
	public void set() {
		component.label.setText("Press any key to restart" );
		System.out.println("3" + Player.player.specialSkill);
	}

	@Override
	public void clear() {
		
	}

	@Override
	public void handleCollision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkLevelUp() {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public Iterator<GameObject> createIterator() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
