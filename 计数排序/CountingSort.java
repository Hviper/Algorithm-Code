package 计数排序;

import java.util.Arrays;

import static 双指针.去除数组中的target.swap;


/**
 * 计数排序的核心思想：统计每个整数在序列中出现的次数，进而推到出每个整数在有序序列中的索引
 * 缺点：
 *      不能对含有负整数数组进行排序
 *      只能对正整数进行排序  【因为需要创建最大值作为数组的最大索引】
 *      极其浪费内存空间
 *
 * 【有点类似最原始的 “hash” 值的索引】达到 n 时间复杂度的排序   【实现 O(1) 的查找】
 */
public class CountingSort {
    public static void main(String[] args) {
        final CountingSort s = new CountingSort();
        int[] arr = new int[]{12,5,4,3,11,2,1,20};
        System.out.println(Arrays.toString(s.Sort(arr)));
        System.out.println(s.find_MaxValue(arr));
    }


    public int[] Sort(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i:arr){
            max = Math.max(max,i);
        }
        //确定最大值后开始建立索引
        int[] nums = new int[max+1];
        for (int value : arr) {
            nums[value] += 1;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (num != 0) {
                arr[index] = i;
                index++;
                num--;
            }
        }
        return arr;
    }


    //利用堆结构进行找最值 logn【缺点：会改变原数组的结构】
    public int find_MaxValue(int[] arr){
        int begin = (arr.length>>1)-1;
        while (begin>=0) {
            int left = (begin << 1) + 1;
            int right = left + 1;
            if (right < arr.length) {
                left = arr[left] > arr[right] ? left : right;
            }
            if (arr[begin] < arr[left]) {
                swap(begin, left, arr);
            }
            begin--;
        }
        return arr[0];
    }
}
