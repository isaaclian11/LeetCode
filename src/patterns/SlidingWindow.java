package patterns;

public class SlidingWindow {

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
        return minSubarray;
    }
}
