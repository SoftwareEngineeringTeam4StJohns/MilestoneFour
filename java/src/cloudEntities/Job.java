package cloudEntities;

import java.util.ArrayList;
import java.util.HashMap;


public class Job implements Comparable<Job>, Locatable{
	/*
	 * This will be used to construct a job directly from the JSON
	 */
	private Vehicle vehicle;
	private double progress;
	private double[] coordinates = new double[2];
	private int importance; 
	
	public Job(HashMap<String, String> jobEntry) {
		importance = -1;
	}

	public ArrayList<String> getGraphData() {
		return null;
	}
	
	
	
	
	public double getProgress() {
		return this.progress;
	}

	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setImportance(int value) {
		this.importance = value;
	}
	
	
	
	public int getImportance() {
		return this.importance;
	}

	@Override
	public int compareTo(Job arg0) {
		if(this.getImportance() > arg0.getImportance())
			return 1;
		else if (this.getImportance() < arg0.getImportance())
			return -1;
		else
			return 0;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}
	
	public void cancel() {
		this.vehicle = null;
		
	}

	public double[] getLocation() {
		return this.coordinates;
	}

	public void setLocation(double x, double y) {
		this.coordinates[0] = x;
		this.coordinates[1] = y;
	}
	
	
}
