package controllers;
import java.util.HashMap;


import cloudEntities.Job;
import cloudEntities.Vehicle;

public class VCC {
	/*
	 * The VCC has been designed as a singleton since there shouldn't be more 
	 * than one instance in this program and many classes depend on said 
	 * instance 
	 */
	private static VCC vcc;
	public static HashMap<String, Job> jobs = new HashMap<>();
	public static HashMap<String, Vehicle> vehicles = new HashMap<>();
	
	
	public static VCC instanceOf() {
		if (vcc == null) {
			vcc = new VCC();
		}
		return vcc;
	}
	
	private VCC() {
		
	}
	
	
	public void registerJob(HashMap<String, String> jobEntry) {
		jobs.put(jobEntry.get("ID"), new Job(jobEntry));
	}
	
	public void registerVehicle(HashMap<String, String> vehicleEntry) {
		vehicles.put(vehicleEntry.get("ID"), new Vehicle(vehicleEntry));
	}
	
	public String getJobCompletion(String jobID) {
		if (jobs.containsKey(jobID))
			return "Update has been made as well as correct ID selection!";
		else
			return "";
	}
	
	
	
	
}
