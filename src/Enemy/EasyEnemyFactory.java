package Enemy;

import java.awt.Color;
import java.util.Arrays;

import DrawBehavior.DrawSimpleCircle;

public class EasyEnemyFactory extends AbstractEnemyFactory{

	@Override
	public Enemy createEnemy(String types) {
		Enemy newEnemy = null;
		
		String[] typeList = types.split(", ");
//		System.out.println(Arrays.toString(typeList));
		
		switch(typeList[0]) {
		case "movingRock":
			newEnemy = new MovingRock();
			break;
		case "bouncingBall":
			newEnemy = new AlienEnemyAdopter();
//			System.out.println("ball");
			break;
		case "linedRocks":
			newEnemy = new LinedRocks();
			break;
		default:
			System.out.println("invalid main type");
		}
		
		for(int i = 1; i < typeList.length; i++) {
			switch(typeList[i]) {
			case "orange":
				newEnemy.special = "orange";
				newEnemy.color = Color.orange;
//				newEnemy.drawBehavior = new DrawSimpleCircle();
//				System.out.println(newEnemy.getClass() + " " + newEnemy.color);
				break;
			default:
				newEnemy.color = Color.white;
				System.out.println("invalid type");
			}
		}
		
//		System.out.println(newEnemy.color);
		return newEnemy;
		
	}

}
