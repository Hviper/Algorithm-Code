package 递归;

public class 迷宫回溯法 {
    public static void main(String[] args) {
        迷宫回溯法 s = new 迷宫回溯法();
        int[][] arr = s.build_place();



        //双重for循环打印当前设置好的迷宫
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 7; i1++) {
                System.out.print(arr[i][i1]+"\t");
            }
            System.out.println();
        }
        System.out.println(s.find_way(arr, 2, 1));


        //打印之后
        System.out.println("------------------------------------------------>");
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 7; i1++) {
                System.out.print(arr[i][i1]+"\t");
            }
            System.out.println();
        }

    }



    public boolean find_way(int[][] arr,int x,int y){
        if(arr[6][5]==2)return true;
        else {
            if(arr[x][y] == 0){
                arr[x][y]=2;         //回溯，就一直探测下去
                if(find_way(arr,x,y+1)){

                    return true;
                }else if(find_way(arr,x+1,y)) {

                    return true;
                }else if(find_way(arr,x-1,y)){

                    return true;
                }
                else if(find_way(arr,x,y-1)){

                    return true;
                }else {
                    arr[x][y] =3;
                    return false;
                }
            }else return false;
        }
    }





    public int[][] build_place(){
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
        return arr;
    }
}
