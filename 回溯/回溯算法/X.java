package 回溯.回溯算法;

public class X {
    public static void main(String[] args) {
        X x = new X();
        System.out.println(x.sum1(2, 5));
        System.out.println(x.sum2(2, 5));
    }
    public int sum1(int x,int n ){
        if(n == 1)return x;
        return sum1(x,n-1) * x;
    }
    public int sum2(int x,int n){
        if(n == 1)return x;
        int result=1;
        for (int i = 0; i < n; i++) {
            result = result * x;
        }
        return result;
    }
}
