package 递归;

public class test {
    public static void main(String[] args) {
        test test = new test();
        int bool = test.bool(10);
        System.out.println(bool);
        int i = test.public_bool(6);
        System.out.println(i);
    }
    public int bool(int n){
        if(n==1 || n==2)return 1;
        else return bool(n-1)+bool(n-2);
    }

    public int public_bool(int n){
        if(n==1 || n==2)return 1;

        int a=1,b=1;
        return bool(n,a,b);
    }

// 1 1 2 3 5 8 13         /4:a=2,b=1;a=3,b=2
    //使得每次递归都用的是这个arr数组，也可以换成int element来实现搜索该数子
    public int bool(int n,int a,int b){
        for(int i=3;i<=n;i++){
            a=a+b;
            b=a-b;
        }
        //n为偶数返回b，奇数返回a
        return a;
    }
}
