import java.util.HashMap;
import java.util.HashSet;

public class ArraysAndStrings {

    public static void main(String[] args) {

    }

    /**
     * 1.1
     * @param s input string
     * @return true if input has unique characters
     */
    public boolean isUnique(String s) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            if(set.contains(s.charAt(i))) return false;
            set.add(s.charAt(i));
        }
        return true;
    }

    /**
     * 1.2
     * @param s1 first input string
     * @param s2 second input string
     * @return true if s2 is a permutation of s1
     */
    public boolean isPermutation(String s1, String s2) {
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();

        if(s1.length() != s2.length()) return false;

        for(int i=0; i<s1.length(); i++) {
            char curr = s1.charAt(i);
            if(s1Map.containsKey(curr)) s1Map.put(curr, s1Map.get(curr) + 1);
            else s1Map.put(curr, 1);
        }

        for(int i=0; i<s2.length(); i++) {
            char curr = s2.charAt(i);
            if(s2Map.containsKey(curr)) s2Map.put(curr, s2Map.get(curr) + 1);
            else s2Map.put(curr, 1);
        }

        for(Character key: s1Map.keySet()) {
            if(!s2Map.containsKey(key) || !s2Map.get(key).equals(s1Map.get(key))) return false;
        }
        return true;
    }

    public String URLify(String s, int length) {
        return "";
    }
}
