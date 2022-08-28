package leetcode;


class StringToInteger {

    public static void main(String args[]) {
        String s = "-2147483649";
        System.out.println(myAtoi(s.trim()));
    }

    public static int myAtoi(String s) {
        s = s.trim();
        long ans = 0;
        if (s.isBlank())
            return 0;
        int sign = 1;
        int counter = 0;
        if (s.charAt(0) == '+') {
            counter++;
        } else if (s.charAt(0) == '-') {
            sign = -1;
            counter++;
        }

        for (int i = counter; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            ans = ans * 10 + Character.getNumericValue(s.charAt(i));
            if (sign * ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (sign * ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return sign * (int) ans;
    }

}
