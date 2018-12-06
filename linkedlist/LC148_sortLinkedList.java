
// quicksort
// time: O(nlogn)
// space: O(1)

// sort [start, end)

// <pivot, f
// if f.val > pivot, keep moving

public ListNode quickSortList(ListNode head) {
    quickSortList(head, null);
    return head;
}

private void quickSort(ListNode head, ListNode end) {
    if (head == end || head.next == end) return;
    int pivot = head.val;
    ListNode slow = head, fast = head.next;
    while (fast != end) {
        if (fast.val <= pivot) {
            slow = slow.next; // point to a > pivot node
            swap(slow, fast);
        }
        fast = fast.next;
    }
    swap(head, slow); 
    quickSort(head, slow)
    quickSort(slow.next, end);
}
// given two node, swap their value
public void swap(Listnode node1, Listnode node2) {
    int val = node1.val;
    node1.val = node2.val;
    node2.val = val;
}

// --------------------------------------------------------------------------------
// Merge sort, better than using array when merge
// make sure we return the head;

public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode leftEnd = middleNode(head);
    ListNode right = mergeSort(leftEnd.next);
    leftEnd.next = null; // IMPORTANT!!!!!!!!
    ListNode left = mergeSort(head);
    return mergeLists(left, right);
}

public ListNode mergeLists(ListNode l1, ListNode l2) {
    // with dummy we do not need corner anymore
    // if (l1 == null) return l2;
    // if (l2 == null) return l1;

    ListNode dummy = new ListNode(0);
    ListNode p = dummy;
    ListNode c1 = l1, c2 = l2; // keep the original node

    while (c1 != null && c2 != null) {
        if (c1.val <= c2.val) {
            p.next = c1;
            c1 = c1.next;
        } else {
            p.next = c2;
            c2 = c2.next;
        }
        p = p.next;
    }
    if (c1 == null) p.next = c2;
    if (c2 == null) p.next = c1;
    return dummy.next;

}

public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) return null;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
