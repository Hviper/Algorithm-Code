package 常规题;

/**
 * 求解最大公约数
 *
 */
public class 辗转相除法 {
    public static void main(String[] args) {
        System.out.println(gcd(25, 15));


    }

    static public int gcd(int m,int n){
        if(n==0)return m;
        return gcd(n,m%n);           //取余，当取余的数为 0 时，就得出结果
    }

}
