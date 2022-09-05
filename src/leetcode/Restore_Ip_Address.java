package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Restore_Ip_Address {
    public static ArrayList<String> genIp(String s) {
        int n = s.length();
        ArrayList<String> result = new ArrayList<>();
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    int d = n - (a + b + c);
                    if (d >= 1 && d <= 3) {
                        int A = Integer.parseInt(s.substring(0, a));
                        int B = Integer.parseInt(s.substring(a, a + b));
                        int C = Integer.parseInt(s.substring(a + b, a + b + c));
                        int D = Integer.parseInt(s.substring(a + b + c, a + b + c + d));
                        if (A <= 255 && B <= 255 && C <= 255 && D <= 255) {
                            String ip = A + "." + B + "." + C + "." + D;
                            if (ip.length() == n + 3) {
                                result.add(ip);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        String input = "101023";
        List<String> strings = restoreIpAddresses(input);
        for (String a : strings) {
            System.out.println(a);
        }
    }


    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfs(s, new ArrayList<>(), 0, 4, result);
        return result;
    }

    static void dfs(String s, List<String> current, int j, int k, List<String> result) {
        if (j == s.length() && k == 0) {
            result.add(String.join(".",current));
            return;
        }

        for (int i = j; i < Math.min(s.length(), j + 3); i++) {
            if (k < 0)
                break;
            String str = s.substring(j, i + 1);
            if (isValid(str)) {
                continue;
            }
            current.add(str);
            dfs(s, current , i + 1, k - 1, result);
            current.remove(current.size()-1);;
        }
    }

    private static boolean isValid(String sb) {
        int num = Integer.parseInt(sb);
        int size = sb.length();
        if (size == 2 && num < 10) return true;
        if (size == 3 && num < 100) return true;
        if (size == 3 && num > 255) return true;
        return false;
    }

}
