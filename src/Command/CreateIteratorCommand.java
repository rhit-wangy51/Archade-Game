package Command;

import Level.AbstractLevel;

public class CreateIteratorCommand implements Command{
	
	public AbstractLevel level;
	
	public CreateIteratorCommand(AbstractLevel level) {
		this.level = level;
	}
	
	@Override
	public boolean execute() {
//		this.level.createIterator();
		return true;
	}

}
