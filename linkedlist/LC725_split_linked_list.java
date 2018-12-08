//
// input: 1 -> 2 -> 3 -> 4, k = 5
// output: [1] [2] [3] [4] []
// input: [1, 2, 3, 4, 5], k = 2
// output: [1, 2, 3][4, 5]
//
// special case: 
// intput: null; k = 3
// return ListNode[[], [], []];
//
// The length of each part should be as equal as possible: 
// no two parts should have a size differing by more than 1. 
// This may lead to some parts being null.
//
   public ListNode[] splitListToParts(ListNode root, int k) {
        // if (root == null) return null;
        ListNode[] chunks = new ListNode[k];
        int len = getLen(root);
        int chunkSize = len / k;
        // fill reminder evenly to previous cells
        int stopIndex = len % k;

        ListNode curr = root;
        for (int i=0; i < k; i++) {
            ListNode dummy = new ListNode(0), d = dummy;
            for (int j=0; j < chunkSize + (i < stopIndex? 1 : 0); j++) {
                
                d.next = new ListNode(curr.val);
                d = d.next;
                if (curr != null) curr = curr.next;
            }
            chunks[i] = dummy.next;
        }
        return chunks;
    }

    public int getLen(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        return len;
    }
