public class Backspace {
    public static void main(String args[]){

       System.out.println(getBackspacedResult("ab#c"));

    }

    public static String  getBackspacedResult(String s){
        int k = 0;
        char[] input =  s.toCharArray();
        char[] result = new char[input.length];
        StringBuilder str = new StringBuilder();
        for (char c : input) {
            if (c == '#') {
                if (k == 0) {
                    continue;
                }
                k--;
            } else {
                result[k] = c;
                k++;
            }
        }
        for(int i=0;i<k;i++) {
            str.append(result[i]);
        }
        return str.toString();
    }
}
