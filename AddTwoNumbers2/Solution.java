package AddTwoNumbers2;

import utils.linkedlist.singly.ListNode;
import utils.linkedlist.singly.SinglyLinkedListUtils;

import java.util.List;

public class Solution {
    private record TestCase(ListNode l1, ListNode l2, ListNode expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(
                        SinglyLinkedListUtils.build(new int[]{2, 4, 3}),
                        SinglyLinkedListUtils.build(new int[]{5, 6, 4}),
                        SinglyLinkedListUtils.build(new int[]{7, 0, 8})
                ),
                new Solution.TestCase(
                        SinglyLinkedListUtils.build(new int[]{0}),
                        SinglyLinkedListUtils.build(new int[]{0}),
                        SinglyLinkedListUtils.build(new int[]{0})
                ),
                new Solution.TestCase(
                        SinglyLinkedListUtils.build(new int[]{9, 9, 9, 9, 9, 9, 9}),
                        SinglyLinkedListUtils.build(new int[]{9, 9, 9, 9}),
                        SinglyLinkedListUtils.build(new int[]{8, 9, 9, 9, 0, 0, 0, 1})
                )
        );

        for (TestCase testCase : testCases) {
            System.out.println(SinglyLinkedListUtils.equals(addTwoNumbers(testCase.l1, testCase.l2), testCase.expectedResult));
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int currentSum = val1 + val2 + carry;
            carry = currentSum / 10;

            cur.next = new ListNode(currentSum % 10);
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return head.next;
    }
}
