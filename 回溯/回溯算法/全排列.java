package 回溯.回溯算法;

import java.util.HashMap;
import java.util.Stack;

public class 全排列 {
    public static void main(String[] args) {
        final 全排列 s = new 全排列();
        int[] arr={1,2,3};
        s.sort(arr);
    }
    Stack<Integer> stack = new Stack<>();
    public void sort(int[] arr){
        if(arr==null || arr.length == 0 )return;
        back(arr);
    }
    HashMap<Integer,Integer> map = new HashMap<>();
    private void back(int[] arr) {
        if(stack.size() == arr.length){
            System.out.println(stack.toString());
            return;
        }
        for (int value : arr) {
            if (!map.containsKey(value)) {
                stack.push(value);
                map.put(value, value);
            } else continue;              //至关重要！！ 起到选择另一个不重复的元素的作用
            back(arr);
            stack.pop();
            map.remove(value);
        }
    }

}
