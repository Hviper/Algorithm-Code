package 插入排序_Insert_sort;

import java.util.Arrays;


/**
 * 插入排序 --- 逆序对
 * 插入排序的时间复杂度与逆序对的数量成正比关系     【逆序对越多，插入排序的时间复杂度越高】
 * 最坏：O（n^2）      最好 O（n）
 * 空间复杂度 O（1）
 * 属于稳定排序
 *
 * 当逆序对的数量极少时，插入排序的效率非常高
 * 甚至速度 比 O（nlogn）级别的快速排序还高
 */
public class test {
    public static void main(String[] args) {
        int[] arr={100,12,54,8,65,9,35,4,80,1,-18,849,40,54};
//        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        test test = new test();
        test.insert(arr,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序递归法
     * @param arr
     * @param target
     * @return
     */
    public void insert(int[] arr,int k){
        if(k==0)return;
        insert(arr,k-1);       //参数（k-1）类似于for循环的代码
        int target = arr[k];
        while (k>0 && target>arr[k-1]){
            arr[k] = arr[k-1];
            k--;
        }
        arr[k] = target;
    }

    /**
     * 未改进版本 ---------> 不断交换  【从第二个数开始不断向前插入需要插入的值实现前面局部有序】
     * @param arr
     */
    public void Insert_sort(int[] arr){
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int temp = i;        //因为假如使用 i 进行后面代码执行的话后面会对 i 进行修改，因此每次循环需要使用temp来代替！！
            while ((temp-1)>=0 && arr[temp] > arr[temp - 1]){    //temp-1>=0 可以改为  temp > 0
                int cap = arr[temp];
                arr[temp] = arr[temp-1];
                arr[temp-1] = cap;
                temp --;
            }
        }
    }

    /**
     * 优化  ： 将交换（三行代码）的操作 ---> 改为数组的 “ 挪动 ”的一行代码   【减少交换次数的方式】
     * @param arr
     */
    public void Insert(int[] arr){
        for(int begin = 1;begin<arr.length;begin++){
            int temp = begin;
            int cap = arr[temp];        //先保存begin位置索引的值，待插入的值【默认第一个元素是有序的】
            while (temp>0 && cap>arr[temp-1]){        //这里是待插入的元素直接 和 其他元素比较，而不是前后元素比较
                arr[temp] = arr[temp-1];
                temp--;
            }
            arr[temp] = cap;
        }
    }

    public void InsertTest(int[] arr){
        for(int begin = 1;begin<arr.length;begin++){
            int temp = begin;
            int shop = arr[begin];
            while (temp-1>=0 && shop<arr[temp-1]){
                arr[temp] = arr[temp-1];
                temp--;
            }
            arr[temp] = shop;
        }
    }




//争对有序
    public int Binary_search(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(arr[mid] == target)return mid;
            else if(arr[mid]<target){
                left = mid+1;
            }else if(arr[mid]>target){
                right = mid-1;
            }else break;
        }
        return -1;
    }

    public int search(int[] arr,int target){
        int left = 0;
        int right = arr.length;
        while (left < right){             //保证一定有元素
            int mid = (left + right)>>1;
            if(target < arr[mid]){
                right = mid;
            }else if(target > arr[mid]){
                left = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
