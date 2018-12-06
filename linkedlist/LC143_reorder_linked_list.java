
//
// Given 1->2->3->4, reorder it to 1->4->2->3.
//  - 1->2   midlle = 2
//  - 3->4 => 4->3
//
// Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
// - 1->2->3 middle = 3
// - 4->5 => 5->4
// 
public void reorderList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) return;

    ListNode leftEnd = findMiddle(head);
    ListNode rightStart = leftEnd.next;
    leftEnd.next = null;
    pairMerge(head, reverseIter(rightStart));
}

public ListNode findMiddle(ListNode head) {
    if (head == null) return head;
    ListNode slow = fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

public ListNode reverseRec(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode curr = head;
    ListNode newHead = reverseRec(curr.next);
    curr.next.next = curr;
    curr.next = null;
    return newHead;
}

public ListNode reverseIter(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode curr = head, pre = next = null;
    while (curr != null) {
        next = curr.next;
        curr.next = pre;
        pre = curr;
        curr = next;
    }
    return pre;
}

// after merge, head == l1
public void pairMerge(ListNode l1, ListNode l2) {
    if (l1 == null) l1 = l2;
    if (l2 == null) return; 

    ListNode c1 = l1, c2 = l2;
    while (c1 != null) {
        ListNode next = c1.next;
        c1.next = c2;
        c1 = c1.next;
        c2 = next;
    }
}

private ListNode pairMergeWithDummy(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    ListNode c1 = l1, c2 = l2;
    while (c1 != null && c2 != null) {
        curr.next = c1;
        c1 = c1.next;
        curr = curr.next;
        curr.next = c2;
        c2 = c2.next;
        curr = curr.next
    }
    if (c1 != null) curr.next = c1;
    if (c2 != null) curr.next = c2;
    return dummy.next;
}
