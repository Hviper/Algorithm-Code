package 位运算;

public class 整数或者小数转化为二进制 {
    public static void main(String[] args) {
        System.out.println(change(0.625));
    }
   static public StringBuffer change(double n){
        StringBuffer sb = new StringBuffer("0.");
        while (n>0){
            n = n*2;
            if(n>=1){
                sb.append('1');
                n = n-1;
            }else {
                sb.append('0');
            }
        }
        return sb;
    }
}
