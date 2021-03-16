package 栈相关的题;

import java.util.ArrayList;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        final test test = new test();
        test.divingBoard(1,2,3);
        System.out.println(test.reverseLeftWords("hello", 2));
    }

    public String reverseLeftWords(String s, int n) {
        char[] res = new char[s.length()];
        final char[] chars = s.toCharArray();
        for(int begin = n;begin<s.length()+n;begin++){
            res[begin-n] = chars[begin%s.length()];
        }
        return new String(res);
    }


    public int[] divingBoard(int shorter, int longer, int k) {
        if(shorter==longer){
            return new int[]{k*shorter};
        }
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<=k;i++){
            sum = shorter*(k-i)+longer*i;
            list.add(sum);
        }
        System.out.println(list.toString());
        return null;
    }


    Stack<Integer> stack = new Stack<>();
    public void backing(int shorter,int longer,int k){
        if(stack.size()==k){
            System.out.println(stack.toString());
            return;
        }
        stack.push(shorter);
        backing(shorter,longer,k);
        stack.pop();

        stack.push(longer);
        backing(shorter,longer,k);
        stack.pop();
    }
}
