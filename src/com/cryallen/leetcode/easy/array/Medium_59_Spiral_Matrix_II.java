package com.cryallen.leetcode.easy.array;


/***
 * 59. 螺旋矩阵 II
 * @author Allen
 * @DATE 2021-5-28
 ***/
public class Medium_59_Spiral_Matrix_II {
	/**
	 * 59. 螺旋矩阵 II
	 *
	 * <p>
	 * 地址：https://leetcode-cn.com/problems/spiral-matrix-ii/
	 * </p>
	 *
	 * <p>
	 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
	 *
	 * 示例 1:
	 输入: 3
	 输出:
	 [
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	 ]


	 提示：
	 1 <= n <= 20

	 而求解本题依然是要坚持循环不变量原则。

	 模拟顺时针画矩阵的过程:

	 * 填充上行从左到右
	 * 填充右列从上到下
	 * 填充下行从右到左
	 * 填充左列从下到上

	 由外向内一圈一圈这么画下去。
	 这里一圈下来，我们要画每四条边，这四条边怎么画，每画一条边都要坚持一致的左闭右开，或者左开又闭的原则，这样这一圈才能按照统一的规则画下来。


	 */

	public static void main(String[] args) {
		int n = 3;
		int[][] result1 = generateMatrix(n);
		if(result1 != null){
			for (int i = 0; i < n; i++){
				for (int j = 0; j < n; j++){
					System.out.println("result1: " + result1[i][j]);
				}
			}
		}
	}

	/**
	 *
	 * */
	public static int[][] generateMatrix(int n) {
		if(n == 0){
			return null;
		}
		int[][] result = new int[n][n];
		// 循环次数
		int loop = n / 2;

		// 定义每次循环起始位置
		int startX = 0;
		int startY = 0;

		// 定义偏移量
		int offset = 1;

		// 定义填充数字
		int count = 1;

		// 定义中间位置
		int mid = n / 2;

		while (loop > 0) {
			int i = startX;
			int j = startY;

			// 模拟上侧从左到右
			for (; j < startY + n - offset; ++j) {
				result[startX][j] = count++;
			}

			// 模拟右侧从上到下
			for (; i < startX + n - offset; ++i) {
				result[i][j] = count++;
			}

			// 模拟下侧从右到左
			for (; j > startY; j--) {
				result[i][j] = count++;
			}

			// 模拟左侧从下到上
			for (; i > startX; i--) {
				result[i][j] = count++;
			}

			loop--;

			startX += 1;
			startY += 1;

			offset += 2;
		}

		if (n % 2 == 1) {
			result[mid][mid] = count;
		}

		return result;
	}


}
