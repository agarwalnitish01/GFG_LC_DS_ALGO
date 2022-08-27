public class ValidIPAddress {
    public static void main(String[] args) {

        System.out.println(longestPrefixSuffix("1...1"));//F
    }

    static boolean longestPrefixSuffix(String s) {
        String[] array = s.split("\\.");
        if (array.length != 4 || s.charAt(s.length() - 1) == '.')
            return false;


        for (int i = 0; i < 4; i++) {
            try {
                if(array[i].length()!=1 && array[i].charAt(0)=='0'){
                    return false;
                }
                int num = Integer.parseInt(array[i]);
                if (!isvalid(num)) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    static boolean isvalid(int num) {
        if (num >= 0 && num <= 255)
            return true;
        else
            return false;
    }
}
