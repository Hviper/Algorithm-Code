package 快速算法;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr={5,1,1,2,0,0};

        test test = new test();
        test.Quick_sort(arr);
        System.out.println(Arrays.toString(arr));

    }


    /**
     * 快速排序的本质：逐渐将每一个元素都转换成轴点元素
     * @param arr
     */
    public void Quick_sort(int[] arr){
        Quick_sort(0,arr.length-1,arr);
    }


    //【左闭右闭】
    private void Quick_sort(int begin,int end,int[] arr) {
        if(begin>=end)return;
        int L = begin;
        int R = end;
        int pivot = arr[begin];         //begin位置变成垃圾位置
        while (begin < end){
            while (begin<end && arr[end] >= pivot){
                end--;
            }
            if(begin < end){
                arr[begin] = arr[end];      //end位置变成垃圾位置
            }
            while (begin < end && arr[begin] <= pivot){
                begin++;
            }
            if(begin < end){
                arr[end] = arr[begin];      //begin位置变成垃圾位置
            }
            if(begin >= end){
                arr[begin] = pivot;
            }
        }
        Quick_sort(L,begin-1,arr);
        Quick_sort(begin+1,R,arr);
    }


    public void sort(int[] arr,int L,int R) {
        if(L>=R){
            return;
        }
        int left = L;
        int right = R;
        int temp = arr[left];
        while (left < right) {

            while (left<right && temp >= arr[right]) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }
            while (left < right &&  temp <= arr[left]) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
            if (left >= right) {    //完全有序等判断
                arr[left] = temp;
            }
        }
        //[L,right-1]    [right+1,R]
        sort(arr, L, right - 1);
        sort(arr, right + 1,R);
    }
}
