package leetcode;


class Fibonacci {
    public static int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 0;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        return arr[n];
    }

    public static void main(String args[]){
        System.out.print(fib(1));
    }
}
