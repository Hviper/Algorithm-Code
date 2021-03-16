package 递归;

public class 迷宫test {
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

        System.out.println("----------------------");
        迷宫test s = new 迷宫test();
        s.Solve(arr,2,2);
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 7; i1++) {
                System.out.print(arr[i][i1]+"\t");
            }
            System.out.println();
        }
    }

    //该功能为找路,递归思路为：先理清楚该函数的功能！
    public boolean Solve(int[][] arr,int x,int y){
        if(arr[6][5]==2){
            return true;
        }
        if(arr[x][y]==0){
            arr[x][y]=2;
            if(Solve(arr,x,y+1)){       //一直往（y+1）方向走
                return true;
            }
            else if(Solve(arr,x+1,y)){    //上面的（y-1）走不通一直往（x+1）方向走
                return true;
            }
            else if(Solve(arr,x-1,y)){   //上面的（x+1）走不通一直往（x-1）方向走
                return true;
            }
            else if(Solve(arr,x,y-1)){    //上面的（x-1）走不通一直往（y-1）方向走
                return true;
            }
            else {
                arr[x][y]=3;
                return false;
            }
        }
        else return false;
    }
}














