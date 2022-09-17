package Command;

import Level.AbstractLevel;

public class ClearCommand implements Command{

	public AbstractLevel level;
	
	public ClearCommand(AbstractLevel level) {
		this.level = level;
	}
	
	@Override
	public boolean execute() {
		this.level.clear();
		return true;
	}

}
