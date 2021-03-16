package 选择排序;

import java.util.Arrays;

public class 选择sort {
    public static void main(String[] args) {
        选择sort s = new 选择sort();
        int[] arr={100,12,54,8,65,9,35,4,80,1,-18,849,40,54};
        s.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 执行流程：
     *      1.从序列中找到最大的那个元素，然后与最末尾的元素交换位置
     * 执行完一轮以后，最末尾的那个元素就是最大的元素
     *      2.忽略（1）中找到的最大元素，重复执行步骤（1）
     * @param arr
     * @return
     */
    public void sort(int[] arr){

        /**
         * 由于每次循环都是在找最大值，而且是一个数和其他数比较找到最大值的方式，理论上无法正常优化
         * 但是由于是找最大值！！！----------------->   “ 堆 ”  log(n)的时间复杂度
         */
        int len = arr.length;
         for(int end = len-1;end > 0;end--){
             int max = 0;
             for(int i = 1;i<=end;i++){
                if(arr[max]<=arr[i]){
                    max = i;
                }
             }
             //理论上比冒泡交换的次数少！！！，冒泡的交换次数最大可以达到交换 n 的平方，而选择排序只是最大 n 的交换次数
             int temp = arr[end];
             arr[end] = arr[max];
             arr[max] = temp;
         }
    }

}
