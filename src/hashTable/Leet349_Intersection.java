package hashTable;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给定两个数组，编写一个函数来计算它们的交集
 *
 */
public class Leet349_Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).filter(set::contains).distinct().toArray();
    }

    public static void main(String[] args) {
        String[] a  = new String[]{"ab","bc"};
        boolean result = Arrays.stream(a).anyMatch("ab"::equals);
    }
}
