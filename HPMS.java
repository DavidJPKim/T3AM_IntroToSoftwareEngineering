/*
 * HPMS is the client of the HPMS application for Happy Pets Patient Management System
 */
public class HPMS {
    /*
     * isArgumentValid takes a String array as an argument and returns true only if given the following arguments in any order
     * --billing/--patient-portal and/or --customer-id
     */
    private static int componentCode;                                                                                                            
    public static boolean isArgumentValid(String[]args) {
    	//tests if given the correct amount of arguments
    	if(args.length!=1&&args.length!=3)return false;
    	//tests if the first arg is --customer-id and the 3rd arg is --billing or --patient-portal
    	else if(args[0].equals("--customer-id")&&(args[2].equals("--billing")||args[2].equals("--patient-portal"))) {
            componentCode=1;
            return true;
        }
        //tests if first arg is --billing or --patient-portal nad the 2nd arg is --customer-id and also that the array is of length 3
        else if(args.length==3&&((args[0].equals("--billing")||args[0].equals("--patient-portal"))&&args[1].equals("--customer-id"))) {
            componentCode=1;
            return true;
        }
        //tests if the only arg is --billing or --patient-portal
        else if(args.length==1&&(args[0].equals("--billing")||args[0].equals("--patient-portal"))) {
            componentCode=0;
            return true;
        }
        //if this is reached then the arguments are invalid
        else return false;
    }
    //takes the component code and decides which class that needs an object made for and prints the wanted results
    public static void componentCaller(int componentCode,String[] args) {
        if(componentCode==0) {
        
            if(args[0].equals("--billing")){
                Bill bill =new Bill();
                System.out.println(bill.getBill());
                
            }
            else {
                Portal portal=new Portal();
                System.out.println(portal.getPortal());
                
            }
            
        }
        else {
            String id=getId(args);
            if(args[0].equals("--customer-id")&&args[2].equals("--billing")||args[0].equals("--billing")&& args[1].equals("--customer-id")){
                //billPatient
                PatientBill pBill=new PatientBill(id);
                System.out.println(pBill.setCustomerInfo());
            }
            
            else if(args[0].equals("--customer-id")&&args[2].equals("--patient-portal")||args[0].equals("--patient-portal")&& args[1].equals("--customer-id")) {
                PatientPortal pPortal=new PatientPortal(id);
                System.out.println(pPortal.setCustomerInfo());
                
            }
            
            
        }
    }
         //takes String[] args as a parameter and finds the customer id in the arguments and returns it as a string
        public static String getId(String[] args){
             if(args[0].equals("--customer-id"))return args[1];
                else return args[2];
            
        }
    
   //main method that runs the client, takes 1 or 3 arguments without causing error
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        if(!isArgumentValid(args)) {
            System.err.println("Invalid Argument/s provided");
            System.exit(1);
        }
        componentCaller(componentCode,args);
    }

 

}
