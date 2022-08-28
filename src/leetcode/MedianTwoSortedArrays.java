package leetcode;

public class MedianTwoSortedArrays {
    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        int[] arr3 = new int[l1 + l2];
        int mid = l1+l2;
        boolean odd = false;
        if(mid%2!=0){
            odd = true;
        }
        mid = mid/2;
        int i=0,j=0,k=0;
        int prev = 0;
        int num = 0;
        while(i<l1 && j < l2 ){
            if(arr1[i]<arr2[j])
                arr3[k] = arr1[i++];
            else
                arr3[k] = arr2[j++];

            num = arr3[k++];
            if(k>mid){
                if(odd){
                    return num;
                } else {
                    return (double)(prev+ num )/2;
                }
            }

            prev = num;
        }
        while (i < l1) {
            arr3[k++] = arr1[i++];

            if(k==mid){
                if(odd){
                    return num;
                } else {
                    return (double)(prev+ num )/2;
                }
            }

            prev = num;
        }

        // Store remaining elements of second array
        while (j < l2) {
            arr3[k++] = arr2[j++];

            if(k==mid){
                if(odd){
                    return num;
                } else {
                    return (double)(prev+ num )/2;
                }
            }

            prev = num;
        }

        return 0;

    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
