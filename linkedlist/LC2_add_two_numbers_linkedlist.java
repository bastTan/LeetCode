
// given two non-neg number, reverse order
// add two numbers and return it as a linked list
// i.e.
// given 2->4->3 + 5->6->4
// return 7->0->8
// 342 + 465 = 807

// time: O(max(m, n))
// space: O(max(m, n))
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode dummy = new ListNode(0);
    ListNode d = dummy;
    ListNode c1 = l1, c2 = l2;
    int carry = 0;
    int sum = 0;
    while (c1 != null || c2 != null || carry != 0) {
        sum = carry; // update sum on each round
        if (c1 != null) {
            sum += c1.val;
            c1 = c1.next;
        }
        if (c2 != null) {
            sum += c2.val;
            c2 = c2.next;
        }
        d.next = new ListNode(sum % 10);
        d = d.next;
        carry = sum / 10;
    }
    return dummy.next;
}
