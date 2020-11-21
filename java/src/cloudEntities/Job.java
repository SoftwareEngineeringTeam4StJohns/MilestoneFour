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
	private String ID;
	private String information;
	private int approxTime;
	private int deadlineTime;
	private String jobType;
	private boolean jobCompleted;
	private String timeOfCreation;
	

	public Job (String ID, int approxTime) {
		this.ID = ID;
		this.approxTime = approxTime;
	}
	
	
	public Job(String ID, String information, String approxHours, String approxMin, String deadlineHours,
			String deadlineMin, String timestamp) {
		this.ID = ID;
		this.information = information;
		this.approxTime = combineTime(approxHours, approxMin);
		this.deadlineTime = combineTime(deadlineHours, deadlineMin);
		this.jobCompleted = false;
		this.importance = -1;
		this.timeOfCreation = timestamp;
	}

	private int combineTime(String hours, String minutes) {
		int totalMin = Integer.parseInt(minutes);
		int hourMin = Integer.parseInt(hours) * 60;
		totalMin = totalMin + hourMin;
		return totalMin;
	}

	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}



	public ArrayList<String> getGraphData() {
		return null;
	}
	
	
	
	
	public double getProgress() {
		return this.progress;
	}

	public String getID() {
		return this.ID;
	}
	
	public int getApproxTime() {
		return this.approxTime;
	}
	
	public int getDeadlineTime() {
		return this.deadlineTime;
	}
	
	public String getTimeOfCreation() {
		return this.timeOfCreation;
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
	
	public String getInformation() {
		return this.information;
	}
	
	
}
