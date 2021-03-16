package ArrayList实现;

public class 阶层 {
    public static void main(String[] args) {
        Test test = new Test(10);
        test.Add(1);
        test.Add(2);
        test.Add(3);
        test.list();
    }
    public int sort(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        int result=1;
        for(int i=2;i<=n;i++){
            result=i*result;
        }
        return result;
    }

}
class Test{
    private int size=0;
    public int[] elements;
    public Test(int cap){
        elements=new int[cap];
    }
    public void Add(int element){
        elements[size]=element;
        size++;
        System.out.println("size为："+size);
    }
    public void list(){
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i]+"\t");
        }
    }
}