package dp;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 */
public class Leet343_IntegerBreak {
    int[] array = new int[10000];

    /**
     * 递归解法：
     * 将问题划分子问题： 1+...(n-1)  2+...(n-2)
     * 分别计算每个子问题得到的结果res
     * 为了性能问题，中间过程计算得到的integerBreak(XX)的值就不需要再计算了，使用记忆化搜索
     *
     * @param n
     * @return
     */
    public int integerBreak1(int n) {
        if (n == 1) array[n] = 1;
        //记忆化搜索 记录中间结果的值
        if (array[n] != 0) return array[n];
        int res = -1;
        for (int i = 1; i < n; i++) {
            //注意：并不一定时完全拆分，所以还要考虑i*(n-i)这种不拆分的情况
            res = Math.max(i * (n - i), Math.max(res, i * integerBreak1(n - i)));
            array[n] = res;
        }
        return res;
    }

    /**
     * 动态规划解法
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] array = new int[n + 1];
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            //求解array[i]
            for (int j = 1; j < i; j++) {
                //j+(i-j)
                array[i] = Math.max(array[i], Math.max(j * (i - j), j * array[i - j]));
            }
        }
        return array[n];
    }
}
