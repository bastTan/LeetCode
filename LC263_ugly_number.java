/*
 * check if a number is an ugly number.
 *
 * ugly numbers are
 *  - positive
 *  - prime factors only contains 2, 3, 5
 */

class Solution {
    // time: O(m+n+l), m, n, l is the number of 2, 3, 5 in the number
    // space: O(1);
    public boolean isUgly(int num) {
        if (num <= 0 ) return false;
        while (num % 2 == 0) num >>= 1;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        
        return num == 1;
        
    }
}
