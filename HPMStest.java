import org.junit.Test;
import org.junit.Ignore;
import org.junit.Assert;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
//tests the HPMS client and its methods
public class HPMStest {      /*   Returns a new instance of Calculator.   */   
    private HPMS getHPMS(){      
     return new HPMS();  
     } 
    //tests isArgumentValid returns false when the args.length is not 1 or 3
    @Test
    public void test_isArgumentValid_correctArgsLength() {     
        HPMS hpms = this.getHPMS();       
        String[] args=new String[2];
        args[0]="--customer-id";
        args[1]="--billing";
        boolean result = HPMS.isArgumentValid(args);      
        Assert.assertEquals(result, false);   
    }
    //tests isArgumentValid returns true when args.length=3 ,args[0]=--customer-id and args[2] is --billing
     @Test   
     public void test_isArgumentValid_idFirstandBillOrPortalThirdSuccess() {     
        HPMS hpms = this.getHPMS();       
        String[] args=new String[3];
        args[0]="--customer-id";
        args[1]="100003";
        args[2]="--billing";
        boolean result = HPMS.isArgumentValid(args);      
        Assert.assertEquals(result, true);   
    }
   //tests isArgumentValid returns false when the args.length= 3 but the arguments are spelled wrong 
    @Test  
    public void test_isArgumentValid_idFirstandBillOrPortalThirdFail() {     
        HPMS hpms = this.getHPMS();       
        String[] args=new String[3];
        args[0]="--customer-id";
        args[1]="100003";
        args[2]="billing";
        boolean result = HPMS.isArgumentValid(args);      
        Assert.assertEquals(result, false);   
    }
  //tests isArgumentValid  returns true when args.length=3 and --billing is first and --customer-id is 2nd
    @Test  
    public void test_isArgumentValid_BillOrPortalFirstandIdSecondSuccess() {     
        HPMS hpms = this.getHPMS();       
        String[] args=new String[3];
        args[0]="--billing";
        args[1]="--customer-id";
        args[2]="100003";
        boolean result = HPMS.isArgumentValid(args);      
        Assert.assertEquals(result, true);   
    } 
  //tests isArgumentValid returns true and the arguments are spelled correctly
    @Test  
     public void test_isArgumentValid_BillOrPortalSuccess() {     
        HPMS hpms = this.getHPMS();       
        String[] args=new String[1];
        args[0]="--billing";
        boolean result = HPMS.isArgumentValid(args);      
        Assert.assertEquals(result, true);   
    }  
  //tests isArgumentValid returns false when args.length=1 and the arguments are spelled wrong
    @Test  
    public void test_isArgumentValid_BillOrPortalFail() {     
        HPMS hpms = this.getHPMS();       
        String[] args=new String[1];
        args[0]="-billing";
        boolean result = HPMS.isArgumentValid(args);      
        Assert.assertEquals(result, false);   
    }  
    //tests componentCaller to see if the right result is being printed
    @Test
    public void test_componentCaller_billing() {   
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        HPMS hpms = this.getHPMS();       
        String[] args=new String[1];
        args[0]="--billing";
        HPMS.componentCaller(0,args);
        System.out.flush();
        System.setOut(old);
        String result=baos.toString();
        Assert.assertEquals(result, "{         \"patientBilling\": [      {         \"date\": \"2019-01-01\",          \"amount\": 100.0,         \"customer_id\": 100003,          \"service\": \"Annual Checkup\",         \"patient_id\": 99989      },       {         \"date\": \"2020-01-29\",          \"amount\": 105.0,          \"customer_id\": 100003,          \"service\":\"Annual Checkup\",          \"patient_id\": 99989      },       {         \"date\": \"2019-07-16\",          \"amount\": 100.0,          \"customer_id\": 100025,          \"service\": \"Annual Checkup\",          \"patient_id\": 99332      }   ]}         ");   
    }
  //tests componentCaller to see if the right result is being printed
    @Test 
     public void test_componentCaller_portal() {   
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        HPMS hpms = this.getHPMS();       
        String[] args=new String[1];
        args[0]="--patient";
        HPMS.componentCaller(0,args);
        System.out.flush();
        System.setOut(old);
        String result=baos.toString();
        Assert.assertEquals(result, "       {    \"patientPortal\": [      {         \"date\": \"2018-10-31\",          \"customer_id\": 100003,          \"transaction_type\": \"reservation\",          \"service\": \"Annual Checkup\",          \"patient_id\": 99989      },       {         \"date\": \"2019-09-04\",          \"customer_id\": 100003,          \"transaction_type\": \"reservation\",          \"service\": \"Annual Checkup\",          \"patient_id\": 99989      },       {         \"date\": \"2017-05-22\",          \"customer_id\": 100025,          \"transaction_type\": \"reservation\",          \"service\": \"Annual Checkup\",          \"patient_id\": 99332      }   ]}      ");   
    } 
  //tests componentCaller to see if the right result is being printed
    @Test 
    public void test_componentCaller_billingAndId() {   
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        HPMS hpms = this.getHPMS();       
        String[] args=new String[3];
        args[0]="--billing";
        args[1]="--customer-id";
        args[2]="100003";
        HPMS.componentCaller(1,args);
        System.out.flush();
        System.setOut(old);
        String result=baos.toString();
        
        Assert.assertEquals(result, "       {         \"date\": \"2020-01-29\",          \"amount\": 105.0,          \"customer_id\": 100003,          \"service\": \"Annual Checkup\",          \"patient_id\": 99989      ");   
    } 
  //tests componentCaller to see if the right result is being printed
    @Test 
    public void test_componentCaller_portalgAndIdDifferntArgsOrder() {   
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        HPMS hpms = this.getHPMS();       
        String[] args=new String[3];
        args[0]="--customer-id";
        args[1]="100003";
        args[2]="--patient-portal";
        HPMS.componentCaller(1,args);
        System.out.flush();
        System.setOut(old);
        String result=baos.toString();
        System.out.println(result);
        Assert.assertEquals(result, "       {         \"date\": \"2019-09-04\",          \"customer_id\": 100003,          \"transaction_type\": \"reservation\",          \"service\": \"Annual Checkup\",          \"patient_id\": 99989      ");   
    }
  //tests getId to see if the correct id is being found
    @Test 
    public void test_getId_IdAtIndex1(){
        HPMS hpms=this.getHPMS();
        String[] args=new String[3];
        args[0]="--customer-id";
        args[1]="100003";
        args[2]="--patient-portal";
        String result=hpms.getId(args);
        Assert.assertEquals(result, "100003"); 
    }
  //tests getId to see if the correct id is being found
    @Test 
    public void test_getId_IdAtIndex2(){
        HPMS hpms=this.getHPMS();
        String[] args=new String[3];
        args[0]="--billing";
        args[1]="--customer-id";
        args[2]="100003";
        String result=hpms.getId(args);
        Assert.assertEquals(result, "100003"); 
    }
    
    
   
}