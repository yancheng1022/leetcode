package array;

/**
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 */
public class Leet941_validMountainArray {
    public static void main(String[] args) {
        boolean b = new Leet941_validMountainArray().validMountainArray(new int[]{0,3,2,1});
    }
    //左右指针
    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int left = 0;
        int right = N - 1;
        for (int i = 0; i < N; i++) {
            while (left < i && A[i] > A[left] && A[left] < A[left + 1]) {
                left++;
            }
            if (left == 0 || left != i) {
                left = 0;
                continue;
            }
            while (right > i && A[i] > A[right] && A[right] < A[right - 1]) {
                right--;
            }
            if (right == N-1 || right != i) {
                right = N - 1;
                continue;
            }
            return true;
        }
        return false;
    }
}
