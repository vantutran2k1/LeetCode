package AddTwoNumbersII445;

import utils.linkedlist.singly.ListNode;
import utils.linkedlist.singly.SinglyLinkedListUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {
    private record TestCase(ListNode l1, ListNode l2, ListNode expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(
                        SinglyLinkedListUtils.build(new int[]{7, 2, 4, 3}),
                        SinglyLinkedListUtils.build(new int[]{5, 6, 4}),
                        SinglyLinkedListUtils.build(new int[]{7, 8, 0, 7})
                ),
                new Solution.TestCase(
                        SinglyLinkedListUtils.build(new int[]{2, 4, 3}),
                        SinglyLinkedListUtils.build(new int[]{5, 6, 4}),
                        SinglyLinkedListUtils.build(new int[]{8, 0, 7})
                ),
                new Solution.TestCase(
                        SinglyLinkedListUtils.build(new int[]{0}),
                        SinglyLinkedListUtils.build(new int[]{0}),
                        SinglyLinkedListUtils.build(new int[]{0})
                )
        );

        for (TestCase testCase : testCases) {
            System.out.println(SinglyLinkedListUtils.equals(addTwoNumbers(testCase.l1, testCase.l2), testCase.expectedResult));
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = getValueDeque(l1);
        Deque<Integer> deque2 = getValueDeque(l2);
        Deque<Integer> deque = new ArrayDeque<>();
        int carry = 0;

        while (!deque1.isEmpty() || !deque2.isEmpty() || carry != 0) {
            int val1 = deque1.isEmpty() ? 0 : deque1.pop();
            int val2 = deque2.isEmpty() ? 0 : deque2.pop();

            int currentSum = val1 + val2 + carry;
            carry = currentSum / 10;

            deque.push(currentSum % 10);
        }

        return getNodeFromDeque(deque);
    }

    private static ListNode getNodeFromDeque(Deque<Integer> deque) {
        if (deque.isEmpty()) return null;

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!deque.isEmpty()) {
            cur.next = new ListNode(deque.pop());
            cur = cur.next;
        }

        return head.next;
    }

    private static Deque<Integer> getValueDeque(ListNode l) {
        Deque<Integer> deque = new ArrayDeque<>();

        ListNode cur = l;
        while (cur != null) {
            deque.push(cur.val);
            cur = cur.next;
        }

        return deque;
    }
}
