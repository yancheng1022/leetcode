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
        int a = 3 / 2;
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
        //这里不能用nums.length-1（一个元素的时候不会进入while，如果while修改为left<=right，将会变复杂）
        int right = nums.length;
        while (left < right) {
            //避免溢出的情况 假设全都为int型，上限为65535，first=45535，last=20001。则计算mid = (first+last) /2 时会先计算括号里的数得到65536溢出了。而使用mid = first + (last - first) / 2可以避免这种情况而达到相同的效果
            int index = left + (right - left) / 2;
            if (nums[index] >= target) {
                right = index;
            } else {
                //注意这里要+1，用最小的区间，避免出现死循环
                left = index + 1;
            }
        }
        return left;
    }
}
