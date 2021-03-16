package 动态规划DP;

public class 最佳买股票 {
    public static void main(String[] args) {
        final 最佳买股票 s = new 最佳买股票();
        int[] arr = {7,6,4,3,1,9};
        System.out.println(s.maxProfit(arr));
    }
    //暴力法
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int maxPro=0;
        for(int i=0;i<length;i++){
            int max = 0;
            for(int j=i+1;j<length;j++){
                max = Math.max(max,prices[j]-prices[i]);
            }
            maxPro = Math.max(maxPro,max);
        }
        return maxPro;
    }
    
}
