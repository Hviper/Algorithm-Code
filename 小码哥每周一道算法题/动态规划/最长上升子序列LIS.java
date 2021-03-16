package 小码哥每周一道算法题.动态规划;

import java.util.Arrays;

/**
 * 非连续的序列的一般求解
 * dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
 */
public class 最长上升子序列LIS {
    public static void main(String[] args) {
        final 最长上升子序列LIS s = new 最长上升子序列LIS();
        int[] arr1={0,1,0,3,2,3};
        int[] arr = {10,2,2,5,1,7,101,18,55,11};
        System.out.println(s.LIS(arr1));
    }
    public int LIS(int[] arr){
        int max = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for(int i=1;i<dp.length;i++){
            dp[i] = 1;
            // dp[i] = max(dp[j])+1, 其中0≤j<i且num[j]<num[i]
            for(int j=0;j<i;j++){            //遍历之前的所有dp值，在之前的所有dp值中选择一个最大的再在基础上+1算得目前的dp值
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
}
