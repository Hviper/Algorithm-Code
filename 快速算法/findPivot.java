package 快速算法;

import java.util.Arrays;


public class findPivot {
    public static void main(String[] args) {
        int[] arr = {8,1,2,3,4,5,6,7,9,10,11,12,13,0};
        find_Pivot(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 让第一个元素插到合适的位置   【 <----------快排的主要思想--------> 】
     * @param arr
     */
    static public void find_Pivot(int[] arr){
        if(arr==null || arr.length==0)return;
        int begin = 0;                //让第一个元素插到合适的位置
        int temp = arr[begin];      //begin位置变成垃圾数据
        int end = arr.length-1;
        /**
         * 来回交替的方法实现
         */
        while (begin<end){
            while (begin<end && arr[end]>temp){
                end--;
            }
            if(arr[end]<=temp){
                arr[begin] = arr[end];   //end位置变成垃圾数据
            }

            while (begin<end && arr[begin]<temp){
                begin++;
            }
            if(arr[begin]>=temp){
                arr[end] = arr[begin];       //begin位置变成垃圾数据
            }
        }
        //能来到这里说明begin == end
        arr[begin] = temp;

    }
}
