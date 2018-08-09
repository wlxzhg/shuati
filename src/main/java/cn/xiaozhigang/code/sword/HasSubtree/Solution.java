package cn.xiaozhigang.code.sword.HasSubtree;

public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean flag = false;

        if(root1 != null && root2 != null) {
            if(root1.val == root2.val) {
                flag = DoesTree1HasTree2(root1,root2);
            }
            if(!flag)
                flag = HasSubtree(root1.left,root2);
            if(!flag)
                flag = HasSubtree(root1.right,root2);
        }
        return flag;
    }

    public boolean DoesTree1HasTree2(TreeNode root1,TreeNode root2) {
        if(root2 == null) return true;
        if(root1 == null) return false;

        if(root1.val == root2.val) {
            return DoesTree1HasTree2(root1.left,root2.left) &&
                    DoesTree1HasTree2(root1.right,root2.right);
        }
        return false;
    }
}
