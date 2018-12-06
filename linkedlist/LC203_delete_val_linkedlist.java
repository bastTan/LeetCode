
/**remove ALL elements from a linked list of integers that have value val.
 * may have multiple val.
 * s1. pre, curr, change pointer, with dummy
 * s2. s1 without dummy, pre processing
 * s3. delete by shift value, 
 * need careful when we have different container ref.
 */

// s1
public ListNode removeElementsWithDummy(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        
        while (p.next != null) {
            if (p.next.val == val) p.next = p.next.next;
            else p = p.next;
        }
      return dummy.next;
    }

// without dummy
// head is special case, and we need pre, 
// so let's directly go from head.next
public ListNode removeElements(ListNode head, int val) {
    if (head == null) return null;

    ListNode curr = head;
    while (curr.next != null) {
        if (curr.next.val == val) curr.next = curr.next.next;
        else curr = curr.next;
    }
    return head.val == val? head.next : head;
}

// skip all leading val first then start
// solution from discussion
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null)
            if (curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
        return head;
    }
}
