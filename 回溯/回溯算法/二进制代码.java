package 回溯.回溯算法;

import java.util.Stack;

public class 二进制代码 {
    public static void main(String[] args) {

//        test(4);
        二进制代码 s = new 二进制代码();
        s.backing(3,0);
    }


    static void test(int n){
        Stack<Integer> stack=new Stack<Integer>();
        backtrack(stack,n);
    }
    static void backtrack(Stack<Integer> stack, int n){
        if(stack.size() == n){
            System.out.println(stack.toString());
            return;
        }
        for (int i=0;i<=1;i++){        //嵌套循环     【起始位置默认为0开始，这里可以传入一个参数用来控制起始位置】
            stack.add(i);
            backtrack(stack,n);
            stack.pop();     //为下一次循环，即选择的进度进行更替
        }
    }

    Stack<Integer> stack = new Stack<>();
    public void backing(int n,int index){       //index表示深度【即画的树的高度】
        if(index == n){
            System.out.println(stack.toString());
            return;
        }
        stack.push(0);
        backing(n,index+1);
        stack.pop();

        stack.push(1);
        backing(n,index+1);
        stack.pop();
    }

}
