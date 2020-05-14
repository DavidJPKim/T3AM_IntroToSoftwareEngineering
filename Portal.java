import java.util.List;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;
import java.lang.NullPointerException;


/**
* Returns the result of the HPMS Public Patient Portal API call as a string. 
* The url argument for the api call is provided within the code. 
* <p>
* This method either returns the result of the API as a string or the error
* code F1 in the case where there is a failure with the API Call.
* @param  String Portal: the String that contains the result of the HPMS Bill 
* Public Patient Portal API Call.
* @return String results.
*/

public class Portal{
    
    private String portal;
    //The default constructor, which is left empty on purpose.
    public Portal(){
        portal = getUrlInfo();
    }
    
    public String getPortal(){
        return this.portal;
    }
    
    public String getUrlInfo(){

 

        String urlString="http://happy-pets-web-1522142859.us-east-1.elb.amazonaws.com/patient-portal";

 

        String results=" ";

 

               try{

 

                   URL url=new URL(urlString);

 

                   URLConnection connect=url.openConnection();

 

                   BufferedReader rdr=new BufferedReader(new InputStreamReader(connect.getInputStream()));

 

                   results=rdr.readLine();

 

                   String nextLn=" ";

 

                   try {

 

                       while(nextLn.isEmpty()==false){

 

                           results=results+nextLn;

 

                           nextLn=rdr.readLine();
                       }
                   }

 

                   catch(NullPointerException e) {

 

                   }

 

                   rdr.close();
               }

 

               catch(IOException e){

 

                   return "F1";
                   }

 

        return results;
    }
}
