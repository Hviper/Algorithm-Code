package 递归;

public class 迷宫问题 {
    public static void main(String[] args) {
        int[][] arr=new int[8][7];       //8行7列,迷宫创建，“ 先行再列 ”
        for (int i = 0; i < 7; i++) {
            arr[0][i]=1;
            arr[7][i]=1;
        }
        for(int i=0;i<8;i++){
            arr[i][0]=1;
            arr[i][6]=1;
        }
        //设置挡板
        arr[3][1]=1;
        arr[3][2]=1;
        //打印当前设置好的迷宫
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 7; i1++) {
                System.out.print(arr[i][i1]+"\t");
            }
            System.out.println();
        }
        System.out.println("---------------------处理过后--------------------------");
        迷宫问题 map = new 迷宫问题();
        map.setWay(arr,2,1);
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 7; i1++) {
                System.out.print(arr[i][i1]+"\t");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }
    public boolean setWay(int[][] arr,int i,int j){
        if(arr[2][2]==2){
            return true;        //回溯出口
        }
        else {
            if(arr[i][j]==0){
                arr[i][j]=2;       //2表示通路。移动顺序：下右上左
                if(setWay(arr,i,j+1)){
                    // //处理需要处理的d代码，最后结束本次递归，并且返回true用来启动栈中下一个递归函数
                    return true;
                }
                //选择，所以不是if，而是else if
                else if(setWay(arr,i+1,j)){
                    return true;
                }
                else if(setWay(arr,i-1,j)){
                    return true;
                }
                else if(setWay(arr,i,j-1)){
                    return true;
                }
                else {
                    arr[i][j]=3;           //3表示死路
                    return false;
                }
            }
            //处理走不通的处理
            else {
                return false;       //1表示墙
            }
        }
    }
}
