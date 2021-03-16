package 斐波那契数列6中优化方法.利用数组优化;

public class 阶层数组存储优化 {
    public static void main(String[] args) {
        阶层数组存储优化 s = new 阶层数组存储优化();
        int jc = s.Jc(5);
        System.out.println(jc);
    }

    public int Jc(int n){
        if(n==1){
            return 1;
        }
        int[] arr=new int[n+1];
        arr[1]=1;               //递归出口
        return Jc(n,arr);
    }
    public int Jc(int n,int[] arr){
        if(arr[n]==0){
            arr[n]=Jc(n-1)*n;
        }
        return arr[n];
    }
}
