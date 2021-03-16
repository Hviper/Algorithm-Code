package 回溯.回溯算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 子集问题 {
    public static void main(String[] args) {
        子集问题 s = new 子集问题();
        int[] arr={1,2,3,4};
        System.out.println(s.subsets(arr));
        s.back(arr,0);
//        s.backing(arr,0);
//        System.out.println(s.list);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        dfs(nums, 0, len, stack, res);
        return res;
    }

    private void dfs(int[] nums, int index, int len,
                     Stack<Integer> stack, List<List<Integer>> res) {
        if (index == len) {             //说明已经到了叶子节点中！！【我们这里就是需要收集所有的叶子节点】
            res.add(new ArrayList<>(stack));
            return;
        }


        // 当前数可选，也可以不选 【二叉树！！相当于处理左右子节点】
        // 不选，直接进入下一层
        dfs(nums, index + 1, len, stack, res);

        // 选了有，进入下一层

        stack.add(nums[index]);
        dfs(nums, index + 1, len, stack, res);
        stack.pop();

    }



    Stack<Integer> stack = new Stack<>();
    public void back(int[] arr,int index){
        if(index == arr.length){               //收集叶子节点
            System.out.println(stack.toString());
            return;
        }
//        System.out.println(stack.toString());         //这样会导致没有递归结束条件【下面的backing()函数不一样，因为有for循环，for循环的次数决定】
        back(arr,index+1);

        stack.push(arr[index]);
        back(arr,index+1);
        stack.pop();
    }


    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    Stack<Integer> s = new Stack<>();
    public void backing(int[] arr,int begin){
        list.add(new ArrayList<Integer>(s));      //收集所有节点
        for(int i=begin;i<arr.length;i++){
            s.push(arr[begin]);
            backing(arr,begin+1);
            s.pop();
        }
    }

}
