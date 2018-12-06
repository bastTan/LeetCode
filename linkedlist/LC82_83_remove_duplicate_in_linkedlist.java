
/* 
 * 83. remove duplicate from sorted list such that each element appear only
 * once
 * Input: 1->1->2
 * Output: 1->2
 */

// find dup, keep going, until found non-dup, connect
  public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                next = curr.next;
                while ( next != null && next.val == curr.val) next  = next.next;
                curr.next = next;
            }
            curr = curr.next;
        }
        return head;
    }

// keep remove duplicate 
  public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        while(curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else curr = curr.next;
        }
        return head;
    }

/*
 * 82. remove all nodes that have duplicate
 * Input: 11234
 * output: 234
 */

 public ListNode deleteDuplicateAll(ListNode head) {
     if (head == null || head.next == null) return head;
     ListNode dummy = new ListNode(0);
     dummy.next = head;
     ListNode pre = dummy, curr = pre.next;

     while (curr != null) {
         while (curr.next != null && curr.val == curr.next.val) curr = curr.next;
         // update pre
         // case 1: skipped dup, curr is the last of dup
         if (pre.next != curr)  pre.next = curr.next; // skipped dup
         // case 2: didn't found dup
         else pre = pre.next;
         // preventive programming, curr always check pre's next
         curr = pre.next;
         }
     return dummy.next;
     }
