package 计数排序;

import java.util.Arrays;

public class first {
    public static void main(String[] args) {
        int[] arr = {12,5,3,3,4,11,2,13,5,9};
        final first first = new first();
        first.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 原始计数排序：可以实现 O（n）的时间复杂度
     * @param arr
     */
    public void sort(int[] arr){
        int[] list = new int[21];
        for (int value : arr) {
            list[value] += 1;
        }
        int count = 0;
        for(int i=0;i<list.length;i++){
            while (list[i] != 0){
                arr[count++] = i;           //下标作为原arr中的数组中的value值
                list[i] -=1;
            }
        }
    }
}
