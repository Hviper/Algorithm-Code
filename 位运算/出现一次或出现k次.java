package 位运算;

/**
 * 理论:2个相同的二进制数做不进位加法,结果为 0
 * 10个相同的10进制数做不进位加法,结果为 0
 * k 个相同的 k 进制数做不进位加法,结果为 0
 *
 * JDK中提供进制转换的方法:  String string = Integer.toString(10, 3);    {第一个参数填写原变量,第二个参数填写进制名称}  radix:进制
 */
public class 出现一次或出现k次 {
    public static void main(String[] args) {
        final String string = Integer.toString(10, 3);
        System.out.println(string);
        final 出现一次或出现k次 s = new 出现一次或出现k次();

    }

}
