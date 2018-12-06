
// given: if len == even, return the second middle
public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) return head;
            
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

// given: if len == even, return the first middle
// previous sln, slow walks one more
//
// we can use dummy node
// slow = dummy
// fast = head
//
// or,
// check fast.next.next != null

public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) return head;
            
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
