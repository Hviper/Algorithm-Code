package 小码哥每周一道算法题.排序;

import java.util.Arrays;

public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = {15,2,36,99,14,-5,-12,3,45,-100,92,600};
        final 堆排序 s = new 堆排序();
        s.Sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void Sort(int[] arr){
        for(int begin =arr.length;begin>0;begin--){
            heapSort(arr,begin);
            swap(0,begin-1,arr);
        }
    }
    private void heapSort(int[] arr,int end){
        int begin = (end/2)-1;
        while(begin>=0){
            int left = begin*2+1;
            int right = begin*2+2;
            if(right<=end-1){
                left = arr[left]>arr[right]?left:right;
            }
            if(arr[begin]<arr[left]){
                swap(begin,left,arr);
            }
            begin--;
        }
    }
    private void swap(int a,int b,int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
