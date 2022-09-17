package Main;
import java.util.ArrayList;

public abstract class Subject {

	private ArrayList<Observer> observers = new ArrayList<>();
	
	public void addObserver(Observer newObserver) {
		this.observers.add(newObserver);
	}
	
	public void removeObserver(Observer o) {
		this.observers.remove(o);
	}
	
	public void notifyObserver() {
		for(Observer o : this.observers) {
			o.update();
		}
	}
}
