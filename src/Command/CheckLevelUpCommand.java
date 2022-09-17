package Command;

import Level.AbstractLevel;

public class CheckLevelUpCommand implements Command{

	public AbstractLevel level;
	
	public CheckLevelUpCommand(AbstractLevel level) {
		this.level = level;
	}
	
	@Override
	public boolean execute() {
		return this.level.checkLevelUp();
	}

}
