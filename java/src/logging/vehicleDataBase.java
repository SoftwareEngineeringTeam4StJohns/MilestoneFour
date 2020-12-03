package logging;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import cloudEntities.Vehicle;

public class vehicleDataBase {
	private static ArrayList<Vehicle> cars = new ArrayList<>();
	
	public static void database(Vehicle vehicle) {
		cars.add(vehicle);
		connect(vehicle);
	}
	public static boolean connect(Vehicle vehicle) {
		boolean added = false;
		String url =  "jdbc:mysql://localhost:3306/VC3?useTimezone=true&serverTimezone=EST";
		String username = "root";
		String password = "wootang359";
		Calendar calendar = Calendar.getInstance();
		java.sql.Timestamp timeStamp = new java.sql.Timestamp(calendar.getTime().getTime());

	    
		try {
			Connection connection = DriverManager.getConnection(url,username,password);
			String sql = "INSERT INTO vehicletable" + "(OwnerID, vehicleModel, vehicleColor, vehiclePlateNumber, residencyDays, residencyMonths, timestamp)" 
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
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
				System.out.println("Data was inserted!");
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cars.clear();
		added = true;
		return added;
	}
	}
