package 二分查找;

public class binarySearch_test {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        binarySearch_test test = new binarySearch_test();

        System.out.println(test.search_element(arr,5));


    }
    public int search_element(int[] arr,int target){
        int right =arr.length-1;
        int left = 0;
        int mid = (right+left)>>1;
        while (true){
            if(arr[mid] >target){
                right = mid-1;
            }else if(arr[mid] < target){
                left = mid+1;
            }else if(left > right)break;
            else return mid;
        }
        return -1;
    }

    public int search(int[] arr,int obj){
        int right=arr.length-1;
        int left=0;

        while(left<=right){
            int mid=(right+left)>>>1;
            if(obj==arr[mid]){
                return mid;
            }
            else if(obj>arr[mid]){
                left=mid+1;
            }
            else if(obj<arr[mid]){
                right=mid-1;
            }
        }
        return -1;
    }

}
