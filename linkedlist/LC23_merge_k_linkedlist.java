
// helper
// --------------------------------------------------------------------------------
private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode d = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            d.next = l1;
            l1 = l1.next;
        } else {
            d.next = l2; 
            l2 = l2.next;
        }
        d = d.next;
    }
    if (l1 != null) d.next = l1;
    if (l2 != null) d.next = l2;
    return dummy.next;
}
// S1.
// combine a + b = ab, then combine ab + c = abc, 
// merge 2 at a time 
//
// assume each list has m nodes.
// we need to merge k list
// n = k * m (total nodes)
//
// combine 2: O(2m)
// combine 3: O(3m)
// ...
// k-1 and k: O(km)
// T = O(k^2 * m) = (k * K *m) = (k * total);
public ListNode mergeKSortedListOneByOne(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    ListNode result = null;
    for (ListNode list : lists) {
        result = mergeTwoSortedLists(result, list);
    }
    return result;
}
//
// S2. since its sorted, we can check each first node at a time
// we have k list, so for each round, we check k tims to find min.
// time: O(kn) 
//
// S2+. use minHeap to store min of K (first node)
//--------------------------------------------------------------------------------
// then getMIn = O(1), but insert is logK
// each logK we can set one node, total n node.
// so time = O(nlogk)
// space = O(k)
public ListNode mergeKSortedListWithHeap(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    Queue<ListNode> minQueue = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode list: lists) {
        if (list != null) { // might give [[], [1, 2]]
            minQueue.add(list);
        }
    }
    ListNode dummy = new ListNode(0), d = dummy;
    while (!minQueue.isEmpty()) {
        ListNode min = minQueue.poll();
        d.next = min;
        d = d.next;
        if (min.next != null) minQueue.add(min.next);
    }
    return dummy.next;
}

//
// S3. recursion, divide and conquer
//--------------------------------------------------------------------------------
// a1 a2 a3 a4 ... ak
//   b1   b2    
//      c1  
// logK(level), each time tranverse whole nodes n.
// time: O(nlognk)
// space: O(logK)

public ListNode mergeKList(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    return mergeHelper(lists, 0, lists.length - 1);
}

private ListNode mergeHelper(ListNode[] lists, int start, int end) {
    if (start == end) // only one list remain
            return lists[start];
    if (start > end) return null;
    int mid = start + (end - start) / 2;
    ListNode left = mergeHelper(lists, start, mid);
    ListNode right = mergeHelper(lists, mid+1, end);
    return mergeTwoSortedLists(left, right);
}
