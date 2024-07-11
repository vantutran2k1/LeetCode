package ReverseLinkedList206;

import utils.linkedlist.singly.ListNode;
import utils.linkedlist.singly.SinglyLinkedListUtils;

import java.util.List;

public class Solution {
    private record TestCase(ListNode head, ListNode expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(
                        SinglyLinkedListUtils.build(new int[]{1, 2, 3, 4, 5}),
                        SinglyLinkedListUtils.build(new int[]{5, 4, 3, 2, 1})
                ),
                new Solution.TestCase(
                        SinglyLinkedListUtils.build(new int[]{1, 2}),
                        SinglyLinkedListUtils.build(new int[]{2, 1})
                ),
                new Solution.TestCase(
                        SinglyLinkedListUtils.build(new int[]{}),
                        SinglyLinkedListUtils.build(new int[]{})
                )
        );

        for (TestCase testCase : testCases) {
            System.out.println(SinglyLinkedListUtils.equals(reverseList(testCase.head), testCase.expectedResult));
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }

        cur.next = pre;

        return cur;
    }
}
