package 队列Queue相关的题;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口 {
    public static void main(String[] args) {
        final 滑动窗口 s = new 滑动窗口();
        int[] arr = {1,3,1,2,0,5};
        System.out.println(Arrays.toString(s.maxSlidingWindow2(arr, 3)));

    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums==null || nums.length<1)return new int[0];
        int[] res = new int[nums.length-k+1];
        int max = 0;
        for(int j=1;j<k;j++){
            if(nums[max]<nums[j]){
                max = j;
            }
        }
        res[0] = nums[max];
        for(int i=1;i<res.length;i++){
            if(max<i){
                max = i;
                for(int begin =i+1 ;begin<i+k;begin++){
                    if(nums[begin]>max){
                        max = begin;
                    }
                }
            }
            int r = i+k-1;
            if(nums[max]<nums[r]){
                max = r;
            }
            res[i] = nums[max];
        }

        return res;
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length<1)return new int[0];
        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.removeLast();
            }
            deque.offerLast(i);
            int li = i-k+1;
            if(li<0)continue;
            if(deque.peekFirst()<li){
                deque.pollFirst();
            }
            res[li] = nums[deque.peekFirst()];
        }

        return res;
    }
}
