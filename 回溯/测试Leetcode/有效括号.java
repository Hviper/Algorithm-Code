package 回溯.测试Leetcode;

import java.util.Stack;

public class 有效括号 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        boolean[] flag = new boolean[arr.length];
        final 有效括号 s = new 有效括号();
        s.back(arr,flag);
        int[][] p = new int[][]{{},{1,2},{}};
        System.out.println(p[1].length);
    }

    Stack<Integer> stack = new Stack<>();

    public void back(int[] arr,boolean[] flag){
        if(stack.size()==arr.length){
            System.out.println(stack.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            if (!flag[i]){
                stack.push(value);
                flag[i] = true;
                back(arr, flag);
                stack.pop();
                flag[i] = false;
            }

        }
    }
}
