package Command;

import Level.AbstractLevel;

public class HandleCollisionCommand implements Command{
	
public AbstractLevel level;
	
	public HandleCollisionCommand(AbstractLevel level) {
		this.level = level;
	}
	
	@Override
	public boolean execute() {
		this.level.handleCollision();
		return true;
	}

}
