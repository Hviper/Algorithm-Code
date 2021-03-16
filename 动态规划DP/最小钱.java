package 动态规划DP;

import java.util.Arrays;

public class 最小钱 {
    public static void main(String[] args) {
        int[] arr = {2,5,7};
        final 最小钱 s = new 最小钱();
        System.out.println(s.change(arr, 27));
        System.out.println(s.Source(19));
    }
    public int change(int[] arr,int target){
        int[] shop = new int[target+1];
        shop[0] = 0;
        for (int i = 1; i <= target; i++) {
            shop[i] = Integer.MAX_VALUE;
            for (int j : arr) {
                if(i-j>=0 && shop[i-j]!=Integer.MAX_VALUE){
                    shop[i] = Math.min(shop[i-j]+1,shop[i]);
                }
            }
        }
        if(shop[target]==Integer.MAX_VALUE){
            shop[target] = -1;
        }
        return shop[target];
    }

    public int Source(int n){
        if(n<=0)return 0;
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2]=1;
        for(int i=3;i<=n;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        System.out.println(Arrays.toString(arr));
        return arr[n];
    }
}
