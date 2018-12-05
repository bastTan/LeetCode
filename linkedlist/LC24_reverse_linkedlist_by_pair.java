
// recursive
public ListNode reverseListByPair(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode curr = head;
    ListNode subHead = reverseListByPair(head.next.next);
    ListNode newHead = curr.next;
    newHead.next = curr;
    curr.next = subHead;
    return newHead;
}

// iteration
// even: 1 -> 2 -> 3 -> 4 -> null
// odd: 1->2->3 ==> 2 ->1 ->3->null
//
// wrong code
// 1 -> 2 -> 3 -> 4 -> null
// 2 -> 1 -> 3 -> 4 -> null
//           4 -> 3
//           3 -> null
//           lost next head 4
//           we need to connect previous 1 -> 4 first 
//           to make sure we get the next head
public ListNode reverseListByPairIter(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode newHead = head.next;
        ListNode nextIter = null;
        while (curr != null && curr.next != null) {
            nextIter = curr.next.next; 
            curr.next.next = curr;  
            curr.next = nextIter; 
            curr = nextIter; 
        }
        return newHead;
    }

public ListNode reverseListByPairIter(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode curr = head;
    ListNode newHead = head.next;
    ListNode lastHead = null; // don't have previous head to make connection yet
    // make sure we have a paire to reverse
    while (curr != null && curr.next != null) {
        // 1 - 2 - 3 - 4
        // 2 - 1 - 3 - 4
        // connect 1 -> 4
        // 1. keep lastHead -> new Head connected
        if (lastHead != null) {
            lastHead.next.next = curr.next;
        }
        // reverse current round
        lastHead = curr.next; // 2
        curr.next = lastHead.next; // 1->3
        lastHead.next = curr; // 2 -> 1
        curr = curr.next; // go to three now
    }
    return newHead;

}


