package 常规题;

public class 字符串翻转 {
    public static void main(String[] args) {

        System.out.println(reverse("abcdefg", 6));
    }


    /**
     * 字符串翻转代码     (递归法)
     * @param src
     * @param end
     * @return
     */
    static public String reverse(String src,int end){
        if(end == 0)return ""+src.charAt(0);
        return src.charAt(end)+reverse(src,end-1);       //从递归去的时候进行筛选结果
    }


}
