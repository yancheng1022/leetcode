package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * 排序 + 双指针
 */
public class Leet15_ThreeSum {
    public static void main(String[] args) {

        int[] ints = {0, 0, 0};
        List<List<Integer>> lists = threeSum(ints);
        return;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        //双指针
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int result = nums[i] + nums[left] + nums[right];
                if (result > 0) {
                    right--;
                } else if (result < 0) {
                    left++;
                } else {
                    ArrayList<Integer> num = new ArrayList<>();
                    num.add(nums[left]);
                    num.add(nums[right]);
                    num.add(nums[i]);
                    lists.add(num);
                    //进行去重
                    while (left + 1 < len && nums[left] == nums[left + 1]) left++;
                    while (right > i && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                //进行去重
                while (i + 1 < len && nums[i + 1] == nums[i]) i++;
            }
        }
        return lists;
    }
}
