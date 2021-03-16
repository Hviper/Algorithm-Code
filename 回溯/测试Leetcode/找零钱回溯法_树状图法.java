package 回溯.测试Leetcode;


/**
 *    “非引用” 类型的回溯题目！！！        【与小码哥说的回溯算法中的八皇后问题类似】
 */
public class 找零钱回溯法_树状图法 {
    public static void main(String[] args) {
        final 找零钱回溯法_树状图法 s = new 找零钱回溯法_树状图法();
        int[] arr = {1,2,5,6};
        System.out.println("\n"+s.coinChange(arr, 18));
    }

    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        findWay(coins,amount,0);

        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }
    int i =1;

    //画树状图的方法
    public void findWay(int[] coins,int amount,int count){
        if(amount < 0){
            return;
        }
        if(amount == 0){
            System.out.println("第"+(i++)+"条路线的硬币数："+count);
            res = Math.min(res,count);
        }
        //递归函数具有天然的回溯，一个函数结束完自动回到count之前的状态值，因为count为非引用类型变量
        //引用类型的数据不同之处是每一个函数都会修改对应的值。因此需要在函数执行完成后还需要手动回溯pop()
        for (int coin : coins) {
            findWay(coins, amount-coin , count + 1);
        }
    }

}
