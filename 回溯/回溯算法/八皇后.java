package 回溯.回溯算法;

import java.util.Arrays;

public class 八皇后 {
    public static void main(String[] args) {
        System.out.println("begin---------------------->");
        八皇后 e = new 八皇后();
        e.Queue8(8);
        System.out.println(e.count);
    }
    int size = 0;
    int[] arr;
    public void Queue(int n){
        arr = new int[n];
        place(0);
        System.out.println("一共有"+size+"种方法");
    }

    /**
     * 功能：从第row行开始，对该行的所有列进行判断遍历
     * @param row
     */
    public void place(int row){
        if(row==arr.length){   //越界处理
            size++;
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int col = 0; col < arr.length; col++) {
            if(isValue(row,col)){
                arr[row] = col;
                place(row+1); //下方类似于回溯操作，因为一维数组直接被覆盖了  【类似树的遍历，参数变化，（row+1）下一行，类似list(root.left)】
            }
        }
    }
    public boolean isValue(int row,int col){
        for (int i = 0; i < row; i++) {
            if(arr[i] == col)return false;
            if(row-i == Math.abs(col-arr[i]))return false;          //行减行，列减列
        }

        return true;
    }
    int[] nums;
    int count=0;
    public void Queue8(int n){
        if(n<2)return;
        nums=new int[n];
        Place(0);
    }
    public void Place(int row){
        if(row == nums.length){
            System.out.println(Arrays.toString(nums));
            count++;
            return;
        }
        for (int col = 0; col < nums.length; col++) {
            if(isVail(row,col)){
                nums[row]=col;
                Place(row+1);
            }
        }
    }
    public boolean isVail(int row,int col){
        for (int i = 0; i < row; i++) {
            if(col == nums[i]){
                return false;
            }
            if(row-i == Math.abs(col-nums[i]))return false;
        }
        return true;
    }

}
