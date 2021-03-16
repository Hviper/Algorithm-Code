package 双指针;

public class 找逆序对 {
    public static void main(String[] args) {
        final 找逆序对 s = new 找逆序对();
        s.find(new int[]{1,2,3,5,4,6,7,8,9});

    }
    public void find(int[] arr){
        if(arr==null || arr.length == 0)return;
        int target = 0;        //记录逆序对的位置
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }else {
                target = i;
            }
        }
        System.out.println(target);
    }
}
