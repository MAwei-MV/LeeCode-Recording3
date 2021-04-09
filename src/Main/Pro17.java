package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Pro17 {
    public static void main(String arg[]) {
        Pro17 p = new Pro17();
        String s = "23";
        p.letterCombinations(s);
    }

    public List<String> letterCombinations(String digits) {
        char[] c = digits.toCharArray();
        HashMap<Character, String[]> hm = new HashMap<>();
        hm.put('2', new String[]{"a", "b", "c"});
        hm.put('3', new String[]{"d", "e", "f"});
        hm.put('4', new String[]{"g", "h", "i"});
        hm.put('5', new String[]{"j", "k", "l"});
        hm.put('6', new String[]{"m", "n", "o"});
        hm.put('7', new String[]{"p", "q", "r", "s"});
        hm.put('8', new String[]{"t", "u", "v"});
        hm.put('9', new String[]{"w", "x", "y", "z"});
        if (digits.length() == 0) return new ArrayList<>();
        return helper(0, 1, c, hm);
    }

    private List<String> helper(int flag, int start, char[] c, HashMap<Character, String[]> hm) {
        if (start == c.length) {
            return Arrays.asList(hm.get(c[flag]).clone());
        } else {
            String[] StringList = hm.get(c[flag]);
            List<String> OldList = helper(flag + 1, start + 1, c, hm);
            List<String> newList = new ArrayList<>();
            for (String str : OldList) {
                for (String pre : StringList) {
                    String newStr = pre + str;
                    if (!newList.contains(newStr)) {
                        newList.add(newStr);
                    }
                }
            }
            return newList;
        }
    }

}
