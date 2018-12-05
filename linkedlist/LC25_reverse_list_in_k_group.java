
/*
 * reverse by k-group
 * if not multiple of k,
 * the left out node remain as it is
 *
 * i.e
 * 1->2->3->4->5
 * 3->2->1->4->5
 */

// reverse 1 -> k iterative, then recursive
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode curr = head;
    int count = 0;

    // find k+1 node
    while (curr != null && count != k) {
        curr = curr.next;
        count++;
    } // after while loop, count == k, curr at k+1 node

    // make sure node end while because we hit the end 
    if (count == k)  {
        // recursive do k+1
        ListNode subHead = reverseKGroup(curr, k);
        // iterative do 0 - k
        //
        // head = head of iter part, 0 - k
        // subHead = head of reversed part, k+1 - ...
        // 1 -> 2 -> 3
        // < -1 <- 2
        while (count-- > 0) {
            ListNode next = head.next;
            head.next = subHead; // subHead is the pre
            subHead = head;
            head = next;
        }
        // after iteration, subHead = pre, the return head of reversed k list
        head = subHead; // if we do k+1 part, update head, else keep the same
    }
    return head; 
}
