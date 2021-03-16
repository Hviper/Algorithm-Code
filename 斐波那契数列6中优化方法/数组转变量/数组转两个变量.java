package 斐波那契数列6中优化方法.数组转变量;


//最终优化结果：一：没有开辟对空间，即空间复杂度为 O（1），二：时间复杂度为 O（n）
public class 数组转两个变量 {
    public static void main(String[] args) {
        数组转两个变量 s = new 数组转两个变量();
        int sort = s.sort(6);
        System.out.println(sort);
    }
    public int sort(int n){
        if(n==1 || n==2){
            return 1;
        }
        int i=1;
        int j=1;
        for(int k=3;k<=n;k++){
            i=i+j;
            j=i-j;
        }
        return i;
    }
}
