package 回溯.测试Leetcode;

public class text {
    public static void main(String[] args) {
        final text s = new text();
        int[] arr = {1,2,5,6,1,12,18};
        System.out.println(s.changeCoin(arr, 18));
    }
    int[] arr;
    public int changeCoin(int[] coins,int target){
        arr = new int[target+1];
        return back(coins,target);
    }
    public int back(int[] coins,int target){
        if(target<0){
            return Integer.MAX_VALUE;
        }
        if(target==0){
            return 0;
        }
        if(arr[target]!=0){
            return arr[target];
        }
        int res = Integer.MAX_VALUE;
        for(int coin:coins){
            int back = back(coins,target-coin);
            if(back<res){
                res = Math.min(res,back)+1;
            }
        }
        arr[target] = res;
        return arr[target];
    }
}
