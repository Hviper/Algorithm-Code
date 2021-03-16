package 双指针;

import java.util.Arrays;

public class 对撞指针 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        final 对撞指针 s = new 对撞指针();
        System.out.println(Arrays.toString(s.find_target(arr, 13)));
    }
    public int[] find_target(int[] arr,int target){
        int first = 0;
        int last = arr.length-1;
        int sum = 0;
        while (first < last){
            sum = arr[first]+arr[last];
            if( sum== target){
                break;
            }else if(sum < target){
                first++;
            }else {
                last--;
            }
        }
        return new int[]{first, last};
    }
}
