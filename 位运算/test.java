package 位运算;

import java.util.Stack;

public class test {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        final test s = new test();
        final Stack<Integer> stack = new Stack<>();
        stack.push(1);
        System.out.println(stack.get(0));
//        System.out.println(s.maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        int[] res = new int[prices.length+1];
        System.arraycopy(prices, 0, res, 0, prices.length);
        Stack<Integer> stack = new Stack<>();
        res[prices.length] = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int re : res) {
            while (!stack.isEmpty() && stack.peek() > re) {
                maxValue = Math.max(maxValue, stack.peek() - stack.get(0));
                stack.pop();
            }
            stack.push(re);
        }
        return maxValue==Integer.MIN_VALUE?0:maxValue;
    }


}
