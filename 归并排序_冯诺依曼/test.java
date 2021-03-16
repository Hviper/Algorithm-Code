package 归并排序_冯诺依曼;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr={15,4,88,62,97,41,99,854,100,10};
        final test test = new test();
        test.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int[] leftArray;
    public void sort(int[] arr){
        leftArray = new int[arr.length >> 1];
        sort(0,arr.length,arr);
    }

    //拆分操作！！！，拆分最小单元为两个，即两个两个进行排序，然后两个两个再merge，再以此类推下去
    public void sort(int begin,int end,int[] arr){
        if(end-begin<2)return;          //确保分割最小分割为两个元素【该元素是存储位置相邻】，即一个元素就return
        int mid = (end+begin)>>1;
        sort(begin,mid,arr);
        sort(mid,end,arr);
        merge(begin,mid,end,arr);
    }
    //merge操作本身就是 “临近” 的数组之间的merge
    public void merge(int left,int mid,int right,int[] arr){
        int l=0,len=mid-left;
        int r=mid;
        int ai = left;
        for(int i=0;i<len;i++){
            leftArray[i]=arr[left+i];
        }
        while (l<len){      //从小到大
            if(r< right && (arr[r]-leftArray[l])<0){
                arr[ai++] = arr[r++];
            }else {
                arr[ai++] = leftArray[l++];
            }
        }
    }
}
