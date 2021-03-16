package 归并排序_冯诺依曼;

import java.util.ArrayList;
import java.util.Arrays;

public class 实现 {
    public static void main(String[] args) {
        int[] arr={15,4,88,62,97,41,99,854,100,10};
        final 实现 s = new 实现();
        s.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    int[] list;
    public void sort(int[] arr){
        list = new int[arr.length>>1];
        sort(0,arr.length,arr);
    }
    public void sort(int left,int right,int[] arr){
        if(right-left<2)return;
        int mid = (left+right)>>1;
        sort(left,mid,arr);
        sort(mid,right,arr);
        merge(left,mid,right,arr);
    }

    private void merge(int begin,int mid,int end,int[] arr) {
        int li=0,len=mid-begin;
        int ri=mid,ai=begin;
        for(int i=0;i<len;i++){
            list[i] = arr[begin+i];
        }
        while (li < len){
            if(ri<end && arr[ri]>list[li]){
                arr[ai++] = arr[ri++];
            }else {
                arr[ai++] = list[li++];
            }
        }
    }
}
