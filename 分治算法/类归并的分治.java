package 分治算法;

public class 类归并的分治 {
    public static void main(String[] args) {
        final 类归并的分治 s = new 类归并的分治();
        int[] arr={-2,-1,-3,4,-1,2,1,-5,4};
        System.out.println(s.maxSubarray(arr));
    }


    /**
     * 左闭右开
     * @param arr
     */
    public int maxSubarray(int[] arr){
        if(arr==null || arr.length==0)return -1;
        return maxSubarray(0,arr.length,arr);
    }


    /**
     *该函数的功能 : 是求解 【begin，end） 中区间最大的连续子序列和
     * @param begin
     * @param end
     * @param arr
     */

    private int maxSubarray(int begin,int end,int[] arr) {
        if(end-begin<2)return arr[begin];         //只有一个元素。如 【6，7）区间，只有一个元素 6
        int mid = (end+begin)>>1;

        //递归求解
        int left_max = maxSubarray(begin,mid,arr);           //求解出【begin，mid）区间最大子序列和
        int right_max = maxSubarray(mid,end,arr);
        int max = Math.max(left_max,right_max);

        //求中间中最大的值【每次循环中加一次比较一次最大的值】
        int left_Max = Integer.MIN_VALUE;
        int left_Sum = 0;
        for(int i = mid-1;i>=begin;i--){
            left_Sum += arr[i];
            left_Max = Math.max(left_Max,left_Sum);         //每加一次确定一下最大值
        }
        int right_Max = Integer.MIN_VALUE;
        int right_Sum = 0;
        for(int i =mid;i<end;i++){
            right_Sum += arr[i];
            right_Max = Math.max(right_Max,right_Sum);
        }

        return Math.max(max,right_Max+left_Max);
    }
}
