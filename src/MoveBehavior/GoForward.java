package MoveBehavior;
import Main.Component;
import Main.GameObject;

public class GoForward implements MoveBehavior{

	@Override
	public void move(GameObject go) {
		go.x += go.xVel;
		go.y += go.yVel;
		
		if(go.x > Component.WIDTH || go.x < - go.width) {
			if(go.xVel > 0) {
				go.x = - go.width;
			}else {
				go.x = Component.WIDTH;
			}
		}
		
		if(go.y > Component.HEIGHT || go.y < - go.height) {
			if(go.yVel > 0) {
				go.y = - go.height;
			}else {
				go.y = Component.HEIGHT;
			}
		}
		
	}

}
