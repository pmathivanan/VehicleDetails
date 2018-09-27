package com.detail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
		return Response.status(200).entity(vehicleMap.get(vin)).build();
	}

}
