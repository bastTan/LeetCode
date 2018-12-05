
// s1, if node has been visited, or in the set, true
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    Set<ListNode> visited = new HashSet<>();

    for (ListNode curr = head; curr != null; curr = curr.next) {
        if (visited.contains(curr)) return true;
        visited.add(curr); // add before change curr
    }
    return false;
}
// s2. if has cycle, slow, fast will meet in the cycle
// s2.1 if slow = fast = head, walk first then check
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    ListNode slow = head, fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}
// s2.2 if slow + 1 = fast, check first then walk
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    ListNode slow = head, fast = head.next;
    
    while (fast != null && fast.next != null) {
        if (slow == fast) return true;
        slow = slow.next;
        fast = fast.next.next;
    }
    return false;
}
