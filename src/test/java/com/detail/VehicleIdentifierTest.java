package com.detail;

import static org.junit.Assert.assertEquals;
import javax.ws.rs.core.Response;
import org.junit.Test;

public class VehicleIdentifierTest {
	
	@Test public void testValidVehicle() {
		Response response = new VehicleIdentifier().getVehicle("MABCDEFGHIJKLMNO1");
		assertEquals(response.getStatus(),200);	
	}
	
	@Test public void testInvalidVehicle() {
		Response response = new VehicleIdentifier().getVehicle("1");
		assertEquals(response.getStatus(),204);	
	}
	

}
