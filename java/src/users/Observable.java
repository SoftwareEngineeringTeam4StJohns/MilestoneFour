package users;

import cloudEntities.Job;
import cloudEntities.Vehicle;
import controllers.Observer;

public interface Observable {
	public void addObserver(Observer observer);
	
	public void removeObserver(Observer observer);
	
	public void notifyObservers(Job job);
	
	public void notifyObservers(Vehicle vehicle);
}
