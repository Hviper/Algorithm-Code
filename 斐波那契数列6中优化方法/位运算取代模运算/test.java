package 斐波那契数列6中优化方法.位运算取代模运算;

//fib 优化4---->位运算取代模运算
//对于奇数偶数的判断，常用的是%2，假如为0则为偶数，假如为1则为奇数  【模2为0或1，模3为0或1或2，以此类推……】

/*
对于 3 0b011 末尾为1为奇数
    4 0b100 末尾为0为偶数
    5 0b101

    与运算：两个都为1结果才为1，一个为0则为0
* */

public class test {
    public static void main(String[] args) {
        System.out.println(14&1);
    }
    public int Fb(int n){
        if(n==1 || n==2){
            return 1;
        }
        int[] arr={1,1};
        for(int k=3;k<=n;k++){
            arr[k & 1]=arr[(k-1) & 1]+arr[(k-2) & 1];
        }
        return arr[n & 1];
    }
}
