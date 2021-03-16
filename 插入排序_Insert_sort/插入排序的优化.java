package 插入排序_Insert_sort;

public class 插入排序的优化 {
    public static void main(String[] args) {
        final 插入排序的优化 s = new 插入排序的优化();
        int[] arr={1,2,3,4,4,5,6,7,8,9,10};
        System.out.println(s.search(arr, 4));
    }


    public void Insert(int[] arr){
        if(arr == null || arr.length==0)return;
        for(int begin=1;begin<arr.length;begin++){
            int search = search(arr, arr[begin]);      //减少比较次数的方式，数组后退覆盖的步骤还是需要操作

        }
    }




    /**
     * 二分搜索优化：要求二分搜索返回的插入位置：第一个大于 v 的元素位置
     *                  “二分循环区间不变原则”
     * @return
     */
    public int search(int[] arr,int target){
        int begin = 0;
        int end = arr.length;
        while (begin < end){        //while循环能退出说明 begin == end
            int mid = (begin+end)>>1;
            if(arr[mid]>target){
                end = mid;              //“二分循环区间不变原则”
            }else {       //需要插入的元素：target大于 “等于” arr[mid]也需要往后查找，因为直到找到第一个大于 v 的元素位置
                begin = mid+1;          //“二分循环区间不变原则”
            }
        }
        //while 循环最终退出的结果就是我们需要找的值的位置索引
        return begin;             //左闭右开的区间    --->退出循环最终的结果为 ： begin == end  恰好就是我们需要插入的位置
    }

}
