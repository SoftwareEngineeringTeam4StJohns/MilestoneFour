package logging;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.JSONObject;

import cloudEntities.Job;
import cloudEntities.Vehicle;


public class Loggers {
	private static FileWriter csvWriter;
	private static FileWriter jsonWriter;
	private static ArrayList<Job> jobPool = new ArrayList<>();
	private static ArrayList<Vehicle> vehiclePool = new ArrayList<>();
	
	public static void logJob(Job job) {
		jobPool.add(job);
		createJobJSON(job);
	}
	public static void logVehicle(Vehicle vehicle) {
		vehiclePool.add(vehicle);
		createVehicleJSON(vehicle);
	}
	
	/*
	 * Log generation for the Vehicle Cloud Controller. There is a dynamic file name therefore no file conflicts.
	 */
	public static boolean generateLogs() {
		//client logs
		boolean logsMade = false;
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		if (jobPool.isEmpty() != true) {		
			try {
				csvWriter = new FileWriter("logs/clientGUI/jobs/JOB_LOGS_"+timeStamp+".csv");
				csvWriter.append("Client id");
				csvWriter.append(",");
				csvWriter.append("Job Info.");
				csvWriter.append(",");
				csvWriter.append("Estimated Time");
				csvWriter.append(",");
				csvWriter.append("Time to Deadline");
				csvWriter.append(",");
				csvWriter.append("Timestamp");
				csvWriter.append("\n");
				
				for(Job job: jobPool) {
					csvWriter.append(job.getID());
					csvWriter.append(",");
					csvWriter.append(job.getInformation());
					csvWriter.append(",");
					csvWriter.append(Integer.toString(job.getApproxTime()));
					csvWriter.append(",");
					csvWriter.append(Integer.toString(job.getDeadlineTime()));
					csvWriter.append(",");
					csvWriter.append(job.getTimeOfCreation());
					csvWriter.append("\n");
				}
				csvWriter.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			jobPool.clear();
			logsMade = true;
		}
		//owner logs
		if (vehiclePool.isEmpty() != true) {
			try {		
				csvWriter = new FileWriter("logs/clientGUI/vehicles/VEHICLE_LOGS_"+timeStamp+".csv");
				csvWriter.append("Owner id");
				csvWriter.append(",");
				csvWriter.append("Vehicle Model");
				csvWriter.append(",");
				csvWriter.append("Vehicle Color");
				csvWriter.append(",");
				csvWriter.append("Vehicle Plate Number");
				csvWriter.append(",");
				csvWriter.append("Approx. Residency Days");
				csvWriter.append(",");
				csvWriter.append("Approx Residency Months");
				csvWriter.append(",");
				csvWriter.append("Timestamp");
				csvWriter.append("\n");
				
				for(Vehicle vehicle: vehiclePool) {
					csvWriter.append(vehicle.getID());
					csvWriter.append(vehicle.getVehicleModel());
					csvWriter.append(vehicle.getVehicleColor());
					csvWriter.append(vehicle.getPlateNumber());
					csvWriter.append(Integer.toString(vehicle.getOccupanyDays()));
					csvWriter.append(Integer.toString(vehicle.getOccupanyMons()));
					csvWriter.append(vehicle.getTimeOfCreation());
					csvWriter.append("\n");
				}
				csvWriter.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			vehiclePool.clear();
			logsMade = true;
		}
		
		return logsMade;
		
	}
	
	/*
	 * The idea here is to create a json file that will be loaded to instantiate any new 
	 * jobs and vehicles for the VCC's files until we use a db 
	 */
	@SuppressWarnings("unchecked")
	private static void createJobJSON(Job job) {
	
		JSONObject obj = new JSONObject();
		obj.put("ID", job.getID());
		obj.put("type", job.getJobType());
		obj.put("location", job.getLocation());
		obj.put("info", job.getInformation());
		obj.put("approxTime", job.getApproxTime());
		obj.put("deadlineTime", job.getDeadlineTime());
		try {
			//saving as a text file for easy parsing later on 
			jsonWriter = new FileWriter("logs/jobs/ID_"+job.getID()+"_"+job.getTimeOfCreation()+".json");
			jsonWriter.write(obj.toJSONString());
			jsonWriter.flush();
			jsonWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private static void createVehicleJSON(Vehicle vehicle) {
		JSONObject obj = new JSONObject();
		obj.put("ID", vehicle.getID());
		obj.put("compSpec", vehicle.getComSpec());
		obj.put("location", vehicle.getLocation());
		obj.put("model", vehicle.getVehicleModel());
		obj.put("plate_number", vehicle.getPlateNumber());
		obj.put("color", vehicle.getVehicleColor());
		try {
			//saving as a text file for easy parsing later on 
			jsonWriter = new FileWriter("logs/vehicles/ID_"+vehicle.getID()+"_"+vehicle.getTimeOfCreation()+".json");
			jsonWriter.write(obj.toJSONString());
			jsonWriter.flush();
			jsonWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void createGraphInfo(HashMap<String, Job> jobs) {
		try {
			String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			if (!(jobs.isEmpty())){
				JSONObject obj = new JSONObject();
				for(Job job:jobs.values()) {
					String jobID = job.getID();
					jsonWriter = new FileWriter("../../../graphing/jobID"+jobID+".json");
					obj.put("ID", jobID);
					obj.put("progress", job.getProgress());
					jsonWriter.write(obj.toJSONString());
					jsonWriter.flush();
					jsonWriter.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
