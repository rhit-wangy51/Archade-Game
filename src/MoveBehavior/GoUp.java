package MoveBehavior;
import Main.Component;
import Main.GameObject;

public class GoUp implements MoveBehavior{

	public void move(GameObject go) {
		go.y -= go.yVel;
		
		if(go.y < 0) {
			go.y += go.yVel;
		}
		
	}

}
