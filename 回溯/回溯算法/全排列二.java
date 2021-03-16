package 回溯.回溯算法;
import java.util.Arrays;

public class 全排列二 {
    public static void main(String[] args) {
        final 全排列二 s = new 全排列二();
        int[] arr = {1,2,3};
        s.sort(arr);
    }

    int[] arr;
    public void sort(int[] arr){
        if(arr==null || arr.length==0)return;
        this.arr = arr;
        back(0);
    }
    public void back(int index){
        if(index == arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=index;i<arr.length;i++){
            swap(index,i);
            back(index+1);
            swap(i,index);
        }
    }
    public void swap(int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
