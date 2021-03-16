package 小码哥每周一道算法题.动态规划;

public class 打家劫舍 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        final 打家劫舍 s = new 打家劫舍();
        System.out.println(s.rob(arr));
    }
    public int rob(int[] arr){
        int[] shop = new int[arr.length+1];
        return rob(arr,0,shop);
    }

    private int rob(int[] arr, int i,int[] shop) {
        if(i==arr.length-1){
            return arr[arr.length-1];
        }
        if(i==arr.length-2){
            return Math.max(arr[arr.length-1],arr[arr.length-2]);
        }
        if(shop[i] == 0){
            shop[i] = Math.max(rob(arr,i+1,shop),rob(arr,i+2,shop)+arr[i]);
        }
        return shop[i];

    }

}
