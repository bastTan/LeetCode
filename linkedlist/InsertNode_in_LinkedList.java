
// S1. dummy  < val
// return head;
public ListNode inserteNodeWithDummy(ListNode head, int val) {
    ListNode newNode = new ListNode(val);
    ListNode dummy = new ListNode(val-1);
    dummy.next = head;

    ListNode pre = dummy;
    while (pre.next != null && pre.next.val < val) {
        pre = pre.next;
    }
    newNode.next = pre.
    pre.next = newNode;
    return dummy.next;
}

// S2. without dummy, ensure head corner case

public ListNode insertNodeWithoutDummy(ListNode head, int val) {
    ListNode node = new ListNode(val);

    // corner, new node is head
    if (head == null || val < head.val) {
        node.next = head;
        return node;
    }

    // find insertion point
    ListNode pre = head;
    while (pre.next != null && pre.next.val < val) {
        pre = pre.next;
    }

    // insert
    node.next = pre.next;
    pre.next = node;

    return head;
}
