package dp;

import java.util.ArrayList;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 分析：划分子问题  最后一次爬1阶（从n-1爬）和爬2阶（从n-2爬）
 */
public class Leet70_ClimbStairs {
    public static void main(String[] args) {
        new Leet70_ClimbStairs().climbStairs(2);
    }

    //有性能问题，会有重复计算的情况
    public int climbStairs1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    int[] array = new int[10000];

    //记忆化搜索
    public int climbStairs2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (array[n] != -1) {
            array[n] = climbStairs2(n - 1) + climbStairs2(n - 2);
        }
        return array[n];
    }

    //动态规划算法
    public int climbStairs(int n) {
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

}
