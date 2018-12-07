// S1: 
// use two pointer
// dummy for carry;
// lastNoneNine point to the last non nine number, + 1
// everything after that, if still exist, changed to 0;
 public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastNoneNine = dummy;
        ListNode curr = dummy;
        while (curr.next != null) {
            curr = curr.next;
            if (curr.val != 9) lastNoneNine = curr;
            
        }
        lastNoneNine.val++;
        while (lastNoneNine.next != null) {
            lastNoneNine = lastNoneNine.next;
            lastNoneNine.val = 0;   
        }
        return dummy.val != 0? dummy : head;
    }

// S2: use reversion
// if node is null, return 1, mimic + 1
public ListNode plusOne(ListNode head) {
    if (plusOneHelper(head) == 0) {
        return head; // no carry
    }
    ListNode newHead = new ListNode(1);
    newHead.next = head;
    return newHead;
}

private int plusOneHelper(ListNode node){
    if (node == null) return 1;
    int val = node.val + plusOneHelper(node.next);
    node.val = val % 10;
    return val / 10;
}

// S3. reverse, +1, reverse // TODO

public ListNode plusOne(ListNode head) {
        // Reverse linkedlist
        ListNode newhead = reverse(head);
        ListNode cur = newhead;
        cur.val = cur.val + 1;
        while(cur.val > 9) {
            cur.val = 0;
            if(cur.next == null) cur.next = new ListNode(0);
            cur = cur.next;
            cur.val += 1;
        }
        
        return reverse(newhead);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode newHead = reverse(head.next);
        curr.next.next = curr;
        curr.next = null;
        return newHead;
        
    }
