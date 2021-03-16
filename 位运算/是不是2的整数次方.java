package 位运算;

public class 是不是2的整数次方 {
    public static void main(String[] args) {
        System.out.println(is2次方(15));
    }


    /**
     * 即 判断二进制位中是不是只有一个1
     * @param n
     * @return
     */
    static public boolean is2次方(int n){
        //用一条语句判断一个整数是不是 2 的整数次方
        return (n&(n-1)) == 0;
    }
}
