package 双指针;

import java.util.Arrays;

public class 对012排序 {
    public static void main(String[] args) {
        int[] arr = {2,0,1};
        final 对012排序 s = new 对012排序();
        s.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void sort(int[] arr){
        if(arr==null || arr.length==0)return;
        int point1 = 0;
        int point2 = arr.length-1;
        int cur = 0;
        while (point2>=cur){
            if(arr[cur] == 2){
                swap(cur,point2--,arr);
            }
            else if(arr[cur] == 0){
                swap(point1++,cur++,arr);
            }else cur++;
        }
    }
    public void swap(int a,int b,int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
