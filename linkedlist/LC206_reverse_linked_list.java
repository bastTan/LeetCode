
// iteration
public ListNode reverseListIter(ListNode head) {
    if (head == null || head.next == null) return head;

    // 1 -> 3 -> 5
    // 1 <- 3 <- 5
    ListNode curr = head;
    ListNode pre = null, next  = null;
    while (curr != null) {
        next = curr.next; 
        curr.next = pre;
        pre = curr;
        curr = next;
    }
}

// recursion
// recurse first
// then do
// right to left
public ListNode reverseListRec(ListNode head) {
    if (head == null || head.next == null) return head;

    // 1 -> 2 -> 3
    ListNode curr = head;
    ListNode newHead = reverseListRec(head.next);
    curr.next.next = curr;
    curr.next = null;
    return newHead;
}

// reverse linkedlist might has cycle
//--------------------------------------------------------------------------------
// use node.visited field
public ListNode reverseListIter(ListNode head) {
    if (head == null || head.next == null) return head;

    // 1 -> 3 -> 5
    // 1 <- 3 <- 5
    ListNode curr = head;
    ListNode pre = null, next  = null;
    while (!curr.visited) {
        curr.visited = true;
        next = curr.next; 
        curr.next = pre;
        pre = curr;
        curr = next;
    }
}
// use hashSet
public ListNode reverseListIter(ListNode head) {
    if (head == null || head.next == null) return head;
    Set<ListNode> visited = new HashSet<>();
    // 1 -> 3 -> 5
    // 1 <- 3 <- 5
    ListNode curr = head;
    ListNode pre = null, next  = null;
    while (!visited.contains(curr)) {
        visited.add(curr);
        next = curr.next; 
        curr.next = pre;
        pre = curr;
        curr = next;
    }
}
