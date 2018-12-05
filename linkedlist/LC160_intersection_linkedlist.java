
//          a
// A:     1 -> 2
//             \     b
//               6 -> 7 -> null
//              /
// B: 3 -> 4 -> 5
//       c
//
// s1. find duplicate, space O(N)
// a. visited
// b. HashSet
//
// s2. with len. find difference, find same start point, walk together 
// Space: O(1)
public ListNode getIntersectionWithLen(ListNode head1, ListNode head2) {
    if (head1 == null || head2 == null) return null;

    int len1 = getLen(head1);
    int len2 = getLen(head2);
    ListNode curr1 = head1, curr2 = head2;

    // cut difference
    if (len1 > len2) {
        for (int i = 0; i < len1 - len2; i++) curr1 = curr1.next;
    } else {
        for (int i = 0; i < len2 - len1; i++) curr2 = curr2.next;
    }
    while (curr1 != curr2) {
        curr1 = curr1.next;
        curr2 = curr2.next;
    }
    return curr1;
}

public int getLen(ListNode head) {
    if (head == null) return -1;
    int len = 0;
    ListNode curr = head;
    while (curr != null) {
        len++;
        curr = curr.next;
    }
    return len;
}

// s3. a + b + c = c + b + a

public ListNode getIntersectionWithOutLen(ListNode head1, ListNode head2) {
    if (head1 == null || head2 == null) return null;
    ListNode c1 = head1, c2 = head2;
    while (c1 != c2) {
        c1 = c1 == null? head2 : c1.next;
        c2 = c2 == null? head1 : c2.next;
    }
    return c1;
}

public ListNode getIntersectionWithOutLen(ListNode head1, ListNode head2) {
    if (head1 == null || head2 == null) return null;
    ListNode c1 = head1, c2 = head2;
    while (c1 != c2) {
        if (c1 != null) c1 = c1.next;
        else c1 = head2;
    }
    return c1;
}
