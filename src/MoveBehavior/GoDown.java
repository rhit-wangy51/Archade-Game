package MoveBehavior;
import Main.Component;
import Main.GameObject;

public class GoDown implements MoveBehavior{
	
	public void move(GameObject go) {
		go.y += go.yVel;
		
		if(go.y > Component.HEIGHT - go.height) {
			go.y -= go.yVel;
		}
		
	}
}
