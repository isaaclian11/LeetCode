package datastructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ArraysAndStrings {

    public static void main(String[] args) {
        String s = "abbbbbbbbbbb";
        System.out.println(compressString(s.toCharArray()));
    }

    /**
     * 1.1
     * @param s input string
     * @return true if input has unique characters
     */
    public static boolean isUnique(String s) {
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
    public static boolean isPermutation(String s1, String s2) {
        HashMap<Character, Integer> s1Map = new HashMap<>();

        if(s1.length() != s2.length()) return false;

        for(int i=0; i<s1.length(); i++) {
            char curr = s1.charAt(i);
            if(s1Map.containsKey(curr)) s1Map.put(curr, s1Map.get(curr) + 1);
            else s1Map.put(curr, 1);
        }
        for(int j=0; j<s2.length(); j++) {
            char curr = s2.charAt(j);
            if(s1Map.containsKey(curr)) s1Map.put(curr, s1Map.get(curr) - 1);
            else s1Map.put(curr, 1);

        }

        for(Character key: s1Map.keySet()) {
            if(s1Map.get(key) != 0) return false;
        }
        return true;
    }

    /**
     * 1.3
     * @param s the input string
     * @param length the true length of the string
     * @return a string that has all the white spaces, within the true length, replaced with "%20"
     */
    public static String URLify(String s, int length) {
        char[] array = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<length; i++) {
            if(array[i] == ' ') {
                result.append("%20");
            }
            else {
                result.append(array[i]);
            }
        }
        return result.toString();
    }

    /**
     * 1.4
     * @param s input string
     * @return true if the input string is a permutation palindrome
     */
    public static boolean isPermutationPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        boolean charWithOneValueFound = false;

        for(char c: s.toCharArray()) {
            char lowercase = Character.toLowerCase(c);
            if(map.containsKey(lowercase) && lowercase != ' ') {
                map.put(lowercase, map.get(lowercase) + 1);
            }else if(lowercase != ' ') {
                map.put(lowercase, 1);
            }
        }
        for(char c: map.keySet()) {
            if(map.get(c) == 1) {
                if(charWithOneValueFound) return false;
                else charWithOneValueFound = true;
            } else if(map.get(c) % 2 != 0) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

    /**
     * 1.5
     * @param s the first input string
     * @param t the second input string
     * @return true if string t has one edit in s
     */
    public static boolean isOneEdit(String s, String t) {

        if(Math.abs(s.length() - t.length()) > 1) return false;

        // TODO
        return true;
    }

    public static String compressString(char[] chars) {
        if(chars.length < 2) return chars.toString();

        int charCount = 0;
        char curr = '\0';
        StringBuilder s = new StringBuilder();

        for(int i=0; i<chars.length; i++) {
            if(chars[i] != curr) {
                if(curr != '\0') {
                    s.append(curr);
                    s.append(charCount);
                }
                charCount = 1;
                curr = chars[i];
            } else {
                charCount++;
            }
        }
        s.append(curr);
        s.append(charCount);
        if(s.length()<chars.length) return s.toString(); else return Arrays.toString(chars);
    }

    /**
     * 1.7 - Rotate NxN matrix by 90 degrees
     * @param matrix input matrix of size NxN
     */
    public static void rotate(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix[0].length];

        int copyI;
        int copyJ = 0;
        for(int i=0; i<matrix.length; i++){
            copyI = matrix.length - 1;
            for(int j=0; j<matrix[i].length; j++) {
                // j = col, i = row
                temp[i][j] = matrix[copyI][copyJ];
                copyI--;
            }
            copyJ++;
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}
