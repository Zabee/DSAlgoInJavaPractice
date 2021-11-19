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
        op2.append(ip.charAt(0));
        StringBuffer temp = new StringBuffer(ip);
        temp.deleteCharAt(0);
        //Don't include in output
        printSubsets(temp.toString(), op1.toString());
        // include in output
        printSubsets(temp.toString(), op2.toString());
    }
}
