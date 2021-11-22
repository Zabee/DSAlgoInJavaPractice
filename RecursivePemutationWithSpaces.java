public class RecursivePemutationWithSpaces {
    public static void main(String args[]) {
      String ip="bc";
      String op="a";
      permWithSpace(ip, op);
    }
    
    private static void permWithSpace(String ip, String op){
        if(ip == null || ip.length() ==0){
            System.out.println(op);
            return;
        }
        StringBuffer op1 = new StringBuffer(op);
        StringBuffer op2 = new StringBuffer(op);
        StringBuffer ipBuff = new StringBuffer(ip);
        char temp = ipBuff.charAt(0);
        ipBuff.deleteCharAt(0);
        op1.append(temp);
        op2.append(" " + temp);
        permWithSpace(ipBuff.toString(), op1.toString());
        permWithSpace(ipBuff.toString(), op2.toString());
    }
}
