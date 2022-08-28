package leetcode;

public class Searched2DSortedMatrix {
    public static void main(String[] args) {



        int[][] mat = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int k = 7;
        System.out.println(search(mat, k));
    }

    private static boolean search(int[][] arr, int k) {
        int i,m,n,index1=-1,index2=-1;
        m = arr.length;
        n = arr[0].length;
        for(i = 0 ; i<m-1;i++){
            if(k >= arr[i][0]  && k < arr[i+1][0]){
                index1 = i;
                break;
            }
        }

        if(index1==-1){
            index1 = m-1;
        }

        for(i = 0 ; i<n;i++){
            if(k == arr[index1][i] ){
                index2 = i;
                break;
            }
        }

        if(index2!=-1) {
            System.out.println(index1 + "," + index2);
            return true;
        }
        else
            return false;
    }
}
