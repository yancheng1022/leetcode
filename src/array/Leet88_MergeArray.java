package array;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 说明：
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出：[1,2,2,3,5,6]
 */
public class Leet88_MergeArray {
    public static void main(String[] args) {
        new Leet88_MergeArray().merge(new int[]{4, 0, 0, 0, 0, 0}, 1, new int[]{1, 2, 3, 5, 6}, 5);
    }
    // 方法一：先合并 再排序 O((m+n)log(m+n))
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m, j = 0;
        for (i = m; i < m + n; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        // System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
    // 方法二：双指针 O(m+n)

    /**
     * 一般而言，对于有序数组可以通过 双指针法 达到O(n + m)O(n+m)的时间复杂度。
     *
     * 最直接的算法实现是将指针p1 置为 nums1的开头， p2为 nums2的开头，在每一步将最小值放入输出数组中。
     *
     * 由于 nums1 是用于输出的数组，需要将nums1中的前m个元素放在其他地方，也就需要 O(m)O(m) 的空间复杂度。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int temp[] = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);
        while (i < m && j < n) {
            if (temp[i] <= nums2[j]) {
                nums1[k] = temp[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        if (i < m) {
            System.arraycopy(temp, i, nums1, k, m + n - i - j);
        }
        if (j < n) {
            System.arraycopy(nums2, j, nums1, k, m + n - i - j);
        }
    }
}
