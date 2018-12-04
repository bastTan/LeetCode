
/*
 * given
 *   nums1 = [1, 2, 5, 7] m = 4
 *   nums2 = [3, 7, 8, 10] n = 4
 *  return median
 *  require time O(log(m+n))
 *
 *  total m+n = T size
 *  let f(k) = the k'th smallest number in a sorted array contains nums1, nums2
 *  then median is
 *      - if T is even, (f(T/2) + f(T/2)+1) / 2
 *      - if T is odd, f(T/2+1)
 *
 * find f(4) first
 * find first 4/2 elem in nums1, and nums2 => [1, 2], [3, 7]
 * compare the largest, 
 * since we get total k numbers, 
 * if we compare 2 and 7, 2 < 7. 
 * the f(k) can not be in range [1, 2], drop that  part
 * each round we get shrink the size of the qs by k/2
 *
 * k < m+n for sure, so time requirement is meet.
 *
 */

public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int total = nums.lenth + nums2.length;
    // check if odd
    if ((total & 1) == 1) {
        return findKthSmallestInSortedArrays(nums1, nums2, total/2 + 1);
    } else {
        double left = findKthSmallestInSortedArrays(nums1, nums2, total/2);
        double right = findKthSmallestInSortedArrays(nums1, nums2, total/2 + 1);
        return (left+right) / 2;
    }
}

// 1 2 6 7 8
// 3 4 5 7 9
public double findKthSmallestInSortedArrays(int[] nums1, int[] nums2, int k) {
    int len1 = nums1.length, len2 = nums2.length, base1 = 0; base2 = 0;
    while (true) {
        if (len1 == 0) return nums2[base2 + k - 1];
        if (len2 == 0) return nums2[base1 + k - 1];
        if (k == 1) return Math.min(nums1[base1], nums2[base2]);

        int i = Math.min(k/2, len1);
        int j = Math.min(k-i, len2);
    
        int a = nums1[base1 + i - 1], b = nums2[base2 + j - 1];
        if ( i + j == k && a == b ) return a;

        // if i+j < k, then both parts can be drop
        if (a <= b) {
            base1 += i;
            len1 -= i;
            k -= i;
        }
        if (a >= b) {
            base2 += j;
            len2 -= j;
            k -= j;
        }
}
