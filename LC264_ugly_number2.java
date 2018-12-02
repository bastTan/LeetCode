
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
            // uglyNumber can grow very fast, need to be check
            // 2L means after multiply it will be long
            if (2L * uglyNum <= Integer.MAX_VALUE) minHeap.add(2 * uglyNum);
            if (3L * uglyNum <= Integer.MAX_VALUE) minHeap.add(3 * uglyNum);
            if (5L * uglyNum <= Integer.MAX_VALUE) minHeap.add(5 * uglyNum);
         
        }
           return uglyNum;
        
    }

/* S2. maintain three candidates only.
 * p2, p3, p5 for indicating which number to time which factor 
 * only get minimum from these three ptrs. 
 *
 * time: O(n) | each time need O(1) to find min, need N times
 * space: O(n) | need a helper array to same all ugly number
 */
private int min(int a, int b, int c) {
    return Math.min(a, Math.min(b, c));
}

public int nthUglyNumberDP(int n) {
    // arg check
    if (n <= 0) throw new IllegalArgumentException();

    int[] uglyNums = new int[n];
    uglyNums[0] = 1;
    int p2 = 0, p3 = 0, p5 = 0;

    for (int i=1; i < n; i++) {
        int min = min(uglyNums[p2] * 2, 
                      uglyNums[p3] * 3, 
                      uglyNums[p5] * 5);
        uglyNums[i] = min;
        if (min == uglyNums[p2] * 2) p2++;
        if (min == uglyNums[p3] * 3) p3++;
        if (min == uglyNums[p5] * 5) p5++;
    }

    return uglyNums[n-1];
}
