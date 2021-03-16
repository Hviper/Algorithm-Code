package 位运算;

/**
 * 异或:消除相同的一对 {消消乐}
 */
public class 异或运算消除相同 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[5] = 10;            //数组中只有一个不同,其他都是 "成对存在" 一样的
        final 异或运算消除相同 s = new 异或运算消除相同();
        System.out.println(s.solve(arr));
        System.out.println(5^2^2^5);
    }
    public int solve(int[] arr){
        int target = 0;            //0 异或任何数都是任何数本身
        for (int value : arr) {
            target = target ^ value;
        }
        System.out.println(target);
        return target;
    }
}
