package 回溯.回溯算法;

import java.util.Stack;

public class text {
    public static void main(String[] args) {
        text text = new text();
        int[] arr={1,2,3,4,5,6,7,8,9};
        text.back(arr,2);
    }
    Stack<Integer> stack;
    public void back(int[] arr,int sum){
        stack = new Stack<Integer>();
        tracking(arr,sum,0);
    }
    public void tracking(int[] arr,int sum,int begin){
        if(stack.size() == sum){         //递归深度【二叉树的层数】
            System.out.println(stack.toString());
            return;
        }
        for (int i = begin; i < arr.length-(sum-stack.size())+1; i++) {
            int value = arr[i];
            stack.push(value);
            tracking(arr, sum, i);
            stack.pop();           //本身也会pop()出去，不仅pop（）别的，因为自己本身也是一个循环【森林树】
        }
    }
}
