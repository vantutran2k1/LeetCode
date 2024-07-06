package LemonadeChange860;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private record TestCase(int[] bills, boolean expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{5, 5, 5, 10, 20}, true),
                new Solution.TestCase(new int[]{5, 5, 10, 10, 20}, false)
        );

        for (TestCase testCase : testCases) {
            System.out.println(lemonadeChange(testCase.bills) == (testCase.expectedResult));
        }
    }

    public static boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> billCount = new HashMap<>();
        for (int bill : bills) {
            billCount.put(bill, getOrDefaultZero(billCount, bill) + 1);

            if (bill == 10) {
                if (getOrDefaultZero(billCount, 5) == 0)
                    return false;

                billCount.put(5, billCount.get(5) - 1);
            } else if (bill == 20) {
                if (getOrDefaultZero(billCount, 10) > 0) {
                    if (getOrDefaultZero(billCount, 5) == 0)
                        return false;

                    billCount.put(10, billCount.get(10) - 1);
                    billCount.put(5, billCount.get(5) - 1);
                } else {
                    if (getOrDefaultZero(billCount, 5) < 3)
                        return false;

                    billCount.put(5, billCount.get(5) - 3);
                }
            }
        }

        return true;
    }

    private static int getOrDefaultZero(Map<Integer, Integer> billCount, int value) {
        return billCount.getOrDefault(value, 0);
    }
}
