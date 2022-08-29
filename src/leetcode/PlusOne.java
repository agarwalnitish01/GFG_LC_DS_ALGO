package leetcode;

class PlusOne {
    public static int[] plusOne(int[] digits) {

        int[] ans = new int[digits.length+1];

        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]!=9){
                digits[i]++;
                return digits;
            }
            else
                digits[i] = 0;
        }
        ans[0]=1;
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {9};
        int[] result = plusOne(arr);

        for(int a: result)
            System.out.print(a);
    }
}
