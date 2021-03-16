package 斐波那契数列6中优化方法.利用数组优化;

//优化一
//数组缓存法【空间换时间】---------->使得时间复杂度为O(n)，之前时间复杂度为n的平方 O(n^2)
public class By_Array {
    public static void main(String[] args) {
        By_Array s = new By_Array();
        int answer=s.Array_optimization(6);
        System.out.println(answer);

    }
    public int Array_optimization(int n){
        if(n>0){
            if(n==1 || n==2){
                return 1;
            }
            int[] arr=new int[n+1];     //初始化数组
            arr[1]=1;
            arr[2]=1;       //arr[1]=1和arr[2]=1属于递归出口
            return FbnQ(n,arr);
        }
        return 0;
    }
    private int FbnQ(int n,int[] arr){

        //如果没有该n项的初始值，则存起来，否则直接返回数组里的数字即可，这样就使得每一个n只计算一次【添加一个缓存】
        if(arr[n]==0){
            arr[n]=FbnQ(n-1,arr)+FbnQ(n-2,arr);
        }
        return arr[n];
    }



}
