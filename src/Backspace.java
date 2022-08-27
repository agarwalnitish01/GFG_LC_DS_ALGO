public class Backspace {
    public static void main(String args[]){

        int k = 0;
        char[] input =  "abc#de#f#ghi#jklmn#op#".toCharArray();
        char[] result = new char[input.length];

        for(int i = 0 ;i <input.length;i++){
            if(input[i] == '#'){
                if(k==0){
                    continue;
                }
                k--;
            } else {
                result[k] = input[i];
                k++;
            }
        }
        for(int i=0;i<k;i++) {
            System.out.print(result[i]);
        }

    }
}
