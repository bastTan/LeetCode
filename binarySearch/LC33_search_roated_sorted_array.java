
/*
 * rotated sorted. 4 5 8 9 0 1 2
 * left > right
 * no duplicate
 * return: target index
 *
 * still using binary search
 * if found mid elem == target, return.
 * else we can't just directly go to left or right like before
 *
 * we need to check:
 * 1. which side is monotonically increasing range R
 * 2. if target is within the range R
 *
 * tricky 1: <=, not <
 *  - i.e. [3, 1], then left is still the Range L, need to check
 */

public int searchRotatedArray(int[] arr, int target) {
    if (arr == null || arr.length <= 1) return -1;

    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (arr[mid] == target ) return mid;
        // tricky 1.
        if (arr[left] <= arr[mid]) { // range R on the left
            if (target >= arr[start] && target < arr[mid]) end = mid - 1;
            else                                           start = mid + 1;
        }
        else { // range R on the right
            if (target <= arr[end] && target > arr[mid]) start = mid + 1;
            else                                         end = mid - 1;
        }
    }
    return -;
}
