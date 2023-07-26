package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {

    int[][] temp = null;

    public NumMatrix(int[][] matrix) {
        temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[i][j] = matrix[i][j];
                if (i != 0) temp[i][j] += temp[i - 1][j];
                if (j != 0) temp[i][j] += temp[i][j - 1];
                if (i != 0 && j != 0) temp[i][j] -= temp[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = temp[row2][col2];
        if (row1 != 0) res -= temp[row1 - 1][col2];
        if (col1 != 0) res -= temp[row2][col1 - 1];
        if (row1 != 0 && col1 != 0) res += temp[row1 - 1][col1 - 1];
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
