package Main;

import java.util.ArrayList;

import Command.Command;

public class LevelController {
	
	public ArrayList<Command> setCommands;
	public ArrayList<Command> handleCollisionCommands;
	public ArrayList<Command> clearCommands;
	public ArrayList<Command> levelUpCommands;
	
	public LevelController() {
		this.setCommands = new ArrayList<>();
		this.handleCollisionCommands = new ArrayList<>();
		this.clearCommands = new ArrayList<>();
		this.levelUpCommands = new ArrayList<>();
	}
	
	public int setCommand(Command setCommand, Command handleCollisionCommand, Command clearCommand, Command levelUpCommand) {
		this.setCommands.add(setCommand);
		this.handleCollisionCommands.add(handleCollisionCommand);
		this.clearCommands.add(clearCommand);
		this.levelUpCommands.add(levelUpCommand);
		return this.setCommands.size() - 1;
	}
	
	public void setLevel(int slot) {
		this.setCommands.get(slot).execute();
	}
	
	public void handleCollision(int slot) {
		this.handleCollisionCommands.get(slot).execute();
	}
	
	public void clearLevel(int slot) {
		this.clearCommands.get(slot).execute();
	}
	
	public boolean checkLevelUp(int slot) {
		return this.levelUpCommands.get(slot).execute();
	}
	
	

}
