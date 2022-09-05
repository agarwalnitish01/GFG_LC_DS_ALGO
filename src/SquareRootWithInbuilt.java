
class SquareRootWithInbuilt {
    public static int mySqrt(int x) {
        int start = 1;
        int end = x;
        int res = 0;

        while (start <= end) {
            int mid = (end + start) / 2;
            if (mid <= x / mid) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
