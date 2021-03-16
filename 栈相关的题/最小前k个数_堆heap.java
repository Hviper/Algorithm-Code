package 栈相关的题;

import java.util.Arrays;

public class 最小前k个数_堆heap {
    public static void main(String[] args) {
        final 最小前k个数_堆heap test = new 最小前k个数_堆heap();
        int[] arr = {1,3,5,7,2,4,6,8};
        System.out.println(Arrays.toString(test.smallestK(arr, 4)));
    }
    public int[] smallestK(int[] arr, int k) {
        if(arr==null || arr.length==0){
            return new int[0];
        }
        if(k==0)return new int[0];
        int end;
        for(end=arr.length;end>=arr.length-k;end--){
            findTarget(arr,end);
            swap(0,end-1,arr);
        }
        int[] res = new int[k];
        int count = 0;
        for(int i=arr.length-1;i>end;i--){
            res[count] = arr[i];
            count++;
        }
        return res;
    }
    public void findTarget(int[] arr,int end){
        int begin = (end>>1)-1;
        while(begin>=0){
            int left = begin*2+1;
            int right = left+1;
            if(right<end){
                left = arr[left]>arr[right]?right:left;
            }
            if(arr[begin]>arr[left]){
                swap(begin,left,arr);
            }
            begin--;
        }
    }
    public void swap(int a,int b,int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
