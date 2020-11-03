package dp;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *  
 */
public class Leet509_fib {
    //动态规划
    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        int a[] = new int[10240];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < N; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[N - 1] + a[N - 2];
    }
}
