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

   public String expected = "{ \"patientPortal\": [ "+
   "{ \"date\": \"2018-10-31\", \"customer_id\": 100003, \"transaction_type\": \"reservation\", \"service\": \"Annual Checkup\", \"patient_id\": 99989 }, "+
   "{ \"date\": \"2019-09-04\", \"customer_id\": 100003, \"transaction_type\": \"reservation\", \"service\": \"Annual Checkup\", \"patient_id\": 99989 }";
   
   public PatientPortal getPatientPortal(){
      String CustomerID = "100003";
      return new PatientPortal(CustomerID);
   }
   
   @Test
   public void patient_portal_retrieved() {
     PatientPortal patientPortal = this.getPatientPortal();
		String result = patientPortal.setCustomerInfo();
    	result.contains(expected);
   
   }
}
