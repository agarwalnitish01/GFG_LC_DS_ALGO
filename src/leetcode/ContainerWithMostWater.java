package leetcode;

public class ContainerWithMostWater {
    public static int trap(int[] A) {
        int i = 0;
        int j = A.length -1;
        int area = 0;

        while (i < j)
        {
            // Calculating the max area
            area = Math.max(area,Math.min(A[i], A[j]) * (j - i));

            if (A[i] < A[j])
                i += 1;

            else
                j -= 1;
        }
        return area;
    }

    public static void main(String[] args){
        int[] arr = {1,8,6,2,5,4,8,3,7};

      System.out.println(trap(arr));
    }
}
