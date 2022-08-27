public class longestprefixSuffix {
    public static void main(String[] args){
        String input = "aaaa";
        char[] c = input.toCharArray();
        int start = 0;
        int middle = (c.length+1)/2;
        String result = "";
        while(middle<c.length){
            if(c[start] == c[middle]){
                result = result + c[start];
            }
            else {
                result = "";
            }
            start++;
            middle++;
        }
        System.out.println(result.length());
        System.out.println(longestPrefixSuffix(input));
    }
    static int longestPrefixSuffix(String s)
    {
        int n = s.length();

        // If n is less than 2
        if(n < 2) {
            return 0;
        }

        int len = 0;
        int i = (n + 1)/2;

        // Iterate i till n
        while(i < n)
        {

            // If s.charAt(i) is equal to
            // s.charAt(len)
            if(s.charAt(i) == s.charAt(len))
            {
                ++len;
                ++i;
            }
            else
            {
                i = i - len + 1;
                len = 0;
            }
        }

        // Return len
        return len;

    }

}
