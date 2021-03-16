package 贪心算法;

public class 组合 {
    public static void main(String[] args) {
        组合 s = new 组合();
        s.n=4;
        s.change(1);
    }
    int n;
    int[] arr=new int[5];                 //存储
    int[] temp = new int[100];     //辅助

    public void change(int x){
        if(x > n){
            for (int i = 1; i <= n; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(temp[i] == 0){
                arr[x] = i;
                temp[i] = 1;
                change(x+1);
                temp[i]=0;
            }
        }
    }
}
