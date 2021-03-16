package 位运算;

public class 将整数的奇偶位互换 {
    public static void main(String[] args) {
        System.out.println(change(9));
    }
    static public int change(int n){
        int a = n & 0xaaaaaaaa;       //保留奇数位     0位是偶数位
        int b = n & 0x55555555;         //保留偶数位
        return (a>>1)^(b<<1);         // 异或；连接起来
    }
}
