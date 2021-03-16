package 常规题;

public class 汉诺塔 {
    public static void main(String[] args) {
        move("a", "b", "c", 3);
    }

    //a通过c移动到b    【角色更替】
    static public void move(String a,String b,String c,int n){
        if(n==1){
            System.out.println(a+"--->"+b);
            return;
        }
        move(a,c,b,n-1);
        System.out.println(a+"--->"+b);
        move(c,b,a,n-1);

    }
}
