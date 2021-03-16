package 小码哥每周一道算法题.递归;

public class test {
    public static void main(String[] args) {
        final test s = new test();
        System.out.println(s.numWays(5));
    }
    public int numWays(int n) {
        if(n==1)return 1;
        if(n==2){
            return 2;
        }
        return numWays(n-1)+numWays(n-2);
    }
}
