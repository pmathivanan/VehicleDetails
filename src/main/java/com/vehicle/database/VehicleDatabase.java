package com.vehicle.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vehicle.bean.Vehicle;

public class VehicleDatabase {
	
	private static Connection connection;
	
	static {
		
		try {
			Class.forName("org.h2.Driver");
			connection=DriverManager.getConnection("jdbc:h2:mem:testdb;LOCK_MODE=0;INIT=runscript from 'C:/Projects/VehicleDetails/VehicleDetails/src/main/resources/init.sql'", "sa", "");
			//connection=DriverManager.getConnection("jdbc:h2:mem:testdb;LOCK_MODE=0;INIT=runscript from 'init.sql'", "sa", "");
			//connection=DriverManager.getConnection("jdbc:h2:./test", "sa", "");
			System.out.println("Connection Initialized:");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public Vehicle getVehicle(String vinNumber) throws Exception {
		
		Statement statement = getConnection().createStatement(); 
		ResultSet resultSet = statement.executeQuery(buildQuery(vinNumber));
		return retrieveVehicle(resultSet);		
		
	}

	private String buildQuery(String vinNumber) {
		StringBuilder query = new StringBuilder();
		query.append("select * from Vehicle where vin='");
		query.append(vinNumber);
		query.append("';");
		return query.toString();
	}

	private Vehicle retrieveVehicle(ResultSet resultSet) throws SQLException {
		
		Vehicle vehicle =null;
		try {
		while(resultSet.next()) {
			String vin = resultSet.getString("VIN");
			String brand = resultSet.getString("BRAND");
			String vehicleLine=resultSet.getString("VEHICLE_LINE");
			int modelYear = resultSet.getInt("MODEL_YEAR");
			vehicle = new Vehicle(vin, brand, vehicleLine, modelYear);
		} }
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return vehicle;
	}
	
	private Connection getConnection() throws Exception {
		
			if(connection.isClosed()) {
			Class.forName("org.h2.Driver");
			connection=DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
			}
		
		return connection;	
	}
	
	

}
