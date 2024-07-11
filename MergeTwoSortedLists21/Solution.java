package MergeTwoSortedLists21;

import utils.linkedlist.singly.ListNode;
import utils.linkedlist.singly.SinglyLinkedListUtils;

import java.util.List;

public class Solution {
    private record TestCase(ListNode list1, ListNode list2, ListNode expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(
                        SinglyLinkedListUtils.build(new int[]{1, 2, 4}),
                        SinglyLinkedListUtils.build(new int[]{1, 3, 4}),
                        SinglyLinkedListUtils.build(new int[]{1, 1, 2, 3, 4, 4})
                ),
                new Solution.TestCase(
                        SinglyLinkedListUtils.build(new int[]{}),
                        SinglyLinkedListUtils.build(new int[]{}),
                        SinglyLinkedListUtils.build(new int[]{})
                ),
                new Solution.TestCase(
                        SinglyLinkedListUtils.build(new int[]{}),
                        SinglyLinkedListUtils.build(new int[]{0}),
                        SinglyLinkedListUtils.build(new int[]{0})
                )
        );

        for (TestCase testCase : testCases) {
            System.out.println(SinglyLinkedListUtils.equals(mergeTwoLists(testCase.list1, testCase.list2), testCase.expectedResult));
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode current1 = list1;
        ListNode current2 = list2;
        ListNode result;

        if (current1.val < current2.val) {
            result = current1;
            current1 = current1.next;
        } else {
            result = current2;
            current2 = current2.next;
        }

        ListNode current = result;
        while (current1 != null && current2 != null) {
            if (current1.val < current2.val) {
                current.next = current1;
                current1 = current1.next;
            } else {
                current.next = current2;
                current2 = current2.next;
            }

            current = current.next;
        }

        while (current1 != null) {
            current.next = current1;
            current = current.next;
            current1 = current1.next;
        }

        while (current2 != null) {
            current.next = current2;
            current = current.next;
            current2 = current2.next;
        }

        return result;
    }
}
