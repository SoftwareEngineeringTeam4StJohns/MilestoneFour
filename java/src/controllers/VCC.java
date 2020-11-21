package controllers;
import java.util.ArrayList;
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

public class VCC{
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


	public void registerJob(Job job) {
		jobs.put(job.getID(), job);
		jobQueue.add(job);
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
			return Integer.toString(jobCompletionTime(jobID)) + " min.";
		else
			return "Job isn't registered in system.";
	}

	public void registerVehicle(Vehicle vehicle) {
		vehicles.put(vehicle.getID(), vehicle);
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

	public void addJob(String id,  int approxJobTime) {
		jobsQueue.add(new Job(id, approxJobTime));

	}
	/*
	 * iterates through the queue of jobs to add together completion time for searched job
	 */

	public int jobCompletionTime(String id) {
		Job target = jobs.get(id);
		if (target != null) {
			int time = target.getApproxTime();
			for(Job job: jobQueue) {
				if(job == target) {
					return time; 
				}
				time += job.getApproxTime();
			}
		}
		return -1; // -1 returned if no job is found 
	}


	
	
}
