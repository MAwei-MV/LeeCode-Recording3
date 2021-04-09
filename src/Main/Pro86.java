package Main;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {

    }
}

public class Pro86 {
    public static void main(String args[]) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Pro86 p = new Pro86();
        System.out.println(p.partition(node1, 3));
    }

    public ListNode partition(ListNode head, int x) {
        ListNode tempNode = new ListNode(-1);
        tempNode.next = head;
        ListNode node = tempNode;
        ListNode frontNode = null;
        ListNode newHead = tempNode;
        while (node.next != null) {
            if (node.next.val < x) {
                if (newHead == tempNode) newHead = node.next;
                ListNode t = node.next;
                node.next = node.next.next;
                t.next = tempNode;
                if (frontNode != null) frontNode.next = t;
                frontNode = t;
            } else {
                node = node.next;
            }
        }
        if (newHead == tempNode) return tempNode.next;
        ListNode node2 = newHead;
        while (node.next != null) {
            if (node.next.val == -1) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return newHead;
    }
}
