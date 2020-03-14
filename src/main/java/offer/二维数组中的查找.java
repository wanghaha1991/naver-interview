package offer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class 二维数组中的查找 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //行与列
        int row = matrix.length;
        int line = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        while (line < matrix[0].length && row > 0) {
            if (matrix[row - 1][line] == target) {
                return true;
            }
            if (matrix[row - 1][line] > target) {
                row--;
            }else {
                line++;
            }
        }
        return false;
    }
}
