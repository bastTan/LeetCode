
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
// insert one node each time,
// growing a sorted output list
// time: O(n^2)
//
// In reality, best to copy it to an array and sort
public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode curr = head; // the node will be inserted
    ListNode dummy = new ListNode(0);
    ListNode pre = dummy; // insert at pre.next
    ListNode next = null;

    while (curr != null) {
        next = curr.next;
        // find insersion point
        while (pre.next != null && pre.next.val < curr.val) {
            pre = pre.next;
        } // found insertion place
        curr.next = pre.next;
        pre.next = curr;
        curr = next; // check next input node
        pre = dummy; // reset pre, ready for next insertion scan;
    }
    return dummy.next;
}
