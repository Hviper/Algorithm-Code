package 小码哥每周一道算法题.动态规划;

public class 机器人找路 {
    public static void main(String[] args) {
        final 机器人找路 s = new 机器人找路();
        System.out.println("到达第五行第五列的方式共有："+s.doubleSort(5, 5)+" 种");
    }


    //二维机器人找路
    public int doubleSort(int row,int col){
        int[][] dp = new int[row][col];
        //初始化二维边缘情况
        for(int i=1;i<col;i++){
            dp[0][i] = 1;
        }
        for(int i=1;i<row;i++){
            dp[i][0] = 1;
        }
        //求解除二维边缘以外的坐标
        for(int r=1;r<row;r++){
            for(int l=1;l<col;l++){
                dp[r][l] = dp[r-1][l]+dp[r][l-1];        //状态转移方程 【无后效性】
            }
        }
        return dp[row-1][col-1];
    }
}
