package cloudEntities;
import controllers.VCC;

public class Job extends VCC /*implements locatable */ {
	private int ID;
	private String information;
	private int approxTime;
	private int deadlineTime;
	private String progress;
	private String jobType;
	private boolean jobCompleted;
	
	/*
	public String getCheckPoint() {
		return checkPoint;
	}
	*/

	/**
	 * @return the progress
	 */
	public String getProgress() {
		return progress;
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
	
	/*
	public double getLocation() {
		return location;
	}
	
	public double setLocation() {
		this.location = location;
	}
	*/
}
