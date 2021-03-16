package 小码哥每周一道算法题.动态规划;

public class 最大礼物价值 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,2,3,4},{2,3,4,5},{48,89,4,6}
        };

        //表示行
        System.out.println(arr.length);
        //表示列
        System.out.println(arr[0].length);
    }
    public int maxValue(int[][] grid) {
        int row = grid[0].length;
        int col = grid.length;
        return 0;
    }
}
