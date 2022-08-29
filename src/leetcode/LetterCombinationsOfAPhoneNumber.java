package leetcode;

import java.util.*;

class LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {

        ArrayList<String> ans = new ArrayList<>();

        if(digits.length() == 0)
            return ans;

        ans.add("");

        HashMap<Character,String> map = new HashMap<>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};


        for(int i=0 ; i<digits.length() ; i++){
            char[] value = map.get(digits.charAt(i)).toCharArray();
            ArrayList<String> temp = new ArrayList<>();

            while(!ans.isEmpty()){
                String s = ans.get(0);

                for (char c : value) {
                        temp.add(s + c);
                }
                ans.remove(0);
            }
            ans = temp;
        }
        return ans;
    }

    // Driver code
    public static void main(String[] args) {
        List<String> strings = letterCombinations("234");
        for(String s : strings){
            System.out.print(s + " ");
        }
    }
}