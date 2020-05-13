import java.util.List;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * Upon being called, PatientPortal.java recieves the customer's ID number(String customerID) from
 * the user and uses getPatient() to recieve the API data which is saved as String portalsting.
 * This information uses to run setCustomerInfo() which seperates the customer info and looks
 * for the customerID to find the right portal information to return as String pPortal.
 * <p>
 * @param  private String customerID: The ID that the user submits
 * @param  public String pPortal: The String that contains the result of setCustomerInfo()
 * @param  private String portalstring: The string that holds all of the API data
 * @return private String pPortal is returned when setCustomerInfo() is called.
 */

public class PatientBill{
 

    private String customerID; 

    public String pPortal;

    private String portalstring;
   

  public PatientBill(String customerID){
      this.customerID = customerID;
      Portal portal = new Portal();
      portalstring = portal.getPortal();
  }

   public String setCustomerInfo(){
     boolean idfound = false;
     String str[] = billstring.split("},");
     List<String> portalList = new ArrayList<String>();
     portalList = Arrays.asList(str);

     for (int counter = 0; counter < billList.size(); counter++) { 
         String tempportal= portalList.get(counter);
         boolean customerIDfound = tempportal.contains(customerID);

         if (customerIDfound == true){
          pPortal = portalList.get(counter);
          idfound = true;
          
         }
      }

     if(idfound = false){

        throw new IllegalArgumentException("Customer ID not found");
     }
     
     return pPortal;
   } 
           

            
