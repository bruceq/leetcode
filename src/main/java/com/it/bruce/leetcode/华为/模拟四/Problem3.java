package com.it.bruce.leetcode.华为.模拟四;

import com.it.bruce.leetcode.华为.模拟一.Problem;
import sun.java2d.opengl.OGLRenderQueue;

/**
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 * <p>
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * <p>
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,0],[0,1]]
 * 输出：0
 * 解释：没有一台服务器能与其他服务器进行通信。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,0],[1,1]]
 * 输出：3
 * 解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * 输出：4
 * 解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 250
 * 1 <= n <= 250
 * grid[i][j] == 0 or 1
 */
public class Problem3 {
    public static void main(String[] args) {
        Problem3 main = new Problem3();
        int[][] grid = {
                {1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0}
        };
        System.out.println(main.countServers(grid));
    }

    public int countServers(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    boolean visited = false;
                    for (int j1 = 0; j1 < grid[0].length; j1++) {
                        if (j1 != j && grid[i][j1] == 1) {
                            count++;
                            visited = true;
                            break;
                        }
                    }
                    if(!visited){
                        for (int i1 = 0; i1 < grid.length; i1++) {
                            if (i1 != i && grid[i1][j] == 1) {
                                count++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
