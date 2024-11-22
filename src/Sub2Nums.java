class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Sub2Nums {

    public ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int borrow = 0;

        while (l1 != null || l2 != null) {
            // Get the current values or 0 if we run out of digits in either list
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Subtract y and the borrow from x
            int diff = x - y - borrow;

            // If diff is negative, we borrow from the next digit
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            // Store the result digit in the current node
            current.next = new ListNode(diff);
            current = current.next;

            // Move to the next digits
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Remove any leading zeros from the result
        return removeLeadingZeros(dummy.next);
    }

    // Helper function to remove leading zeros from the result list
    private ListNode removeLeadingZeros(ListNode head) {
        while (head != null && head.val == 0) {
            head = head.next;
        }
        return (head == null) ? new ListNode(0) : head;
    }

    public static void main(String[] args) {
        Sub2Nums solution = new Sub2Nums();

        // Example: l1 = [7, 1, 6], l2 = [5, 9, 2]
        ListNode l1 = new ListNode(7, new ListNode(1, new ListNode(6))); // 617
        ListNode l2 = new ListNode(5, new ListNode(9, new ListNode(2))); // 295

        ListNode result = solution.subtractTwoNumbers(l1, l2); // Expected: [2, 2, 3]

        // Print the result
        printList(result);  // Output: 2 -> 2 -> 3
    }

    // Helper function to print the linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
