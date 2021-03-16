package 计数排序;

import java.util.Arrays;

/**
 *  争对执行流程：依次对个位数，十位数，百位数，千位数……进行排序（从低到高）
 *  个位数，十位数，百位数的取值范围都是固定的 0~9，可以使用计数排序对它们进行排序
 */
public class test {
    public static void main(String[] args) {
        int[] arr = {12,1,2,5,3,14,-12,-1,3,2,5,20,5,3,19,18};
        final test s = new test();
        System.out.println(Arrays.toString(s.Sort(arr)));
    }
    public int[] Sort(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int value : arr) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        System.out.println("最小的是"+min+"\t"+"最大的是"+max);
        int[] temp = new int[max-min+1];
        for (int i : arr) {
            temp[i - min] += 1;          //值作为辅助数组的索引，value存储次数
        }
        System.out.println(Arrays.toString(temp));
        int count = 0;
        for(int i=0;i<temp.length;i++){
            while(temp[i]!=0){
                arr[count++] = i+min;           //索引代表arr数组中的value，因为i之前减去了min，这里加上min为原来的value
                temp[i]-=1;
            }
        }
        return arr;
    }

}
