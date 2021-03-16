package 双指针;

public class 去除数组中的target {
    public static void main(String[] args) {
        int[] arr={0,1,0,0,2,0,3,4,5,0,6,7,8,9,10,0};

        for (int i = 0; i < remove(arr,0); i++) {
            System.out.print(arr[i]+"\t");
        }
    }
    static public int remove(int[] arr,int target){
        int slow = 0;
        int fast = 0;
        while (fast<arr.length){
            if(arr[fast]==target){
                fast++;
                continue;
            }
            swap(slow++, fast++,arr);
        }
        return slow;
    }
    static public void swap(int a,int b,int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
