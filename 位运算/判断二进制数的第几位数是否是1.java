package 位运算;

/**
 * 视频链接：https://www.bilibili.com/video/BV1e7411T7FV?p=5
 */
public class 判断二进制数的第几位数是否是1 {
    public static void main(String[] args) {
        System.out.println(count_Zero(15));
        System.out.println(isZero(15));
    }
    static public int isZero(int n){
        int count=0;
        for(int i=0;i<32;i++){    //int类型数字为32位，依次暴力循环即可
            if((n&(1<<i)) == 1<<i){                //用 1 进行探测,从0位开始用 "&" 探测到31位
                count++;
            }
        }
        return count;
    }
    static public int count_Zero(int n){
        int count = 0;
        while (n!=0){
            n = n&(n-1);          //不断消掉最低位的 " 1 "
            count++;
        }
        return count;
    }
}
