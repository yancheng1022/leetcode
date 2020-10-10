import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 */
public class Leet18_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //排序
        Arrays.sort(nums);
        //双指针
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = nums[i] + nums[j];
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int result = temp + nums[left] + nums[right];
                    if (result > target) {
                        right--;
                    } else if (result < target) {
                        left++;
                    } else {
                        ArrayList<Integer> num = new ArrayList<>();
                        num.add(nums[left]);
                        num.add(nums[right]);
                        num.add(nums[i]);
                        num.add(nums[j]);
                        lists.add(num);
                        //去重操作
                        while (left + 1 < len && nums[left + 1] == nums[left]) left++;
                        while (right - 1 > 0 && nums[right - 1] == nums[right]) right--;
                        left++;
                        right--;
                    }
                }
                //去重操作
                while (j + 1 < len && nums[j + 1] == nums[j]) j++;
            }
            while (i + 1 < len && nums[i + 1] == nums[i]) i++;
        }
        return lists;
    }
}
