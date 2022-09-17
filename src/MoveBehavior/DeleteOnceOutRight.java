package MoveBehavior;

import Main.Component;
import Main.GameObject;

public class DeleteOnceOutRight implements MoveBehavior{

	@Override
	public void move(GameObject go) {
		go.x += go.xVel;
		go.y += go.yVel;
		
		if(go.x >= Component.WIDTH) {
			go.shouldRemove = true;
		}
		
		
	}

}
