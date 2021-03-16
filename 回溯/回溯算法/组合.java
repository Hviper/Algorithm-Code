package 回溯.回溯算法;

import java.util.Stack;

public class 组合 {
    public static void main(String[] args) {
        组合 s = new 组合();
        s.test(5,3,1);
        System.out.println(s.size);
        System.out.println(('3'-'0'));
    }
//    ArrayList<Integer> list = new ArrayList<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    int size;
    public void test(int n,int k,int startIndex){
        if(stack.size() == k){
            size++;
            System.out.println(stack.toString());
            return;
        }
//        System.out.println(stack.toString());     //打印所有叶子节点！！！   【放在for循环前面表示前序遍历的方式】
        // for循环中没有显式的递归终止
        for(int i = startIndex; i<=n;i++){
            stack.push(i);
            test(n,k,i+1);
            stack.pop();   //回溯核心【栈重复利用】
        }
    }

}
