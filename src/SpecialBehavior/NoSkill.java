package SpecialBehavior;

import Enemy.Enemy;

public class NoSkill extends SpecialBehavior{

	public NoSkill(int skillCount) {
		super(skillCount);
		//do nothing
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hit(Enemy e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		
		return "no skill";
	}

}
