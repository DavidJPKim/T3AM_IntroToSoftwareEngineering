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
        if(args[0].equals("--customer-id")&&(args[2].equals("--billing")||args[2].equals("--patient-portal"))) {
            componentCode=1;
            return true;
        }
        else if(args.length==3&&((args[0].equals("--billing")||args[0].equals("--patient-portal"))&&args[1].equals("--customer-id"))) {
            componentCode=1;
            return true;
        }
        else if(args.length==1&&(args[0].equals("--billing")||args[0].equals("--patient-portal"))) {
            componentCode=0;
            return true;
        }
        else return false;
    }
    //
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
            String id;
            
                if(args[0].equals("--customer-id")){
                    id=args[1];
                }
                else id=args[2];
            
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
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        if(!isArgumentValid(args)) {
            System.err.println("Invalid Argument/s provided");
            System.exit(1);
        }
        componentCaller(componentCode,args);

 

    }

 

}
