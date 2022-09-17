package Main;

public class LevelStateMachine {
	
	public final static int LEVEL_ONE = 0;
	public final static int LEVEL_ONE_BOTTOM = 1;
	public final static int LEVEL_TWO = 2;
	public final static int END = 3;
	
	public LevelController levelController;
	public int currentLevel;
	public PlayerCheckPoint checkPoint;
	
	public LevelStateMachine(LevelController levelController) {
		this.levelController = levelController;
		this.currentLevel = LEVEL_ONE;
		this.checkPoint = new PlayerCheckPoint();
		this.levelController.setLevel(this.currentLevel);
	}
	
	public void changeLevel() {
		this.levelController.handleCollision(this.currentLevel);
		
		if(this.levelController.checkLevelUp(this.currentLevel)) {// level up
			System.out.println("level up");
			System.out.println(this.currentLevel);
			this.levelController.clearLevel(this.currentLevel);
			this.currentLevel++;
			this.levelController.setLevel(this.currentLevel);
			this.checkPoint.save();
		}
		
		this.checkGameOver();
	}
	
	public void checkGameOver() {
		if(Player.player.lives <= 0 && this.currentLevel != END) {
			this.levelController.clearLevel(this.currentLevel);
			this.currentLevel = END;
			this.levelController.setLevel(END);
		}
	}
	
	public void restart() {
		System.out.println("restart");
		this.checkPoint.load();
		this.levelController.clearLevel(this.currentLevel);
		this.currentLevel = LEVEL_ONE;
		this.levelController.setLevel(this.currentLevel);
		System.out.println("restart finish "+ Player.player.specialSkill);
	}

}
