package 冒泡排序;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr={100,12,54,8,65,9,35,4,80,1,-18,849,40,54};
        test test = new test();
        test.BubbleSort(arr);
//        System.out.println(Arrays.toString(test.text(arr)));
    }
    public int[] text(int[] arr){
        int len = arr.length;
        if(len<1)return null;
        for (int i = len; i > 1; i--) {    //三个元素循环两次，两个元素循环一次，（n-1）次
            int flag= 1;
            for(int j=1;j<i;j++){            //通过缩短查找路径的方式来减少查询的时间复杂度
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    flag = j;
                }
            }
            i = flag+1;     //因为每次for循环都会进行一次i--
        }
        return arr;
    }

    public void BubbleSort(int[] arr){
        for (int i = arr.length-1; i > 0; i--) {
            int sort_end = 1;          // 1 是为一上来就完全有序正准备的
            for(int j=1;j<=i;j++){
                if(arr[j]>arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    sort_end = j;
                }
            }
            i = sort_end ;
        }
        System.out.println(Arrays.toString(arr));
    }
}
