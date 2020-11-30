package array;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 */
public class Leet189_rotateArray {
    //暴力法：旋转k次，每次旋转一个元素
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
    //如果我们直接把每一个数字放到它最后的位置，但这样的后果是遗失原来的元素。因此，我们需要把被替换的数字保存在变量 temptemp 里面。然后，我们将被替换数字（temptemp）放到它正确的位置，并继续这个过程 nn 次， nn 是数组的长度。这是因为我们需要将数组里所有的元素都移动。但是，这种方法可能会有个问题，如果 n\%k==0n%k==0，其中 k=k\%nk=k%n （因为如果 kk 大于 nn ，移动 kk 次实际上相当于移动 k\%nk%n 次）。这种情况下，我们会发现在没有遍历所有数字的情况下回到出发数字。此时，我们应该从下一个数字开始再重复相同的过程。
    //
    //现在，我们看看上面方法的证明。假设，数组里我们有 nn 个元素并且 kk 是要求移动的次数。更进一步，假设 n\%k=0n%k=0 。第一轮中，所有移动数字的下标 ii 满足 i\%k==0i%k==0 。这是因为我们每跳 kk 步，我们只会到达相距为 kk 个位置下标的数。每一轮，我们都会移动 \frac{n}{k}
    //k
    //n
    //​
    //  个元素。下一轮中，我们会移动满足 i\%k==1i%k==1 的位置的数。这样的轮次会一直持续到我们再次遇到 i\%k==0i%k==0 的地方为止，此时 i=ki=k 。此时在正确位置上的数字共有 k \times \frac{n}{k}=nk×
    //k
    //n
    //​
    // =n 个。因此所有数字都在正确位置上。
    //
    //让我们看一下接下来的例子，以更好地说明这个过程：
}