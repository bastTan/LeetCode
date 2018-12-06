
// head = node 1
// node1 -> 2 -> 3 -> 4 ===> 1 -> 3 -> 2 -> 4
//
// based on node not on val
// space: O(1)

// s1: dummy, not O(1)
public ListNode oddEvenList(ListNode head) {
    ListNode dummy = new ListNode(0);

    ListNode curr = head;
    ListNode odd = new ListNode(0);
    ListNode co = odd;
    ListNode even = new ListNode(0);
    ListNode ce = even;

    while (curr != null && curr.next != null) {
        co.next = curr;
        co = co.next;
        curr = curr.next;
        ce.next = curr;
        ce = ce.next;
        curr = curr.next;
    } // after, co at odd.tail, ce at even.tail
    // IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    ce.next = null;
    co.next = even.next;
    return odd.next;
}

// s2. without dummy, but still two list
public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) return head;
    ListNode h1 = head;
    ListNode h2  = head.next;
    ListNode curr = head.next.next;
    ListNode c1 = h1;
    ListNode c2 = h2;
    while (curr != null && curr.next != null) {
        c1.next = curr;
        c1 = c1.next;
        curr = curr.next;
        c2.next = curr;
        c2 = c2.next;
        curr = curr.next;
    }
    // end list
    if (curr != null) {
        c1.next = curr;
        c1 = c1.next;
    }
    c1.next = h2;
    c2.next = null;
    return h1;
}

// S3. best soln. skip list
   public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode h1 = head;
        ListNode h2 = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
       
        odd.next = h2;
        return head;
    }
