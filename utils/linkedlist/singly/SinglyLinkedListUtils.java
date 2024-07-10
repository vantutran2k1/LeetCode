package utils.linkedlist.singly;

public class SinglyLinkedListUtils {
    public static ListNode build(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static boolean equals(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null)
            return true;

        if (head1 == null || head2 == null)
            return false;

        ListNode current1 = head1;
        ListNode current2 = head2;
        while (current1 != null && current2 != null) {
            if (current1.val != current2.val)
                return false;

            current1 = current1.next;
            current2 = current2.next;
        }

        return current1 == null && current2 == null;
    }

    public static void print(ListNode head) {
        ListNode temp = head;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
            if (temp != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
