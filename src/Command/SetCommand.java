package Command;

import Level.AbstractLevel;

public class SetCommand implements Command{

	public AbstractLevel level;
	
	public SetCommand(AbstractLevel level) {
		this.level = level;
	}
	
	@Override
	public boolean execute() {
		this.level.set();
		return true;
	}

}
