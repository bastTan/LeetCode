
/*
 * given a single linkedlist. i.e. 1->2->3->2->1
 * 
 * time: O(n) has to go through the list anyway. threashold is O(n)
 * 
 * S1. use an extra stack to hold every node, then compare list and stack
 * Space: O(n) for the extra stack
 *
 * S2. reverse half of the linkedlist; then from middle node, go to two dir to
 * compare
 * Space: O(1)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public boolean isPalindromeUsingStack(ListNode head) {
    if (head == null || head.next == null) return true;

    Stack<Integer> reverse = new Stack<>();
    ListNode curr = head;
    while (curr != null) {
        reverse.push(curr.val);
        curr = curr.next;
    }
    curr = head;
    while (curr != null) {
        if (curr.val != reverse.pop()) return false;
        curr = curr.next;
    }
    return true;
}

public boolean isPalindromeReverseList(ListNode head) {
    int len = 0;
    ListNode curr = head;
    // get list length
    while (curr != null) {
        len++;
        curr = curr.next;
    }

    ListNode pre = null;
    curr = head;
    for (int i=0; i < len/2; i++) {
        ListNode next = curr.next;
        curr.next = pre;
        pre = curr;
        curr = next;
    }

    // 1<-2->3->2->1
    //    p  c      
    // odd length list need to skip the middle node
    if (len % 2 == 1) curr = curr.next;
    while (pre != null && curr != null) {
        if (pre.val != curr.val) return false;
        pre = pre.next;
        curr = curr.next;
    }
    return true;
}

