package 双指针;

import java.util.Arrays;

public class 确定未排序区间 {
    public static void main(String[] args) {
        final 确定未排序区间 s = new 确定未排序区间();
        int[] arr = {1,5,4,3,2,6,7,2,8};
        final int[] sort = s.sort(arr);
        System.out.println(Arrays.toString(sort));
    }
    public int[] sort(int[] arr){
        int[] res = new int[2];
        if(arr ==null || arr.length ==0)return new int[]{-1,-1};
        int max = arr[0];
        int min = arr[arr.length-1];
        int right = 0;
        int left = 0;
        for(int i=0;i<arr.length;i++){
            //最大值max和记录逆序对的关系是 if else 的关系 ，遇到正序的序列就一直跳，max确定最大值，right用来记录逆序对
            if(max<arr[i]){
                max = arr[i];
            }else {
                right = i;         //记录索引位置
            }
        }
        res[1] = right;
        for(int i=arr.length-1;i>=0;i--){
            if(min>arr[i]){
                min = arr[i];
            }else {
                left = i;         //记录索引位置
            }
        }

        res[0] = left;
        return res;
    }
}
