package Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.Timer;

import Command.CheckLevelUpCommand;
import Command.ClearCommand;
import Command.HandleCollisionCommand;
import Command.SetCommand;
import DrawBehavior.DrawPlayerSkillRec;
import Enemy.AbstractEnemyFactory;
import Enemy.EasyEnemyFactory;
import Enemy.Enemy;
import Level.AbstractLevel;
import Level.End;
import Level.LevelOne;
import Level.LevelOneButtom;
import Level.LevelTwo;

public class Component extends JComponent {
	
	public final static int WIDTH = 886;
	public final static int HEIGHT = 653;
	
	public ArrayList<GameObject> gameObjects = new ArrayList<>();
	public ArrayList<GameObject> removeGameObjects = new ArrayList<>();
//	public ArrayList<Iterator<GameObject>> gameObjectIterators = new ArrayList<>();
	private Timer gameAdvanceTimer;
	public AbstractEnemyFactory enemyFactory;
	public int levelNum;
	public int currentLevel;
	public LevelController levelController;
	public LevelStateMachine levelStateMachine;
	public JLabel label;
	public boolean end = false;
	
	
	
	public Component(JLabel label) {
		this.label = label;
		this.label.setText("Collect orange");
		
		Player newPlayer = Player.player;
//		ArrayList<GameObject> playerIteratorCreater = new ArrayList<>();
//		playerIteratorCreater.add(newPlayer);
//		this.gameObjects.add(playerIteratorCreater.iterator());
		this.gameObjects.add(newPlayer);
		
		this.enemyFactory = new EasyEnemyFactory();
		this.setLevelController();
		this.levelStateMachine = new LevelStateMachine(this.levelController);
				
//		//start level 1
//		this.levelController.setLevel(this.currentLevel);
		
		//set up timer
		this.gameAdvanceTimer = new Timer(50,
				
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Do this on each Tick from gameAdvanceTimer
					updateState();
					drawScreen();
				} 
			} 
		);
		this.gameAdvanceTimer.start();
		
	}
	
	public void drawScreen() {
		this.repaint();
	}
	
	public void updateState() {
		
		//forward clock
		for(GameObject go : this.gameObjects) {
			go.move();
		}
//		for(Iterator<GameObject> goi : this.gameObjects) {
//			if(goi.hasNext()) {
//				goi.next().move();
//			}
//		}
		
		//handle collisions and check level up
		
		this.levelStateMachine.changeLevel();
		
		
//		this.levelController.handleCollision(this.currentLevel);
//		this.handleLevel();
		
		//remove objects
		for(GameObject go : this.removeGameObjects) {
			this.gameObjects.remove(go);
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//background
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		
		g2d.fill(new Rectangle(0, 0, this.getWidth(), this.getHeight()));
		
		//game objects
		for(GameObject go : this.gameObjects) {
			go.drawOn(g2d);
		}
	}
	
	public void handleLevel(){
		
		boolean once = false;
		if(Player.player.orange > Player.MAX_SKILL && !once) {// level up
			this.levelController.clearLevel(this.currentLevel);
			this.currentLevel++;
			Player.player.orange = 6;
			this.levelController.setLevel(this.currentLevel);
			once = true;
		}
		
		if(Player.player.lives <= 0) {
			this.levelController.clearLevel(this.currentLevel);
			this.levelController.setLevel(2);
		}
	}
	
	public void setLevelController() {
		this.levelController = new LevelController();
		
		LevelOne levelOne = new LevelOne(this);
		SetCommand setLV1 = new SetCommand(levelOne);
		HandleCollisionCommand handleLV1Collisions = new HandleCollisionCommand(levelOne);
		ClearCommand clearLV1 = new ClearCommand(levelOne);
		CheckLevelUpCommand checkLV1 = new CheckLevelUpCommand(levelOne);
		int slot = this.levelController.setCommand(setLV1, handleLV1Collisions, clearLV1, checkLV1);
		levelOne.slot = slot;
		
		this.currentLevel = levelOne.slot;
		
		LevelOneButtom LV1b = new LevelOneButtom(this);
		SetCommand setLV1b = new SetCommand(LV1b);
		HandleCollisionCommand handleLV1bCollisions = new HandleCollisionCommand(LV1b);
		ClearCommand clearLV1b = new ClearCommand(LV1b);
		CheckLevelUpCommand checkLV1b = new CheckLevelUpCommand(LV1b);
		slot = this.levelController.setCommand(setLV1b, handleLV1bCollisions, clearLV1b, checkLV1b);
		LV1b.slot = slot;
		
//		this.currentLevel = 1;
		
		LevelTwo LV2 = new LevelTwo(this);
		SetCommand setLV2 = new SetCommand(LV2);
		HandleCollisionCommand handleLV2Collisions = new HandleCollisionCommand(LV2);
		ClearCommand clearLV2 = new ClearCommand(LV2);
		CheckLevelUpCommand checkLV2 = new CheckLevelUpCommand(LV2);
		slot = this.levelController.setCommand(setLV2, handleLV2Collisions, clearLV2, checkLV2);
		LV2.slot = slot;
		
		End gameOver = new End(this);
		SetCommand setEnd = new SetCommand(gameOver);
		HandleCollisionCommand handleEndCollisions = new HandleCollisionCommand(gameOver);
		ClearCommand clearEnd = new ClearCommand(gameOver);
		CheckLevelUpCommand checkGameOver = new CheckLevelUpCommand(gameOver);
		slot = this.levelController.setCommand(setEnd, handleEndCollisions, clearEnd, checkGameOver);
		gameOver.slot = slot;
	}
	
	
	
}
