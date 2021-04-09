package Main;

public class Pro24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode node = newHead;
        while (node.next != null) {
            if (node.next.next == null) break;
            ListNode preNode = node.next;
            node.next = preNode.next;
            preNode.next = node.next.next;
            node.next.next = preNode;
            node = preNode;
        }
        return newHead.next;
    }
}
