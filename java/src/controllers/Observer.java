package controllers;

import cloudEntities.Job;
import cloudEntities.Vehicle;

public interface Observer {
	public void update(Job job, users.GUI gui);
	
	public void update(Vehicle vehicle, users.GUI gui);

}
