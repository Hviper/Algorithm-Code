package 递归;

/*
* 递归：处理单个单个坐标开始，递归，处理单个单个节点开始！！！
* */

public class 迷宫问题策略 {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];       //8行7列,迷宫创建，“ 先行再列 ”
        for (int i = 0; i < 10; i++) {
            arr[0][i] = 1;
            arr[9][i] = 1;
        }
        for (int i = 0; i < 10; i++) {
            arr[i][0] = 1;
            arr[i][9] = 1;
        }
        //设置挡板
        arr[3][1]=1;
        arr[3][2]=1;
        arr[3][3]=1;

        arr[3][7]=1;
        arr[5][4]=1;
        arr[5][7]=1;
        arr[5][5]=1;
        arr[5][6]=1;

        for (int i = 0; i < 10; i++) {
            for (int i1 = 0; i1 < 10; i1++) {
                System.out.print(arr[i][i1] + "\t");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------");
        迷宫问题策略 Dom = new 迷宫问题策略();
        Dom.find_backWay(arr,2,2);
        for (int i = 0; i < 10; i++) {
            for (int i1 = 0; i1 < 10; i1++) {
                System.out.print(arr[i][i1] + "\t");
            }
            System.out.println();
        }
    }
    public boolean find_backWay(int[][] arr,int i,int j){
        if(arr[8][8]==2){
            return true;
        }
        else {
            if(arr[i][j]==0){      //右下左上
                arr[i][j]=2;       //每一个坐标都是独立的,对该坐标进行赋值,设置走路路线，每次递归都会走这行代码
                if(find_backWay(arr,i,j+1)){
                    return true;
                }
                else if(find_backWay(arr,i-1,j)){
                    return true;
                }
                else if(find_backWay(arr,i,j-1)){
                    return true;
                }
                else if(find_backWay(arr,i+1,j)){
                    return true;
                }
                else {
                    arr[i][j]=3;
                    return false;   //走不通了
                }
            }
            //这个else代码处理走不通的路的问题
            else {       //处理不等于0的数，比如1，2，3，都设为不能走或者不能再重复走,一笔连成
                return false;
            }
        }
    }

}
