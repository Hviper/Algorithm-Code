package 斐波那契数列6中优化方法.利用数组优化;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        test test = new test();
        int[] fbn = test.Fbn(25);
        System.out.println(Arrays.toString(fbn));

    }
    public int[] Fbn(int n){
        int[] arr=new int[n+1];
        arr[1]=1;
        arr[2]=1;
        fb(n,arr);
        return arr;
    }
    private int fb(int n,int[] arr){
        if(arr[n]==0){
            arr[n]=fb(n-1,arr)+fb(n-2,arr);
        }
        return arr[n];    //边界为arr[1]=1 / arr[2]=1
    }


}
