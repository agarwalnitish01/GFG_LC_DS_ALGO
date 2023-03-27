package leetcode;

    public class MinMovesToMakePalindrome {
        public static int minMovesToMakePalindrome(String s)
        {
            int n=s.length();
            StringBuilder sb=new StringBuilder(s);
            int ans=0;

            while(sb.length()>1)
            {
                char ch=sb.charAt(0);
                int pos=sb.lastIndexOf(ch+"");

                if(pos==0)
                    ans=ans + n/2;

                else
                {
                    ans=ans + n-pos-1;
                    sb.deleteCharAt(pos);
                    n--;
                }

                sb.deleteCharAt(0);
                n--;
            }

            return ans;
        }
        public static void main(String[] args){
            System.out.println(minMovesToMakePalindrome("aabb"));
        }
    }