package Main;

public class Pro19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //快慢指针
        ListNode quick = head;
        while (quick != null && n > 0) {
            quick = quick.next;
            n--;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode slow = newHead;
        while (quick != null) {
            quick = quick.next;
            slow = slow.next;
        }
        if (slow.next == null) {
            return null;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}
