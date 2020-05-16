import org.junit.*;

public class PatientBillTest {

   /**
    * PatientBillTest takes public String expected directly from the website and uses getPatientBill() to
    * assign a CustomerID to test out setCustomerInfo() from PatientBill.
    * <p>
    * @param  public String expected: The String that contains the result the information from the website
    * @param  private PatientBill getPatientBill(): The code to get PatientBill with a CustomerID
    * @return patient_bill_retrieved() sees if the answer contains the expected outcome.
    */
   
   public String expected = "\"patientBilling\": "+
   "[ { \"date\": \"2019-01-01\", \"amount\": 100.0, \"customer_id\": 100003, \"service\": \"Annual Checkup\", \"patient_id\": 99989 },"+
   " { \"date\": \"2020-01-29\", \"amount\": 105.0, \"customer_id\": 100003, \"service\": \"Annual Checkup\", \"patient_id\": 99989 },";
  
   private PatientBill getPatientBill(){
      String CustomerID = "100003";
      return new PatientBill(CustomerID);
   }
   
   @Test
   public void patient_bill_retrieved() {
     PatientBill patientBill = this.getPatientBill();
		String result = patientBill.setCustomerInfo();
    	result.contains(expected);
      
   
      
      
   }
}
   
 

