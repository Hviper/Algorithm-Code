package 分治算法;

public class 归并分治法求最大连续子序列 {
    public static void main(String[] args) {
        final 归并分治法求最大连续子序列 s = new 归并分治法求最大连续子序列();
        int[] arr={-2,-1,-3,4,-1,2,1,-5,4};
        System.out.println(s.sort(arr));
    }
    public int sort(int[] arr){
        if(arr==null || arr.length == 0)return -1;
        return back(0,arr.length,arr);
    }
    public int back(int begin,int end,int[] arr){
        if(end-begin<2)return arr[begin];
        int mid = (begin+end)>>1;
        int left = back(begin,mid,arr);
        int right = back(mid,end,arr);
        int max = Math.max(left,right);

        //处理中间序列的代码逻辑
        int left_sum = 0;
        int left_max = Integer.MIN_VALUE;
        for(int i=mid-1;i>=begin;i--){
            left_sum += arr[i];
            left_max = Math.max(left_max,left_sum);
        }

        int right_sum = 0;
        int right_max = Integer.MIN_VALUE;
        for(int i=mid;i<end;i++){
            right_sum += arr[i];
            right_max = Math.max(right_max,right_sum);
        }
        return Math.max((right_max+left_max), max);
    }
}
