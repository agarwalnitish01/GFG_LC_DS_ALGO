package leetcode;

public class First_Bad_Version {
    public static void main(String[] args){
        System.out.println(firstBadVersion(2));
    }

    public static int firstBadVersion(int n) {
        int start = 0;
        int end = n-1;

        if(n < 2) {
            return n;
        }

        while(start<=end){
            int mid = (start+end)/2;

            if(isBadVersion(mid)){
                if(!isBadVersion(mid-1)){
                    return mid;
                }
                end = mid;
            }else{
                start = mid+1;
            }
        }

        return 0;
    }

    public static boolean isBadVersion(int version){
        if(version>=4)
            return true;
        else
            return false;
    }

}
