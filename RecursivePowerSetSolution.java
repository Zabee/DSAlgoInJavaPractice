import java.util.*;
public class RecursivePowerSetSolution {
    public static void main(String args[]) {
        List<String> res = new ArrayList<>();
        subset("abc","", res);
        print(res);
        printLexographicalOrder(res);
    }
    
    private static void print(List<String> subsets){
        for(String subset : subsets){
            System.out.println(subset);
        }
    }
    
        private static void printLexographicalOrder(List<String> res){
//      lexicographic order
        Collections.sort(res);
        print(res);
    }
    
    private static void subset(String ip, String op, List<String> subsetsList){
        if(ip == null || ip.length() ==0){
            // if(!"".equals(op)){
                // System.out.println("{" + op + "}");    
                subsetsList.add(op);
            // }
            return;
        }
        StringBuffer op1 = new StringBuffer(op);
        StringBuffer op2 = new StringBuffer(op);
        StringBuffer strBufIp = new StringBuffer(ip);
        op1.append(strBufIp.charAt(0));
        strBufIp.deleteCharAt(0);
        //include
        subset(strBufIp.toString(), op1.toString(), subsetsList);
        //don't include
        subset(strBufIp.toString(), op2.toString(), subsetsList);
    }
    
}
