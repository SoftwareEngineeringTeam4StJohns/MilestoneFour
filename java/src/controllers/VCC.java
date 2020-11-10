package controllers;
import java.util.HashMap;
import java.util.PriorityQueue;

import cloudEntities.Job;
import cloudEntities.Locatable;
import cloudEntities.Vehicle;
import logging.Loggers;

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
	private HashMap<String, Job> jobs = new HashMap<>();
	private PriorityQueue<Job> jobQueue = new PriorityQueue<>();
	private HashMap<String, Vehicle> vehicles = new HashMap<>();
	
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
		jobQueue.add(jobs.get(jobEntry.get("ID")));
	}

	public void deregisterJob(String jobID) {
		Job job = jobs.remove(jobID);
		jobQueue.remove(job);
	}

	public void assignJob(Job job) {
		Vehicle vehicle = optimizeVehicleFind(job);
		if (vehicle != null) {
			vehicle.addJob(job);
			job.setVehicle(vehicle);
		}
	}


	public void assignAllWaiting() {
		while (!(jobQueue.isEmpty())){
			assignJob(jobQueue.poll());
		}
	}

	public void cancelJob(Job job) {
		job.cancel();
	}


	public String getJobCompletion(String jobID) {
		if (jobs.containsKey(jobID))
			return "User exists in the system!";
		else
			return "";
	}

	public void registerVehicle(HashMap<String, String> vehicleEntry) {
		vehicles.put(vehicleEntry.get("ID"), new Vehicle(vehicleEntry));
	}

	public void deregisterVehicle(String vehicleID) {
		vehicles.remove(vehicleID);
	}

	/*
	 * This method will take a job, image the comp. state (progress)
	 * and assign that job a new vehicle.
	 */
	public void checkPoint(Vehicle targetVehicle, Vehicle imagingVehicle) {
		imagingVehicle.createImage(targetVehicle);
	}

	public void generateGraph() {
		Loggers.createGraphInfo(jobs);
	}


	private Vehicle optimizeVehicleFind(Job job){
		Vehicle nearVeh = null;
		Vehicle optimalVeh = null;
		double dist;
		if (!(vehicles.isEmpty())) {
			double lowestDist = -1;
			for(Vehicle vehicle: vehicles.values()) {
				//if the vehicle isn't busy...
				if (vehicle.getStatus() == false) {
					if(lowestDist == -1)
						lowestDist = calculateDistance(job, vehicle);
					dist = calculateDistance(job, vehicle);
					if (lowestDist > dist) {
						lowestDist = dist;
						nearVeh = vehicle;
					}
					if (matchTypeSpec(job, vehicle))
						optimalVeh = nearVeh;
				}
			}
		}
		if (optimalVeh != null)
			return optimalVeh;
		else
			return nearVeh;
	}

	/*
	 * This will check the comp spec of the vehicle and the
	 * job type and determine if they're optimal
	 */
	private boolean matchTypeSpec(Job job, Vehicle vehicle) {
		return false;
	}

	/*
	 * Since we implemented the Locatable interface, we can use this to calculate distance between
	 * vehicles, between jobs, or between each other
	 */
	private double calculateDistance(Locatable arg0, Locatable arg1) {
		double[] jobCoords = arg0.getLocation();
		double[] vehCoords = arg1.getLocation();
		double xDist = jobCoords[0] + vehCoords[0];
		double yDist = jobCoords[1] + vehCoords[1];
		double distance = Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
		return distance;
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
