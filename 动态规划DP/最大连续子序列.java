package 动态规划DP;

/**
 * 子串、子数组、子区间必须是连续的，子序列是可以不连续的
 */

public class 最大连续子序列 {
    public static void main(String[] args) {
        final 最大连续子序列 s = new 最大连续子序列();
        int[] arr= {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s.minLen(arr));
    }



    public int LIS(int[] arr){
        int[] targets = new int[arr.length+1];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            targets[i] = Math.max(targets[i-1]+arr[i],arr[i]);
            max = Math.max(max,targets[i]);
        }
        return max;
    }
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length+1];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<dp.length;i++){
            dp[i] = nums[i-1];
            dp[i] = Math.max(dp[i],dp[i]+dp[i-1]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }








    public int minLen(int[] arr){
        int[] targets = new int[arr.length+1];
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            targets[i] = Math.max(targets[i-1]+arr[i],arr[i]);
            max = Math.max(max,targets[i]);
        }
        return max;
    }
}
