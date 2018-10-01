package com.vehicle.service;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.vehicle.bean.Vehicle;
import com.vehicle.database.VehicleDatabase;

@Path("/Vehicle")
public class VehicleIdentifier {
	

	private static VehicleDatabase vehicleDatabase = new VehicleDatabase();

	@GET
	@Path("/getVehicle/{vin}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVehicle(@PathParam("vin") final String vin){
		
		Vehicle vehicle;
		
		try {
			if((vehicle=vehicleDatabase.getVehicle(vin)) != null)
			return Response.status(200).entity(vehicle).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(204).entity("No data Available").build();
	}

}
