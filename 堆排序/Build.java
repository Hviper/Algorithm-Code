package 堆排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Build {
    public static void main(String[] args) {

        int[] arr={7,15,68,1,25,3,2,14,48,9,84,52,67,43,100,480,500};
        final Build s = new Build();
//        s.build(arr);
        s.sort(arr);
    }

    //[68, 25, 7, 14, 15, 3, 2, 1]     [1, 7, 2, 14, 9, 3, 43, 15, 48, 25, 84, 52, 67, 68, 100]
    public void build(int[] arr){
        int begin = arr.length / 2 - 1;
        for (int i = begin; i >= 0; i--) {
            int temp = i;
            while (i<=begin){     //先执行再判断的！！即这里是先进来
                int left = i*2+1;
                int right = i*2+2;
                if(right<arr.length && arr[left] < arr[right]){
                    left = right;
                }
                if(arr[i] > arr[left]){break;}
                else {
                    swap(arr,i,left);
                    i = left;
                }
            }
            i = temp;
        }

    }
    public void swap(int[] arr,int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sort(int[] arr){
        build(arr);
        for (int i = arr.length-1; i > 0; i--) {
            swap(arr,i,0);
            siftDown(0,arr,i);    //交换以后尾部需要减少 1 ，【 i+1-1 = i 】
        }
        System.out.println(Arrays.toString(arr));

    }


    public void siftDown(int index,int[] arr,int size){
        if(arr.length == 0 || size<0)return;
        int target = size/2-1;
        System.out.println("当前target为"+target);
        while (index<=target){        //能进来说明有子孩子，但不一定有右孩子
            int left = index*2+1;
            int right = index*2+2;
            if(right<=size-1 && arr[right]>arr[left]){
                left = right;
            }
            if(arr[index] >= arr[left]){
                break;
            }else {
                swap(arr,index,left);
                index = left;
            }
        }
    }
}
