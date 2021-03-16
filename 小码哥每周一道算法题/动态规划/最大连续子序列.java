package 小码哥每周一道算法题.动态规划;

public class 最大连续子序列 {
    public static void main(String[] args) {
        final 最大连续子序列 s = new 最大连续子序列();
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s.maxSubArray2(arr));
    }
    public int maxSubArray(int[] arr){
        if(arr==null || arr.length==0)return 0;
        int[] dp = new int[arr.length+1];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    //
    public int maxSubArray2(int[] arr){
        if(arr==null || arr.length==0)return 0;
        int dp = arr[0];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            if(dp+arr[i]<=arr[i]){
                dp = arr[i];
            }else {
                dp = dp+arr[i];
            }
            max = Math.max(dp,max);
        }
        return max;
    }
}
