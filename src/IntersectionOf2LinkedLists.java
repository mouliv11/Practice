public class IntersectionOf2LinkedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode aRunner = headA;
        ListNode bRunner = headB;
        while (aRunner != bRunner) {
            if (aRunner == null) {
                aRunner = headB;
            } else {
                aRunner = aRunner.next;
            }

            if (bRunner == null) {
                bRunner = headA;
            } else {
                bRunner = bRunner.next;
            }
        }
        return aRunner;
    }
}
