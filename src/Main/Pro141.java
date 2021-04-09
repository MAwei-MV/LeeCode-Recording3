package Main;

public class Pro141 {
    public boolean hasCycle(ListNode head){
        if(head==null) return false;
        ListNode slow =head;
        ListNode fast=head.next;
        while(fast.next!=null){
            if(slow==fast) return true;
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }
}
