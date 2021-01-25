package array;

/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素
 * <p>
 * [1,3,5,6]
 * 5
 * <p>
 */
public class Leet35_searchInsert {
    public static void main(String[] args) {
        int a = 1 / 2;
        System.out.println(a);
    }

    //借助游标法
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[left] < target) {
                left++;
            } else {
                return left;
            }
        }
        return left + 1;
    }

    //二分法
    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = left + (right - left) / 2;
            if (nums[index] > target) {
                right = index - 1;
            } else if (nums[index] < target) {
                left = index + 1;
            } else {
                return index;
            }
        }
        return left;
    }

}
