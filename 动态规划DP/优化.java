package 动态规划DP;

import java.util.PriorityQueue;

public class 优化 {
    public static void main(String[] args) {
        final 优化 s = new 优化();
        int[] arr= {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s.minLen(arr));
    }
    public int sum(int n){
        if(n==1 || n==2)return 1;
        int[] arr = new int[n+1];
        arr[1] = arr[2] =1;
        for(int i=3;i<=n;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
    public int dfs(int i, int j,int m,int n){
        if(i>m || j>n)return 0;
        if(i==m && j==n)return 1;
        return dfs(i+1,j,m,n)+dfs(i,j+1,m,n);
    }
    //最大连续子序列           ----------------->   动态规划
    public int minLen(int[] arr){
        int[] targets = new int[arr.length+1];
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            targets[i] = Math.max(targets[i-1]+arr[i-1],arr[i-1]);
            max = Math.max(max,targets[i]);
        }
        return max;
    }
}
