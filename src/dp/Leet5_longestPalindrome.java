package dp;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class Leet5_longestPalindrome {
    public static void main(String[] args) {
        String a = "cbbd";
        String s = new Leet5_longestPalindrome().longestPalindrome(a);
    }

    /*
     *   dp
     *   状态转移方程：dp[i][j] = dp[i+1][j-1} && s.charat(i) == s.charat(j)
     *   i,j代表 字符串s中的位置i和位置j
     */
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String result = "";
        int n = s.length();
        //依次遍历长度为0,1...n的子字符串
        for (int len = 0; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = s.charAt(i) == s.charAt(j);
                if (len > 1) {
                    dp[i][j] = dp[i + 1][j - 1] && dp[i][j];
                }
                if (dp[i][j] && j - i + 1 > result.length()) {
                    result = s.substring(i, len + i + 1);
                }
            }
        }
        return result;
    }
}
