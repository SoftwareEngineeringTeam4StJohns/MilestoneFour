package controllers;
import java.util.HashMap;


import cloudEntities.Job;
import cloudEntities.Vehicle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import cloudEntities.Job;

public class VCC {
	/*
	 * The VCC has been designed as a singleton since there shouldn't be more 
	 * than one instance in this program and many classes depend on said 
	 * instance 
	 */
	private static VCC vcc;
	public static HashMap<String, Job> jobsHash = new HashMap<>();
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
		jobsHash.put(jobEntry.get("ID"), new Job(jobEntry));
	}
	
	public void registerVehicle(HashMap<String, String> vehicleEntry) {
		vehicles.put(vehicleEntry.get("ID"), new Vehicle(vehicleEntry));
	}
	
	public String getJobCompletion(String jobID) {
		if (jobsHash.containsKey(jobID))
			return "Update has been made as well as correct ID selection!";
		else
			return "";
	}
	
	
	
	
	Queue<Job> jobsQueue = new LinkedList<Job>(); ;
	
	public void addJob(int id,  int approxJobTime) {
		Job job = new Job(id, approxJobTime);
		jobsQueue.add(job);
		
	}
	
	public void jobCompletionTime(int id) {
		boolean found = false;
		int position = 0;
		
		Iterator iterator = jobsQueue.iterator();  
		
        while (iterator.hasNext() && !found) { 
        	Job element = (Job) iterator.next();
        	
            if (element.getId()==id) {
            	found = true;
            }
            position++;   
        }
		
        iterator = jobsQueue.iterator(); 
        int i = 0;
        int time = 0;
        while (iterator.hasNext() && i < position) { 
        	Job element = (Job) iterator.next();
            time = time + element.getApproxTime();
            i++;
        }
        
       System.out.println("The completion time for Job " + id + " is " + time);
	}
}
