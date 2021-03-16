package 动态规划DP;

import java.util.Arrays;

public class 越界 {
    public static void main(String[] args) {
        final 越界 s = new 越界();
        int[] arr={20,25,1,5};
        System.out.println(s.coinChange(arr, 41));
    }
    public int coinChange(int[] arr,int target){
        if(arr == null || arr.length == 0 || target < 0)return -1;
        int[] targets = new int[target+1];
        targets[0] = 0;
        Arrays.sort(arr);
        for (int i = 1; i < targets.length; i++) {   // 1~target 钱的所有最小
            targets[i] = Integer.MAX_VALUE;
            for(int j=0;j<arr.length;j++){
                if(i>=arr[j] && targets[i-arr[j]]!=Integer.MAX_VALUE){
                    targets[i] = Math.min(targets[i-arr[j]]+1,targets[i]);
                }
                else break;
            }
        }
        if(targets[target] == Integer.MAX_VALUE)targets[target] = -1;
        return targets[target];
    }
}
