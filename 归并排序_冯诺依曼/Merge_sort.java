package 归并排序_冯诺依曼;

import java.util.Arrays;
import java.util.Stack;


/**
 * 用一个辅助数组对原来分成若干份的数组【需要给定该数组的下标，直接对该区间数组进行排序】进行原地排序
 * 归并排序的实质是拆分：再对给定的区间索引 如[5,10)进行排序，mid=(10+5)/2=7     --> [5,7) [7,10)
 */
public class Merge_sort {
    public static void main(String[] args) {
        final Merge_sort s = new Merge_sort();
//        s.sum();
        int[] arr={15,4,88,62,97,41,99,854,100,10};
        s.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public int[] leftArray;
    public void sort(int[] arr){
        leftArray = new int[arr.length >> 1];
        sort(0,arr.length,arr);
    }
    public void sort(int begin,int end,int[] arr){
        if(end - begin < 2)return;        //一个元素就return，即最少为两个两个元素一组，
        int mid = (end+begin)>>1;         //比如 [arr.length-2,arr.length]这两个元素，这样就执行先复制一份arr.length-2这个索引的元素到leftArray中，
                                          //和原来的在arr.length-2这个位置开始的两个元素的数组进行比较插入
        //分块操作【两个数及其两个数以上的merge操作】
        sort(begin,mid,arr);           //      [begin,mid)
        sort(mid,end,arr);              //    [mid,end)
        merge(begin,mid,end,arr);
    }
    public void merge(int begin,int mid,int end,int[] arr){
        int li=0, le=mid-begin;         // le 和 re 是用来判断 li 和 ri 是否越界
        int ri=mid,re = end;
        int ai = begin;
        //if (le - li >= 0) System.arraycopy(arr, begin + li, leftArray, li, le - li);
        for(int i =li;i<le;i++){
            leftArray[i]=arr[begin + i];
        }
        //两个有序的数组的merge
        while (li < le){     //都是 "leftArray中的元素" 比对完成后才算结束  【因为最终你都需要将lefyArray中的元素全部移到arr中】
            if(ri<re && (arr[ri]-leftArray[li])>0){     //ri<re 保证右边不越界，直接进入else将左边的元素搬过去即可
                arr[ai++] = arr[ri++];           //copy数组的常用操作！！
            }else {
                arr[ai++] = leftArray[li++];
            }
        }
    }






    Stack<Integer> stack = new Stack<>();
    public void sum(){
        if(stack.size() == 3){
            System.out.println(stack.toString());
            return;
        }
        stack.push(0);
        sum();
        stack.pop();
        stack.push(1);
        sum();
        stack.pop();
    }
}
