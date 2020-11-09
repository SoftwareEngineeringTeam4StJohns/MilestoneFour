package cloudEntities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

import controllers.VCC;

public class Vehicle implements Locatable{

	private VCC vcc;
	private String ID;
	private double status;
	private double[] coordinates;
	private PriorityQueue<Job> currentJobs;
	private boolean atCapacity;
	
	public Vehicle(HashMap<String, String> vehicleEntry) {
		vcc = VCC.instanceOf();
		currentJobs = new PriorityQueue<>();
		coordinates = new double[2];
		atCapacity = false;
	}

	/*
	 * Must remember to include a way to track progress and remove job from queue
	 */
	public void addJob(Job job) {
		currentJobs.add(job);
		if (currentJobs.size() == 3){ //for now we'll cap the max jobs at 3 
			this.atCapacity = true;
		}
	}
	
	public boolean getStatus() {
		return this.atCapacity; 
	}
	
	
	public ArrayList<String> getGraphData() {
		ArrayList<String> data = new ArrayList<>();
		data.add(this.ID);
		data.add(String.valueOf(this.status));
		return data;
	}

	public String getID() {
		return this.ID;
	}

	public double[] getLocation() {
		return this.coordinates;
	}

	public void setLocation(double x, double y) {
		this.coordinates[0] = x;
		this.coordinates[1] = y;
	}

	public void createImage(Vehicle vehicleSpawn) {
		Iterator<Job> jobIterator = this.currentJobs.iterator();
		while(jobIterator.hasNext()) {
			vehicleSpawn.addJob(jobIterator.next());
		}
		
	}
	
	
}
