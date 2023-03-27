package leetcode;

//https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/?page=2&languageTags=java
    class KthLargest {
        public static int findKthLargest(int[] nums, int k) {
            int[] freq = new int[20001];

            for(int i: nums){
                freq[i + 10000]++;
            }

            int count = nums.length - k;
            for(int i = 0 ; i < freq.length -1; i++){
                if(freq[i] > 0){
                    count -= freq[i];
                }

                if(count < 0){
                    return i - 10000;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            int[] arr = {3,2,1,5,6,4};

            System.out.println(findKthLargest(arr, 2));
        }
    }
