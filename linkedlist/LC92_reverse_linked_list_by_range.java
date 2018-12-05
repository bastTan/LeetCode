
/*
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
 *
 * Input: 1  ->  <- 2    <-   3   <-   4    5 ->    null
 *                                     pre    
 *        preH
 *                                            curr       
 *                currH
 *
 *                                             post
 *        m = 2, n = 4
 * Output: 1-> 4 -> 3 -> 2 -> 5 -> null
 *
 */
public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null || head.next == null || m == n) return head;
    // use dummy so that we have index 0 counted. match with m, n
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;

    // find m-1
    for (int i = 0; i < m-1; i++) pre = pre.next;

    ListNode preHead = pre;
    ListNode curr = pre.next;
    ListNode currHead = curr;
    ListNode next;

    for (int i=0; i < n-m+1; i++) {
        next = curr.next;
        curr.next = pre;
        pre = curr;
        curr = next;
    }
    preHead.next = pre;
    currHead.next = curr;
    return dummy.next;  // can't return
}

// test case: 3->4 ===> 4->3 TODO, how to walk through
