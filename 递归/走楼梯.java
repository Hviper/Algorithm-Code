package 递归;

public class 走楼梯 {
    public static void main(String[] args) {
        final 走楼梯 s = new 走楼梯();
//        System.out.println(s.creep2(10));
//        System.out.println(s.creep(10));
        int[] arr = new int[10];
        arr[5] = 10;
        int target = arr[0];
        for (int i = 1; i < arr.length; i++) {
            target = target^arr[i];
        }
        System.out.println(target);
    }

    //递归法
    public int creep(int n){
        if(n<0)return 0;
        if(n==0 || n==1)return 1;
        return creep(n-1)+creep(n-2)+creep(n-3);
    }
    //动态规划递推式分析法
    public int creep2(int n){
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
        }
        return arr[n];
    }
}
