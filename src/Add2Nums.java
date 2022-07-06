public class Add2Nums {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while(p != null || q != null) {
            int x = p!=null ? p.val: 0;
            int y = q!=null ? q.val: 0;
            int sum = x + y + carry;
            carry = sum/10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0)
            curr.next = new ListNode(carry);
        return dummyHead.next;
    }

    public static void main(String args[]) {
        Add2Nums a = new Add2Nums();
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode p1 = new ListNode(5);
        ListNode p2 = new ListNode(6);
        ListNode p3 = new ListNode(4);
        p1.next = p2;
        p2.next = p3;
        a.addTwoNumbers(l1, p1);
    }
}
