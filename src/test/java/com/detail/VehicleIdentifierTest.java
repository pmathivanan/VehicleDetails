package com.detail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import javax.ws.rs.core.Response;
import org.junit.Test;

public class VehicleIdentifierTest {
	
	@Test public void testGetVehicle() {
		VehicleIdentifier vehicle=new VehicleIdentifier();
		Response response = vehicle.getVehicle("MABCDEFGHIJKLMNO1");
		assertEquals(response.getStatus(),200);	
	}
	

}
