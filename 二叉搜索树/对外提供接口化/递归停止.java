package 二叉搜索树.对外提供接口化;


public class 递归停止 {
    boolean flag=false;
    int sign=0;
    public static void main(String[] args) {
        递归停止 s = new 递归停止();
        int result=s.public_hash(10);
        System.out.println(result);
    }

    public int public_hash(int n){
        if(n==1 || n==2){return 1;}
        int[] arr=new int[n+1];
        arr[1]=1;
        arr[2]=1;

        int result = hash(n,arr);
        if(flag){
            return arr[sign];
        }
        return result;

    }
    private int hash(int n,int[] arr){
        if(arr[n]==8){
            flag=true;
            sign=n;       //n=6,将值存起来，搞个成员变量存起来 【多线程下是不安全的】
        }
        if(arr[n]==0){
            arr[n]=hash(n-1,arr)+hash(n-2,arr);
        }
        return arr[n];
    }
}
