package com.detail;

import java.util.HashMap;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/Vehicle")
public class VehicleIdentifier {
	
	static HashMap<String,Vehicle> vehicleMap = new HashMap<>();
	
	static {		
		Vehicle vehicle1 = new Vehicle("MABCDEFGHIJKLMNO1","Ford","Figo",2018);
		vehicleMap.put(vehicle1.getVin(),vehicle1);
	}
	
	@GET
	@Path("/getVehicle/{vin}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVehicle(@PathParam("vin") final String vin) {
		if(vehicleMap.get(vin)!=null)
		return Response.status(200).entity(vehicleMap.get(vin)).build();
		else
		return Response.status(204).entity("No data Available").build();
				
	}

}
