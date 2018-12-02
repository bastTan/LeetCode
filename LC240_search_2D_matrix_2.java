
/**
 * 2D matrix such that each col and row is increasing.
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 *  
 * notice that:
 * upper left 1 is the smallest,
 * lower right 30 is the largest,
 *
 * S1. upper right is the median of that row and col such that 
 *   - all the numbers on the left is smaller, 
 *   - all the number below is bigger.
 * lower left is another specail case that can do Binary Search
 *
 * time: O(m+n) ditch 1 col or row at a time. m is cols, n is rows.
 * space: O(1);
 */

public static int[][] search2DMatrix2(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 ||
        matrix[0] == null || matrix[0].length == 0) 
        return new int[] {-1, -1};

    int rows = matrix.length;
    int cols = matrix[0].length;

    // upper right corner
    int row = 0;
    int col = cols - 1;

    while (row < rows && col >= 0) {
        int val = matrix[row][col];
        if (val == target) return new int[] {row, col};
        // target is larger than the largest in that row, 
        // ditch the row
        if (val < target) row++;
        // target smaller than the smallest val in the col, 
        // ditch the col
        else              col--;
    }
    return new int[]{-1, -1};
}

