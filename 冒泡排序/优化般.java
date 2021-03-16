package 冒泡排序;

import java.util.Arrays;

public class 优化般 {
    public static void main(String[] args) {
        int[] arr={100,12,54,8,65,9,35,4,80,1,-18,849,40,54};
        优化般 s = new 优化般();
        int[] sort = s.sort2(arr);
        boolean flag=true;
        for (int i = 1; i < sort.length; i++) {
            if(sort[i]<sort[i-1]){
                System.out.println("无序");
                System.out.println(Arrays.toString(sort));
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println("有序");
            System.out.println(Arrays.toString(sort));
        }

    }

    /**
     * 如果序列尾部已经局部有序，可以记录最后一次交换位置，减少比较次数
     * @param arr 数组
     * @return 排序后的数组
     */
    public int[] sort1(int[] arr){
        for (int end = arr.length; end >1 ; end--) {
            //sort_end是为完全有序做准备的！！
            int sort_end = 1;
            for (int begin = 1; begin < end; begin++) {
                /**
                 * 每一趟扫描的时候已经可以确定最后一次交换的位置，，即之后的元素都是有序的
                 */
                if(arr[begin-1]>arr[begin]){
                    int temp=arr[begin-1];
                    arr[begin-1]=arr[begin];
                    arr[begin]=temp;
                    sort_end=begin;
                }
            }
            end=sort_end+1;
        }
        return arr;
    }


    public int[] sort2(int[] arr){
        for (int end = arr.length-1; end > 0; end--) {
            int index=1;
            for (int begin = 1; begin <= end; begin++) {
                if(arr[begin-1]>arr[begin]){
                    int temp=arr[begin];
                    arr[begin]=arr[begin-1];
                    arr[begin-1]=temp;
                    index=begin;
                }
            }
            end=index;
        }
        return arr;
    }


}
