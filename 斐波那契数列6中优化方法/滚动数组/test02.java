package 斐波那契数列6中优化方法.滚动数组;

public class test02 {
    public static void main(String[] args) {
        test02 s = new test02();
        int i = s.Scrolling_array(6);
        System.out.println(i);

    }
    public int Scrolling_array(int n){
        if(n==1||n==2){return 1;}
        int[] arr={1,1};
        for (int i=3;i<=n;i++){
            arr[i&1]=arr[(i-1)&1]+arr[(i-2)&1];
        }
        return arr[n&1];
    }

}
