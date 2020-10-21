package array;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 */
public class Leet66_PlusOne {
    public static void main(String[] args) {
        int[] ints = {0};
        new Leet66_PlusOne().plusOne(ints);
    }

    //我的愚蠢解法  发现数组长度一旦变大我就gg了
    public int[] plusOne1(int[] digits) {
        int len = digits.length;
        double value = 0;
        int index = 0;
        for (int i = len - 1; i >= 0; i--) {
            value += digits[i] * Math.pow(10, index);
            index++;
        }
        double temp = value + 1;
        String str = String.valueOf(temp);
        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return result;
    }

    /**
     * @param digits
     * @return 1.为9时向前进一位，该位变0
     * 2.非9时直接加1
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i]%10;
            if (digits[i] != 0) return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
