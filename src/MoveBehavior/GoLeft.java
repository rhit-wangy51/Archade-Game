package MoveBehavior;
import Main.GameObject;

public class GoLeft implements MoveBehavior {

	@Override
	public void move(GameObject go) {
		go.x -= go.xVel;
		
		if(go.x < 0) {
			go.x += go.xVel;
		}
	}

}
