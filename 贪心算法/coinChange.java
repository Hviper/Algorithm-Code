package 贪心算法;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class coinChange {
    public static void main(String[] args) {
        coinChange coinChange = new coinChange();
        int[] arr={25,20,5,1};

        coinChange.main(arr,41);
        coinChange.list.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println(coinChange.list.toString());
    }

    Stack<Integer> stack;
    ArrayList<Integer> list;
    int sum;
    public void main(int[] arr,int s){
        stack = new Stack<Integer>();
        list = new ArrayList<Integer>();
        sum = s;
        back(arr);
    }
    public void back(int[] arr){
        if(sum == 0){
//            list.add(stack.size());
//            System.out.println(stack.toString());
            return;
        }
        for (int value : arr) {
            if (sum >= value) {
                sum -= value;
                stack.push(value);
                back(arr);
                stack.pop();
            }
        }

    }



    public void change(){
        int[] arr={25,10,5,1};
        int money = 70;
        int coins = 0;
        for (int i = 0; i < arr.length; i++) {
            if(money<arr[i]){
                continue;
            }
            money = money - arr[i];
            System.out.println("选择了："+arr[i]);
            i--;
            coins++;
        }
        System.out.println("coins = "+coins);
    }

    public void text(){
        int[] arr={25,10,5,1};
        int cap = 70;
        int count = 0;
        int nums = 0;
        while (true) {
            if(nums == cap){
                System.out.println("结束------------->");break;}
            else if(nums >cap){
                System.out.println("false");
                break;
            }
            nums += arr[count];
            System.out.println("选择了："+arr[count]);
            if((cap-nums)<arr[count]){
                count++;
            }
        }
    }
}
