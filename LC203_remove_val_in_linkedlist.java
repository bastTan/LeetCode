
// remove ALL elements from a linked list of integers that have value val.
//
// Input:  1->2->6->3->4->5->6, val = 6
// Output: 1->2->3->4->5
//
// head is special case, and we need pre, 
// so let's directly go from head.next

public ListNode removeElements(ListNode head, int val) {
    if (head == null) return null;

    ListNode curr = head;
    while (curr.next != null) {
        if (curr.next.val == val) curr.next = curr.next.next;
        else curr = curr.next;
    }
    return head.val == val? head.next : head;
}

// or we can use dummy node to exclude the special case for head

public ListNode removeElementsDummy(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode p = dummy;

    while (p.next != null) {
        if (p.next.val == val) p.next = p.next.next;
        else p = p.next;
    }
    return dummy.next;
}
