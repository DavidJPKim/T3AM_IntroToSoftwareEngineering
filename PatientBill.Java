import java.util.List;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * Upon being called, PatientBill.java recieves the customer's ID number(String customerID) from
 * the user and uses getPortal() to recieve the API data which is saved as String billsting.
 * This information uses to run setCustomerInfo() which seperates the customer info and looks
 * for the customerID to find the right bill information to return as String pBill.
 * <p>
 * @param  private String customerID: The ID that the user submits
 * @param  public String pBill: The String that contains the result of setCustomerInfo()
 * @param  private String billstring: The string that holds all of the API data
 * @return private String pBill is returned when setCustomerInfo() is called.
 */

public class PatientBill{
 

    private String customerID; 

    public String pBill;

    private String billstring;
   

  public PatientBill(String customerID){
      this.customerID = customerID;
      Bill bill = new Bill();
      billstring = bill.getBill();
  }

   public String setCustomerInfo(){
     boolean idfound = false;
     String str[] = billstring.split("},");
     List<String> billList = new ArrayList<String>();
     billList = Arrays.asList(str);

     for (int counter = 0; counter < billList.size(); counter++) { 
         String tempbill= billList.get(counter);
         boolean customerIDfound = tempbill.contains(customerID);

         if (customerIDfound == true){
          pBill = billList.get(counter);
          idfound = true;
          
         }
      }

     if(idfound = false){

        throw new IllegalArgumentException("Customer ID not found");
     }
     
     return pBill;
   } 
           

            
