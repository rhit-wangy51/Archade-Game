package Main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import MoveBehavior.GoDown;
import MoveBehavior.GoLeft;
import MoveBehavior.GoRight;
import MoveBehavior.GoUp;
import MoveBehavior.Stay;

public class PlayerKeyListener implements KeyListener{
	
	Component component;
	int skillCount;
	
	public PlayerKeyListener(Component component) {
		this.component = component;
	}

	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("key type");
//		System.out.println(this.component.levelStateMachine.currentLevel);

		if(this.component.levelStateMachine.currentLevel == LevelStateMachine.END) {
			this.component.levelStateMachine.restart();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 38) {
			Player.player.moveUpBehavior = new GoUp();
		}
		if (e.getKeyCode() == 37) {
			Player.player.moveLeftBehavior = new GoLeft();
		}
		if (e.getKeyCode() == 39) {
			Player.player.moveRightBehavior = new GoRight();
		}
		if (e.getKeyCode() == 40) {
			Player.player.moveDownBehavior  = new GoDown();
		}
		if(e.getKeyCode() == 32) {
			Player.player.specialSkill.start();
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if (e.getKeyCode() == 38) {
			Player.player.moveUpBehavior = new Stay();
		}
		if (e.getKeyCode() == 37) {
			Player.player.moveLeftBehavior = new Stay();
		}
		if (e.getKeyCode() == 39) {
			Player.player.moveRightBehavior = new Stay();
		}
		if (e.getKeyCode() == 40) {
			Player.player.moveDownBehavior = new Stay();
		}
		if(e.getKeyCode() == 32) {
//			Player.player.specialSkill.end();
		}
//		if(e.getKeyCode() == 32) {
////			Player.player.xVel *= 2;
////			Player.player.yVel *= 2;
//			while(this.skillCount > 0) {
//				this.skillCount--;
//				Player.player.xVel = 20;
//				Player.player.yVel = 20;
//				
//			}
//			Player.player.xVel /= 2;
//			Player.player.yVel /= 2;
//		}
		
	}

}
