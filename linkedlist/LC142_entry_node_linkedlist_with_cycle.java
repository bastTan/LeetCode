
/*
 * math
 * when slow == fast (in the cycle)
 *    a
 * --------.----
 *       c |   | b
 *         ----
 *        s=f    
 * a = n(cycle) + c
 * a = n(b+c) + c
 *
 * - let them meet in the cycle
 * - slow go to head
 * - slow/fast walk together (same speed)
 * - when they meet, slow walks a steps, fast walk n(cycle) + c
 */

public ListNode  startNodeOfCycle (ListNode head) {
    if (head == null || head.next == null) return null;
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    } return null;
}
