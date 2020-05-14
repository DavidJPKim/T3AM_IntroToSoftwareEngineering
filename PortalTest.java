//package de.vogella.junit.first;

import org.junit.*;

/**
* This is the test file for Portal.java. It runs one test, which checks whether or 
* not the api connection is succesful.
* <p>
* This method checks if getPortal() is equal to the String expected. 
* @param String expected: The expected results of the api call.
* @return void.
*/

public class PortalTest{
	
	public String expected = "{ \"patientPortal\": [ "+
	"{ \"date\": \"2018-10-31\", \"customer_id\": 100003, \"transaction_type\": \"reservation\", \"service\": \"Annual Checkup\", \"patient_id\": 99989 }, "+
	"{ \"date\": \"2019-09-04\", \"customer_id\": 100003, \"transaction_type\": \"reservation\", \"service\": \"Annual Checkup\", \"patient_id\": 99989 }, "+
	"{ \"date\": \"2017-05-22\", \"customer_id\": 100025, \"transaction_type\": \"reservation\", \"service\": \"Annual Checkup\", \"patient_id\": 99332 } ] }";
	/*
	Returns new instance of Portal.
	*/
	public Portal getPortal(){
		return new Portal();
	}
	
	@Test
	public void test_if_api_connection_successful(){
		Portal portal = this.getPortal();
		String result = portal.getUrlInfo();
    	result.contains(expected);
	}
}
