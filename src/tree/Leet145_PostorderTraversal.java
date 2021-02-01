package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后续遍历
 */
public class Leet145_PostorderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null && root.left == null && root.right == null) return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }
}
