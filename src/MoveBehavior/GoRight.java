package MoveBehavior;
import Main.Component;
import Main.GameObject;

public class GoRight implements MoveBehavior {

	@Override
	public void move(GameObject go) {
		go.x += go.xVel;
		
		if(go.x > (Component.WIDTH - go.width)) {
			go.x -= go.xVel;
		}
	}

}
