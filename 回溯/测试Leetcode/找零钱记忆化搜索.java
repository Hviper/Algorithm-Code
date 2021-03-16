package 回溯.测试Leetcode;

public class 找零钱记忆化搜索 {
    public static void main(String[] args) {
        final 找零钱记忆化搜索 s = new 找零钱记忆化搜索();
        int[] arr = {1,2,5,6,1,12};
        System.out.println(s.coinChange(arr, 18));
    }
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        memo = new int[amount];

        return findWay(coins,amount);
    }
    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public int findWay(int[] coins,int amount){
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if(memo[amount-1] != 0){
            return memo[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = findWay(coins, amount - coin);
            if (res >= 0 && res < min) {
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount-1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount-1];
    }


}
