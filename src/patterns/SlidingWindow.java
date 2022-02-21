package patterns;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SlidingWindow {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestSubstringWithDistinctCharacters(s));
    }

    public static double[] findAveragesOfSubarrayOfSizeK(int k, int[] nums) {
        int startingWindow = 0;
        double[] result = new double[nums.length - k + 1];
        double windowSum = 0;

        for(int i=0; i<nums.length; i++) {
            windowSum += nums[i];
            if(i>=k-1) {
                result[startingWindow] = windowSum / k;
                windowSum -= nums[startingWindow];
                startingWindow++;
            }
        }
        return result;
    }

    public static int findTheMaximumSumOfSubarrayOfSizeK(int k, int[] nums) {
        int windowSum = 0;
        int windowStart = 0;
        int currMax = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            windowSum += nums[i];

            if(i >= k-1) {
                currMax = Math.max(windowSum, currMax);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return currMax;
    }

    // [2,1,5,2,3,2] k=7
    public static int findSmallestSubarrayWithSumSmallerThanK(int k, int nums[]) {
        if(nums.length == 0) return 0;

        int windowStart = 0;
        int currSum = nums[0];
        int minSubarray = Integer.MAX_VALUE;

        for(int windowEnd=1; windowEnd<nums.length; windowEnd++) {
            currSum += nums[windowEnd];

            while(currSum >= k) {
                minSubarray = Math.min(minSubarray, windowEnd - windowStart + 1);
                currSum -= nums[windowStart];
                windowStart++;
            }
        }
        return minSubarray == Integer.MAX_VALUE ? 0 : minSubarray;
    }

    // s="araaci", k=2 -> 4, "araa"
    public static int findLongestSubstringWithKDistinctCharacters(int k, String s) {
        char[] charArray = s.toCharArray();
        int windowStart = 0; //1
        int maxLength = Integer.MIN_VALUE; //4
        Map<Character, Integer> characterMap = new HashMap<>(); // [(a -> 2), (c -> 1)]

        for(int windowEnd=0; windowEnd<charArray.length; windowEnd++) {
            if(characterMap.containsKey(charArray[windowEnd])) {
                characterMap.put(charArray[windowEnd], characterMap.get(charArray[windowEnd] + 1));
            }
            else {
                characterMap.put(charArray[windowEnd], 1);
            }
            while(characterMap.size()>k) {
                characterMap.put(charArray[windowStart], characterMap.get(charArray[windowStart] - 1));
                if(characterMap.get(windowStart) == 0) {
                    characterMap.remove(charArray[windowStart]);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static int findTheNumberOfMaxFruitYouCanFitIntoTwoBaskets(char[] chars) {
        int windowStart = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> characterMap = new HashMap<>();

        for(int windowEnd=0; windowEnd<chars.length; windowEnd++) {
            if(characterMap.containsKey(chars[windowEnd])) {
                characterMap.put(chars[windowEnd], characterMap.get(chars[windowEnd] + 1));
            }
            else {
                characterMap.put(chars[windowEnd], 1);
            }
            while(characterMap.size()>2) {
                characterMap.put(chars[windowStart], characterMap.get(chars[windowStart] - 1));
                if(characterMap.get(windowStart) == 0) {
                    characterMap.remove(chars[windowStart]);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static int longestSubstringWithDistinctCharacters(String s) {
        HashSet<Character> set = new HashSet<>();
        int windowStart = 0;
        int result = 0;

        for(int windowEnd=0; windowEnd<s.length(); windowEnd++) {
            char currChar = s.charAt(windowEnd);
            while(set.contains(currChar)) {
                set.remove(s.charAt(windowStart));
                windowStart++;
            }
            set.add(currChar);
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        return result;
    }
}
