//package de.vogella.junit.first;

import org.junit.*;

/**
* This is the test file for Portal.java. It runs one test, which checks whether or 
* not the api connection is succesful.
* <p>
* This method either returns the result of whether or not the getUrlInfo() method
* of Portal.java matches the asert as the string F1. Otherwise it returns nothing
*
* @param  Portal: A Portal object.
* @param  String results: the String that contains the result of the getUrlInfo()
* method.
* @return A string of "F1", which notifies the Test Runner that the connection failed.
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
