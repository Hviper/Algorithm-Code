package 回溯.回溯算法;


import java.util.Stack;

public class Queue {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.test(8);
        System.out.println(queue.size);
    }
    int size;
    Stack<Integer> stack;
    public void test(int n){
        stack = new Stack<Integer>();
        place(0,n);
    }
    public void place(int row,int n){
        if(stack.size() == n){
            size++;
            System.out.println(stack.toString());
            return;
        }
        for(int col=0;col<n;col++){
            if(isValue(row,col)){
                stack.push(col);
                place(row+1,n);
                stack.pop();         //回溯操作
            }
        }
    }
    public boolean isValue(int row,int col){
        for (int i = 0; i < row; i++) {
            if(stack.get(i) == col)return false;
            if(row-i == Math.abs(col- stack.get(i)))return false;
        }
        return true;
    }

}
