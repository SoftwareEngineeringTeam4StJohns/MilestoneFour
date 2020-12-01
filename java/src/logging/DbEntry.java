package logging;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import cloudEntities.Job;


public class DbEntry {
	private static ArrayList<Job> jobPool = new ArrayList<>();
	
	public static void jobToDB(Job job) {
		jobPool.add(job);
		addtoDB(job);
	}
	
	public static boolean addtoDB(Job job) {
		boolean added = false;
		String url = "jdbc:mysql://localhost:3306/vcc";
		String username = "root";
		String password = "password";
		
		Calendar calendar = Calendar.getInstance();
		java.sql.Timestamp timeStamp = new java.sql.Timestamp(calendar.getTime().getTime());

	    
		try {
			Connection connection = DriverManager.getConnection(url,username,password);
			String sql = "INSERT INTO clientjob (`Client ID`, JobInfo, ApproxJobTime, DeadLineTime, `TimeStamp`) VALUES (?,?,?,?,?)";
			
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, job.getID());
			statement.setString(2, job.getInformation());
			statement.setString(3, (Integer.toString(job.getApproxTime())));
			statement.setString(4, (Integer.toString(job.getDeadlineTime())));
			statement.setTimestamp(5, timeStamp);
			
	
			int row = statement.executeUpdate();
			if (row > 0) {
				System.out.println("Data was inserted!");
			}
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		jobPool.clear();
		added = true;
		return added;
	}
}
