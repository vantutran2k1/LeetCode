package MaxNumberofKSumPairs1679;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private record TestCase(int[] nums, int k, int expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{1, 2, 3, 4}, 5, 2),
                new Solution.TestCase(new int[]{3, 1, 3, 4, 3}, 6, 1),
                new Solution.TestCase(new int[]{3, 5, 1, 5}, 2, 0),
                new Solution.TestCase(new int[]{18, 44, 7, 58, 65, 88, 16, 2, 74, 21, 19, 1, 85, 43, 25, 78, 28, 12, 79, 55, 64, 38, 35, 34, 51, 42, 85, 77, 17, 26, 76, 33, 79, 15, 84, 33, 76, 83, 38, 65, 13, 23, 55, 53, 47, 85, 46, 63, 74, 29, 17, 81, 40, 13, 85, 71, 85, 12, 43, 86, 27, 31, 76, 28, 51, 69, 23, 35, 25, 50, 32, 49, 59, 87, 35, 68, 32, 35, 49, 59, 2, 28, 15, 45, 83, 20, 48, 24, 10, 73, 42, 30, 56, 79, 56, 36, 24, 61, 58, 7, 74, 7, 75, 67, 3, 39, 23, 64, 41, 21, 57, 88, 36, 82, 43, 56, 31, 44, 37, 83, 75, 18, 63, 30, 83, 2, 49, 64, 81, 75, 24, 66, 44, 46, 37, 11, 55, 26, 13, 15, 33, 56, 27, 10, 78, 49, 45, 81, 55, 57, 75, 51, 83, 9, 47, 40, 66, 11, 16, 5, 10, 66, 75, 63, 23, 4, 34, 87, 15, 80, 27, 42, 47, 50, 38, 32, 70, 63, 74, 77, 88, 24, 62, 29, 28, 72, 56, 14, 87, 34, 6, 56, 24, 7, 48, 22, 78, 76, 31, 81, 36, 7, 83, 74, 12, 40, 30, 3, 69, 54, 69, 37, 21, 75, 52, 35, 16, 88, 18, 56, 42, 44, 2, 48, 58, 39, 12, 89, 63, 53, 40, 71, 26, 21, 12, 33, 32, 33, 81, 78, 61, 43, 3, 68, 58, 10, 33, 50, 8, 32, 54, 88, 58, 2, 62, 43, 46, 14, 21, 81, 84, 19, 41, 83, 27, 4, 6, 73, 6, 23, 64, 27, 39, 11, 35, 31, 80, 40, 74, 27, 37, 55, 46, 22, 30, 5, 78, 73, 42, 9, 83, 58, 59, 4, 46, 74, 47, 33, 55, 44, 61, 90, 54, 73, 47, 10, 70, 46, 39, 58, 39, 56}, 10, 9)
        );

        for (TestCase testCase : testCases) {
            System.out.println(maxOperations(testCase.nums, testCase.k) == (testCase.expectedResult));
        }
    }

    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums)
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);

        float count = 0;
        for (var entry : numCount.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (k % 2 == 0 && k / 2 == key)
                count += (float) (value - value % 2) / 2;
            else if (numCount.containsKey(k - key))
                count += Math.min((float) value / 2, (float) numCount.get(k - key) / 2);
        }

        return (int) count;
    }
}
