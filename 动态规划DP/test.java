package 动态规划DP;


/**
 * 简称 ： DP
 * 是求解 "最优化" 问题的一种常用策略
 * 1） 暴力法（递归自顶向下，出现重叠子问题）
 * 2） 记忆化搜索（自顶向下）
 * 3） 递推（自底向上）
 */
public class test {
    public static void main(String[] args) {
        final test test = new test();
        System.out.println(test.coins2(41));
        int[] arr={1,5,20,25};
        System.out.println(test.coinChange(arr, 41));
    }





    public int coinChange(int[] arr,int target){
        if(arr==null || arr.length==0 || target<0)return -1;
        int[] targets = new int[target+1];
        targets[0] = 0;
        int i ,j;
        for(i=1;i<=target;i++){     // i块钱
            targets[i] = Integer.MAX_VALUE;        //每计算一次设置一下默认值【巧妙，反正都需要自底向上遍历计算对应】
            for(j=0;j<arr.length;j++){
                if(i>=arr[j] && targets[i-arr[j]] !=Integer.MAX_VALUE){
                    targets[i] = Math.min(targets[i-arr[j]]+1,targets[i]);
                }
            }
        }
        if(targets[target] == Integer.MAX_VALUE){
            targets[target] = -1;
        }
        return targets[target];
    }


    public int coins2(int n){
        if(n<1)return -1;
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if(i>=1){
                min = Math.min(dp[i-1],min);
            }if(i>=5){
                min = Math.min(dp[i-5],min);
            }if(i>=20){
                min = Math.min(dp[i-20],min);
            }if(i>=25){
                min = Math.min(dp[i-25],min);
            }
            dp[i] = min+1;
        }
        return dp[n];
    }


    //暴力自顶向下，缺点：出现了重叠子问题
    public int coins(int n){
        if(n<=0)return Integer.MAX_VALUE;
        //或者改为 n==0 return 0;  则当执行到（n-5）时，n取5时，为return 0，再加1所以也能return 1的要求
        if(n==25 || n== 1 || n== 5 || n ==20)return 1;
        int min1 = Math.min(coins(n-25),coins(n-20));
        int min2 = Math.min(coins(n-1),coins(n-5));
        return Math.min(min1,min2)+1;          //在已经是最优的策略基础上+1
    }

    /**
     * 记忆存储    ------------->  记忆化搜索
     * @param n
     * @return
     */
    public int coins1(int n){
        if(n <= 0) return -1;
        int[] dp = new int[n+1];
        //if(n==25 || n== 1 || n== 5 || n ==20)return 1;
        for(int value:dp){
            if(n>value){
                dp[value] = 1;
            }
        }
//        dp[25] = dp[1] = dp[5] = dp[20] = 1;
        return coins1(n,dp);
    }

    public int coins1(int n,int[] dp){
        if(n < 1)return Integer.MAX_VALUE;
        if(dp[n] == 0){
            int min1 = Math.min(coins1(n-25,dp),coins1(n-20,dp));
            int min2 = Math.min(coins1(n-1,dp),coins1(n-5,dp));
            dp[n] = Math.min(min1,min2)+1;     //在已经是最优的策略基础上+1
        }
        return dp[n];
    }
}
