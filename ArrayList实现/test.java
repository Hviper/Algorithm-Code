package ArrayList实现;

public class test {
    int size;
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        test test = new test();
        test.remove(arr,0);
        for (int i : arr) {
            System.out.print(i+"\t");
        }
    }
    public void remove(int[] arr,int index){
        size=arr.length;
        for(int i=index+1;i<=size-1;i++){
            arr[i-1]=arr[i];
        }
        size--;
    }
}
