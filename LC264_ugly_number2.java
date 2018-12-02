
/*
 * find nth ugly number
 * 1, 2, 3, 4, 5, 6, 8, 9, 10
 *
 */

/* S1.maintain a minHeap.
 * time: O(nlogn)
 * space: O(n)
 */
 public int nthUglyNumber(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        int uglyNum = -1;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); 
        minHeap.add(1);
        while (n > 0) {
            while (minHeap.peek() == uglyNum) minHeap.poll(); // delete duplicate min values;
            uglyNum = minHeap.poll(); // get current minimum;
            n--;
            if (2L * uglyNum <= Integer.MAX_VALUE) minHeap.add(2 * uglyNum);
            if (3L * uglyNum <= Integer.MAX_VALUE) minHeap.add(3 * uglyNum);
            if (5L * uglyNum <= Integer.MAX_VALUE) minHeap.add(5 * uglyNum);
         
        }
           return uglyNum;
        
    }
