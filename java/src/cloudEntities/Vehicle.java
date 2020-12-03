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
	private String vehicleColor;
	private String plateNumber;
	private String vehicleModel;
	private String vehicleStatus;
	private String comSpec;
	private String timeOfCreation;
	private int occupancyDays;
	private int occupancyMons; 
	
	

	public Vehicle(String ID, String vehicleModel, String vehicleColor, String plateNumber, String approxDays, String approxMons,
			String timestamp) {
		this.ID = ID;
		this.vehicleModel = vehicleModel;
		this.vehicleColor = vehicleColor;
		this.plateNumber = plateNumber; 
		this.occupancyDays = Integer.parseInt(approxDays);
		this.occupancyMons = Integer.parseInt(approxMons);
		this.timeOfCreation = timestamp;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	/**
	 * @param vehicleColor the vehicleColor to set
	 */
	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	/**
	 * @return the plateNumber
	 */
	public String getPlateNumber() {
		return plateNumber;
	}

	/**
	 * @param plateNumber the plateNumber to set
	 */
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	/**
	 * @return the vehicleModel
	 */
	public String getVehicleModel() {
		return vehicleModel;
	}

	/**
	 * @param vehicleModel the vehicleModel to set
	 */
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	/**
	 * @return the vehicleStatus
	 */
	public String getVehicleStatus() {
		return vehicleStatus;
	}

	/**
	 * @param vehicleStatus the vehicleStatus to set
	 */
	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	/**
	 * @return the comSpec
	 */
	public String getComSpec() {
		return comSpec;
	}

	/**
	 * @param comSpec the comSpec to set
	 */
	public void setComSpec(String comSpec) {
		this.comSpec = comSpec;
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
	
	public int getOccupanyDays() {
		return this.occupancyDays;
	}
	
	public int getOccupanyMons() {
		return this.occupancyMons;
	}
	
	
	public String getTimeOfCreation() {
		return this.timeOfCreation;
	}

	public void createImage(Vehicle vehicleSpawn) {
		Iterator<Job> jobIterator = this.currentJobs.iterator();
		while(jobIterator.hasNext()) {
			vehicleSpawn.addJob(jobIterator.next());
		}
		
	}
	
	
}
