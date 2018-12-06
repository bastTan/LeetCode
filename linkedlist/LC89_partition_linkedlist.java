/* Given a linked list and a value x, 
 * partition it such that 
 *  - all nodes less than x come before 
 *  - nodes greater than or equal to x.
 *  preserve the original relative order of the nodes(no swap)
 *
 *  i.e
 *  Input: head = 1->4->3->2->5->2, x = 3
 *  Output: 1->2->2->4->3->5
 */

public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null) return head;

    ListNode curr = head;
    ListNode dummyLess = new ListNode(-1);
    ListNode dummyLarger = new ListNode(0);
    ListNode currLess = dummyLess;
    ListNode currLarger = dummyLarger;

    while (curr != null) {
        if (curr.val < x) {
            currLess.next = curr;
            currLess = currLess.next;
        } else {
            currLarger.next = curr;
            currLarger = currLarger.next;
        }
        curr = curr.next;
    }
    currLarger.next = null;
    currLess.next = dummyLarger;
    return dummyLess.next;
}
