package 斐波那契数列6中优化方法.滚动数组;

//优化三
public class test {
    public static void main(String[] args) {
        test test = new test();
        int sort = test.Scrolling_array(6);
        System.out.println(sort);
    }
    public int Scrolling_array(int n){
        if(n>0 && n<=2){return 1;}    //如果 n 是 1或者2，直接返回即可，省去创建数组的空间
        int[] arr=new int[2];
        arr[0]=1;
        arr[1]=1;
        for(int i=3;i<=n;i++){
            if(i%2==0){
                arr[0]=arr[0]+arr[1];
            }
            else arr[1]=arr[0]+arr[1];

        }
        if(n%2==0){
            return arr[0];
        }
        return arr[1];
    }
}
