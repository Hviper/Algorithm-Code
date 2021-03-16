package 动态规划DP;

import java.util.Arrays;

public class 最大上升子序列LIS {
    public static void main(String[] args) {
        int[] arr = {10,2,2,5,1,7,101,18,55};
        final 最大上升子序列LIS s = new 最大上升子序列LIS();
        System.out.println(s.LIS(arr));
        String a = "a";
        final char[] chars = a.toCharArray();
    }


    public int LIS(int[] arr){
        int[] targets = new int[arr.length];       //用于保存状态的数组
        Arrays.fill(targets, 1);
        int MAX = 0;
        for(int i=1;i<arr.length;i++){
//            targets[i] = 1;                //一上来先置为 1 ，本身就是 一个 上升子序列，i=0时也需要置为 1
            for(int j=0;j<i;j++){
                if(arr[i]<=arr[j]){
                    continue;
                }
                targets[i] = Math.max(targets[j]+1,targets[i]);
                MAX = Math.max(MAX,targets[i]);
            }
        }
        System.out.println(Arrays.toString(targets));
        return MAX;
    }

}
