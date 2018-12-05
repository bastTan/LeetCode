/*
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, 
 * the linked list becomes 1->2->3->5.
 *
 * if (fast-slow) = n, then when fast == null, slow is the nth to the right
 * we need prev of nth to do the deletion
 * so we stop walking at fast.next == null
 */
 public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        for (int i=0; i < n; i++) {
            fast = fast.next;
            if (fast == null) return dummy.next; // less than k
        }
        // walk 1 step less, so that we found n-1 node to do deletion
        // if we walk till fast  == null.
        // slow will be on the exact node that is nth from the end
        // then we can't do delete
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        } // pre node of delete node
        slow.next = slow.next.next;
        return dummy.next;
        
    }
