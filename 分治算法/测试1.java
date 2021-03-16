package 分治算法;

public class 测试1 {
    public static void main(String[] args) {
        final 测试1 s = new 测试1();
        int[] arr={-2,-1,-3,4,-1,2,1,-5,4};
        System.out.println(s.find_Min(arr));
    }



    public int find_Min(int[] arr){
        if(arr==null || arr.length ==0){return -1;}
        return find_Min(0,arr.length,arr);
    }

    private int find_Min(int left,int right,int[] arr) {
        if(right-left<2)return arr[left];       //一个数的情况  【分而治之的临界点！最多分为一个元素的情况】
        int mid = (left+right)>>1;
        int left_min = find_Min(left,mid,arr);
        int right_min = find_Min(mid,right,arr);

        //两个数及其两个数以上操作，开始涉及mid。
        int l=Integer.MIN_VALUE;
        int l_sum = 0;
        for(int i=mid-1;i>=left;i--){
            l_sum += arr[i];
            l = Math.max(l,l_sum);
        }


        //分治的本质：把他看成两部分，直接看成两个数，由一个数就一个情况，两个数又是另一种情况
        //【即核心：两个数开始就涉及下方代码！！即若两个数相加为比一个数大即返回两个数的和，反之返回一个数中最大的那个数】
        int r=Integer.MIN_VALUE;
        int r_sum = 0;
        for(int i=mid;i<right;i++){
            r_sum += arr[i];
            r = Math.max(r,r_sum);
        }

        return Math.max(Math.max(left_min,right_min),r+l);
    }
}
