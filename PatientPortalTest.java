import org.junit.*;

public class PatientPortalTest {

   /**
    * PatientPortalTest takes public String expected directly from the website and uses getPatientPortal() to
    * assign a CustomerID to test out setCustomerInfo() from PatientPortal.
    * <p>
    * @param  public String expected: The String that contains the result the information from the website
    * @param  private PatientPortal getPatientPortal(): The code to get PatientPortal with a CustomerID
    * @return patient_portal_retrieved() sees if the answer contains the expected outcome.
    */

   //needs to be updated
   public String expected = "\"patientBilling\": "+
   "[ { \"date\": \"2019-01-01\", \"amount\": 100.0, \"customer_id\": 100003, \"service\": \"Annual Checkup\", \"patient_id\": 99989 },"+
   " { \"date\": \"2020-01-29\", \"amount\": 105.0, \"customer_id\": 100003, \"service\": \"Annual Checkup\", \"patient_id\": 99989 },";
  
   private PatientPortal getPatientPortal(){
      String CustomerID = "100003";
      return new PatientPortal(CustomerID);
   }
   
   @Test
   public void patient_portal_retrieved() {
     PatientPortal patientPortal = this.getPatientPortal();
		String result = patientPortal.setCustomerInfo();
    	result.contains(expected);
      
   
      
      
   }
   
 
