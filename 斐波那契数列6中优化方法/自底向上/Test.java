package 斐波那契数列6中优化方法.自底向上;


import java.util.Arrays;
//优化二
//利用数组进行自底向上求解 （时间复杂度为 O(n) ，空间复杂度也比递归调用的消耗少）
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int fb = test.Fb(6);
        System.out.println(fb);
        int[] fbl = test.Fbl(20);
        System.out.println(Arrays.toString(fbl));
    }
    
    public int Fb(int n){
        int[] arr = new int[n+1];
        arr[1]=1;
        arr[2]=1;
        for(int i =3;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }


    //将斐波那契数据全部保存在数组中！！！【自下而上】
    public int[] Fbl(int n){
        int[] arr=new int[n+1];
        arr[1]=1;
        arr[2]=1;
        for(int i=3;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr;
    }
}
