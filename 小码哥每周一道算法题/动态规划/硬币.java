package 小码哥每周一道算法题.动态规划;

import java.util.Arrays;
import java.util.Stack;

public class 硬币 {
    public static void main(String[] args) {
        final 硬币 s = new 硬币();
        int[] arr = {1,5,25,20};
        System.out.println(s.coin(arr, 100));
        System.out.println(s.doubleSort(2, 2));
    }
    public int coin(int[] arr,int target){
        int[] dp = new int[target+1];
        dp[0] = 0;
        for(int value=1;value<=target;value++){
            dp[value] = Integer.MAX_VALUE;
            for(int coin:arr){
                if(value-coin>=0 && dp[value-coin]!=Integer.MAX_VALUE){
                    dp[value] = Math.min(dp[value-coin]+1,dp[value]);
                }
            }
        }
        if(dp[target] == Integer.MAX_VALUE) dp[target] = 0;
        return dp[target];
    }

    //二维机器人找路
    public int doubleSort(int row,int col){
        int[][] dp = new int[row][col];
        for(int i=1;i<col;i++){
            dp[0][i] = 1;
        }
        for(int i=1;i<row;i++){
            dp[i][0] = 1;
        }
        for(int r=1;r<row;r++){
            for(int l=1;l<col;l++){
                dp[r][l] = dp[r-1][l]+dp[r][l-1];
            }
        }
        return dp[row-1][col-1];
    }
}
