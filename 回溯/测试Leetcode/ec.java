package 回溯.测试Leetcode;

import java.util.ArrayList;
import java.util.List;

public class ec {
    public static void main(String[] args) {
        final ec s = new ec();
        int[] arr = {1,2,3};
        System.out.println(s.subsets(arr));
    }

    List<List<Integer>> list;

    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        back(nums,0,path);
        return list;
    }

    public void back(int[] nums,int index,List<Integer> path){
        if(index == nums.length){
            System.out.println(path.toString());
            list.add(new ArrayList<>(path));
            return;
        }
        back(nums,index+1,path);
        path.add(nums[index]);
        back(nums,index+1,path);
        path.remove(path.size()-1);
    }
}
