package logging;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import cloudEntities.Job;
import cloudEntities.Vehicle;


public class DbEntry {
	
	public static void addJobToDB(Job job) {

		String url = "jdbc:mysql://localhost:3306/vehicularcloudsystem";
		String username = "root";
		String password = "skinnyR0cky442";
		
		Calendar calendar = Calendar.getInstance();
		java.sql.Timestamp timeStamp = new java.sql.Timestamp(calendar.getTime().getTime());

	    
		try {
			Connection connection = DriverManager.getConnection(url,username,password);
			String sql = "INSERT INTO job (`id`, `info`, `approxTime`, `deadLineTime`, `timeStamp`) VALUES (?,?,?,?,?)";
			
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, job.getID());
			statement.setString(2, job.getInformation());
			statement.setInt(3, job.getApproxTime());
			statement.setInt(4, job.getDeadlineTime());
			statement.setTimestamp(5, timeStamp);
			
	
			int row = statement.executeUpdate();
			if (row > 0) {
				System.out.println("Data inserted for job " + job.getID()+ "!");
			}
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

	public static void addVehicleToDB(Vehicle vehicle) {
		String url = "jdbc:mysql://localhost:3306/vehicularcloudsystem";
		String username = "root";
		String password = "skinnyR0cky442";
		
		Calendar calendar = Calendar.getInstance();
		java.sql.Timestamp timeStamp = new java.sql.Timestamp(calendar.getTime().getTime());

	    
		try {
			Connection connection = DriverManager.getConnection(url,username,password);
			String sql = "INSERT INTO vehicle (`id`, `model`, `color`, `plateNumber`, `residencyDays`, `residencyMonths` , `timeStamp`) VALUES (?,?,?,?,?,?,?)";
			
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, vehicle.getID());
			statement.setString(2, vehicle.getVehicleModel());
			statement.setString(3, vehicle.getVehicleColor());
			statement.setString(4, vehicle.getPlateNumber());
			statement.setInt(5, vehicle.getOccupanyDays());
			statement.setInt(6, vehicle.getOccupanyMons());
			statement.setTimestamp(7, timeStamp);
			
	
			int row = statement.executeUpdate();
			if (row > 0) {
				System.out.println("Data inserted for vehicle " + vehicle.getID()+ "!");
			}
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}