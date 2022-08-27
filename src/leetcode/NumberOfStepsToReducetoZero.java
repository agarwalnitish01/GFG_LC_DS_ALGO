package leetcode;

public class NumberOfStepsToReducetoZero {
    public static void main(String[] args){
        int num = 14;
        System.out.println(getSteps(num));
    }

    private static int getSteps(int i) {
        int count = 1;
        while(i>0){
            if(i%2!=0){
                i = i-1;
                count++;
            }else {
                i = i / 2;
                count++;
            }
        }
        return count;
    }
}
