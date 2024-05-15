package com.cryallen.leetcode.easy.leet;

/**
 * @author : RanChen@cariad-technology.cn
 * @package : com.cryallen.leetcode.easy.leet
 * @date ： 2024/5/15 15:42
 * Description ：Medium_200_Number_Of_Islands
 * project ：LearnDataAlgo
 * dep : TT-32
 * company: CARIAD (China) Co., Ltd.
 * version: V1.0.0
 */
public class Medium_200_Number_Of_Islands {

    /**
     * 200. 岛屿数量
     * <p>
     * 地址：https://leetcode.cn/problems/number-of-islands/description/
     * </p>
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     示例 1：

     输入：grid = [
     ["1","1","1","1","0"],
     ["1","1","0","1","0"],
     ["1","1","0","0","0"],
     ["0","0","0","0","0"]
     ]
     输出：1
     示例 2：

     输入：grid = [
     ["1","1","0","0","0"],
     ["1","1","0","0","0"],
     ["0","0","1","0","0"],
     ["0","0","0","1","1"]
     ]
     输出：3


     提示：

     m == grid.length
     n == grid[i].length
     1 <= m, n <= 300
     grid[i][j] 的值为 '0' 或 '1'
     *
     *
     * */

    public static void main(String[] args) {

    }

    private char[][] grid;
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    ++ans;
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j) {
        grid[i][j] = '0';
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k];
            int y = j + dirs[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                dfs(x, y);
            }
        }
    }
}
