package com.detail;

import static org.junit.Assert.assertEquals;
import javax.ws.rs.core.*;

import org.junit.Test;

import com.vehicle.service.VehicleIdentifier;

public class VehicleIdentifierTest {	
	
	@Test public void testValidVehicle() {
		Response response = new VehicleIdentifier().getVehicle("MABCDEFGHIJKLMN01");
		assertEquals(200,response.getStatus());	
	}

	@Test public void testInvalidVehicle() {
		Response response = new VehicleIdentifier().getVehicle("1");
		assertEquals("No data Available",response.getEntity());
		assertEquals(response.getStatus(),204);	
	}	

}



