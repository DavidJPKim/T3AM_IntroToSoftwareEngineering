//package de.vogella.junit.first;

import org.junit.*;

/**
* This is the test file for Bill.java. It runs one test, which checks whether or 
* not the api connection is succesful.
* <p>
* This method checks if the getBill() method returns an equivalent result to the 
* bill.getUrlInfo() method;
* @return void.
*/

public class BillTest{

	private Bill getBill(){
		return new Bill();
	}
	
	@Test
	public void test_if_api_connection_successful(){
		Bill bill = this.getBill();
		String result = bill.getUrlInfo();
    	Assert.assertNotEquals(result, "F1");
	}
}
