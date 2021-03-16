package 双指针;

import java.util.Arrays;

public class 三数之和 {
    public static void main(String[] args) {
        final 三数之和 s = new 三数之和();
        int[] arr = {-1,0,1,2,-1,-4};
        s.sum(arr,0);
    }

    public void sum(int[] arr,int target){
        if(arr == null || arr.length < 3)return;
        Arrays.sort(arr);
        System.out.print(Arrays.toString(arr)+"\n");
        int LastIndex = arr.length-1;
        for (int i = 0; i < arr.length-2; i++) {
            if(i>0 && arr[i] == arr[i-1])continue;
            int surplus = target-arr[i];
            int end = LastIndex;
            int begin = i+1;
            while (begin<end){
                int sum = arr[begin]+arr[end];
                if(sum == surplus){
                    System.out.print(Arrays.toString(new int[]{i, begin, end}));
                    begin++;
                    end--;
                }else if(sum<surplus){
                    begin++;
                }else {
                    end--;
                }
            }
        }
    }
}
