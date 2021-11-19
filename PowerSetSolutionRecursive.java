public class PowerSetSolutionRecursive {
    public static void main(String args[]) {
        StringBuffer set = new StringBuffer("abc");
        StringBuffer ip = new StringBuffer();
        printSubsets(set.toString(), ip.toString());
    }
    
    private static void printSubsets(String ip, String op){
        if(ip.length() == 0){
            System.out.println("{" + op + "}");
            return;
        }
        StringBuffer op1 = new StringBuffer(op);
        StringBuffer op2 =  new StringBuffer(op);
        StringBuffer temp = new StringBuffer(ip);
        
        op2.append(ip.charAt(0)); //include in output - op2
        //Not including in output = op1
        temp.deleteCharAt(0); // Making input smaller
        
        printSubsets(temp.toString(), op1.toString());
        printSubsets(temp.toString(), op2.toString());
    }
}
