
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
    while (curr != null && count < k) { 
        // if the non-multiple-of k part need also reverse, 
        // we can reverse while finding k+1
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

// do k reverse while tranverse, then recurse, 
// less than k part still remain sill
public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null || getlen(head) < k) return head;
    ListNode prev = null, curr = head, next = null;
    int cnt = 0;
    while(curr != null & cnt < k) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        cnt++;
    } // curr at k+1
    head.next = reverseKGroup(curr, k);
    return prev;
}

public int getlen(ListNode head) {
    if (head == null) return 0;
    ListNode curr = head;
    int cnt = 0;
    while (curr != null) {
        cnt++;
        curr = curr.next;
    }
    return cnt;
}
