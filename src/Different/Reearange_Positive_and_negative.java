package Different;

public class Reearange_Positive_and_negative {
    public static void negFirstThenPos(int[] arr, int size){
        int i, j = 0;
        for(i = 0; i < size; i++){
            if(arr[i] < 0){
                if(i != j){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }

    static void negFirstThenPosWithOrder(int[] arr, int size){
        int i, temp, j;
        for(i = 1; i < size; i++){
            temp = arr[i];
            if (temp > 0)
                continue;

            j = i - 1;

            while(j >=0 && arr[j] > 0){
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }
    }


    public static void main(String[] args){
        int[] arr = {1,-3,9,-5,-2,6,4,-7};
        posFirstThenNegWithOrder(arr,arr.length);
        for(int a : arr) {
            System.out.println(a);
        }
    }

    public static void postgFirstThenNeg(int[] arr, int size){
        int i, j = 0;
        for(i = 0; i < size; i++){
            if(arr[i] > 0){
                if(i != j){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }


    static void posFirstThenNegWithOrder(int[] arr, int size){
        int i, temp, j;
        for(i = 1; i < size; i++){
            temp = arr[i];
            if (temp < 0)
                continue;

            j = i - 1;

            while(j >=0 && arr[j] < 0){
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }
    }


}
