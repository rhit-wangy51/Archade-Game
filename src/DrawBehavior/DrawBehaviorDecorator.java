package DrawBehavior;

public abstract class DrawBehaviorDecorator implements DrawBehavior{
	public DrawBehavior base;
	
	public DrawBehaviorDecorator(DrawBehavior base) {
		this.base = base;
	}
}
