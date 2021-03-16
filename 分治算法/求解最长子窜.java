package 分治算法;

public class 求解最长子窜 {
    public static void main(String[] args) {
        int[] arr={-2,-1,-3,4,-1,2,1,-5,4};
        final 求解最长子窜 s = new 求解最长子窜();
        System.out.println(s.sum_Max(arr));
    }
    public int sum_Max(int[] arr){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int value : arr) {
            sum += value;
            max = Math.max(sum, max);               //求最长子窜，每加一次【每遍历一次】都要比较max，即记录最大值，也可以说是记录上次最大
        }
        return max;
    }
}
