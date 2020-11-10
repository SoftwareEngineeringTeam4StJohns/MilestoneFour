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
	private static ArrayList<HashMap<String, String>> jobPool = new ArrayList<>();
	private static ArrayList<HashMap<String, String>> vehiclePool = new ArrayList<>();
	
	public static void logJob(HashMap<String, String> jobEntry) {
		jobPool.add(jobEntry);
		createJobJSON(jobEntry);
	}
	public static void logVehicle(HashMap<String, String> vehicleEntry) {
		vehiclePool.add(vehicleEntry);
		createVehicleJSON(vehicleEntry);
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
				csvWriter.append("Approx. Job Hours");
				csvWriter.append(",");
				csvWriter.append("Approx. Job Min.");
				csvWriter.append(",");
				csvWriter.append("Deadline Hours");
				csvWriter.append(",");
				csvWriter.append("Deadline Min.");
				csvWriter.append(",");
				csvWriter.append("Timestamp");
				csvWriter.append("\n");
				
				for(HashMap<String, String> jobEntry: jobPool) {
					csvWriter.append(String.join(",", jobEntry.values()));
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
				
				for(HashMap<String, String> vehicleEntry: vehiclePool) {
					csvWriter.append(String.join(",", vehicleEntry.values()));
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
	private static void createJobJSON(HashMap<String, String> jobEntry) {
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		String jobID = jobEntry.get("ID");
		JSONObject obj = new JSONObject();
		obj.put("ID", jobID);
		obj.put("type", "job type text");
		obj.put("location", "job location text");
		obj.put("info", "job info text");
		obj.put("approxTime", "12:22");
		obj.put("deadlineTime", "03/45");
		try {
			//saving as a text file for easy parsing later on 
			jsonWriter = new FileWriter("logs/jobs/ID_"+jobID+"_"+timeStamp+".json");
			jsonWriter.write(obj.toJSONString());
			jsonWriter.flush();
			jsonWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private static void createVehicleJSON(HashMap<String, String> vehicleEntry) {
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		JSONObject obj = new JSONObject();
		String vehID = vehicleEntry.get("ID"); 
		obj.put("ID", vehID);
		obj.put("compSpec", vehicleEntry.get("compSpec"));
		obj.put("location", vehicleEntry.get("location"));
		obj.put("model", vehicleEntry.get("vehModel"));
		obj.put("plate_number", vehicleEntry.get("plate"));
		obj.put("color", vehicleEntry.get("vehColor"));
		try {
			//saving as a text file for easy parsing later on 
			jsonWriter = new FileWriter("logs/vehicles/ID_"+vehID+"_"+timeStamp+".json");
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
