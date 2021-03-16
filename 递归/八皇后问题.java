package 递归;


//回溯算法的经典案例
public class 八皇后问题 {
    public static void main(String[] args) {
        int[][] arr=new int[10][10];
        for (int i = 0; i < 10; i++) {
            arr[0][i]=1;
            arr[9][i]=1;
        }
        for (int i = 0; i < 10; i++) {
            arr[i][0]=1;
            arr[i][9]=1;
        }
        arr[3][1]=1;
        arr[3][2]=1;
        arr[3][3]=1;
        for (int i = 0; i < 10; i++) {
            for (int i1 = 0; i1 < 10; i1++) {
                System.out.print(arr[i][i1]+"\t");
            }
            System.out.println();
        }
        八皇后问题 pop = new 八皇后问题();
        pop.find_way(arr,2,2);
        System.out.println("-----------------------");
        for (int i = 0; i < 10; i++) {
            for (int i1 = 0; i1 < 10; i1++) {
                System.out.print(arr[i][i1]+"\t");
            }
            System.out.println();
        }
    }
    public boolean find_way(int[][] arr,int i,int j){
        if(arr[8][8]==2){
            return true;
        }
        else {
            if(arr[i][j]==0){
                arr[i][j]=2;        //这里先设置为2，假如走不通后面会被设置为3
                if(find_way(arr,i+1,j)){
                    return true;
                }
                else if(find_way(arr,i,j+1)){
                    return true;
                }
                else if(find_way(arr,i-1,j)){
                    return true;
                }
                else if(find_way(arr,i,j-1)){
                    return true;
                }
                else {
                    arr[i][j]=3;       //设置走不通
                    return false;
                }
            }
            else {
                return false;
            }
        }

    }
}
