package leetcode;

public class SearchRotatedArray {
    public static void main(String[] args){
        int[] arr = {4,5,6,7,8,9,0,1,2};
        int target = 1;
        System.out.println(SearchInRotatedArray(arr,target));
        System.out.println(search(arr,0,arr.length-1,target));
    }

    public static int binarySearch(int[] nums, int target, int l, int h) {
        int mid = 0;
        while(l<=h){
            mid = (l + h)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if (nums[mid] > target){
                h = mid-1;
            } else {
                l = mid+1;
            }
        }

        return -1;
    }

    public static int SearchInRotatedArray(int[] arr, int target){
        int pivotElement = findPivot(arr, 0, arr.length - 1);
        if(arr[pivotElement] == target){
            return pivotElement;
        } else if (arr[0] > target){
            return binarySearch(arr,target, pivotElement+1, arr.length);
        } else {
            return binarySearch(arr,target, 0, pivotElement-1);
        }
    }

    static int findPivot(int[] arr, int l, int h)
    {
        // base cases
        if (l > h)
            return -1;
        if (l == h)
            return l;

        /* low + (high - low)/2; */
        int mid = (l + h) / 2;
        if (mid < h && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > l && arr[mid - 1] > arr[mid])
            return (mid - 1);
        if (arr[l] >= arr[mid])
            return findPivot(arr, l, mid - 1);
        return findPivot(arr, mid + 1, h);
    }

    //   int[] arr = {4,5,6,7,8,9,0,1,2};
    //   int target = 1;
    static int search(int[] arr, int l, int h, int target) {
        if (l > h)
            return -1;

        int mid = (l + h) / 2;
        if (arr[mid] == target)
            return mid;

        if (arr[l] <= arr[mid]) {
            if (target >= arr[l] && target <= arr[mid]) {
                return search(arr, l, mid - 1, target);
            } else {
                return search(arr, mid + 1, h, target);
            }
        } else {
            if (target >= arr[mid] && target <= arr[h]) {
                return search(arr, mid + 1, h, target);
            } else {
                return search(arr, l, mid - 1, target);
            }
        }
    }
}
