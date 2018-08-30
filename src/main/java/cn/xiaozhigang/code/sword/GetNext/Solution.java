package cn.xiaozhigang.code.sword.GetNext;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
        if(pNode == null) return null;
        TreeLinkNode ans = null;
        if(pNode.right != null) {
            ans = pNode.right;
            while (ans.left != null) ans = ans.left;
            return ans;
        }
        while (pNode.next != null) {
            ans = pNode.next;
            if(ans.left == pNode)
                return ans;
            pNode = ans;
            ans = ans.next;
        }
        return null;
    }

    private static List<TreeLinkNode> list;
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)
            throw new IllegalArgumentException();
        list = new ArrayList<TreeLinkNode>();
        //get root
        TreeLinkNode root = pNode;
        while (root.next !=  null) root = root.next;

        dfs(root);
        for(int i = 0; i < list.size(); i++) {
            if((TreeLinkNode)list.get(i) == pNode && i != list.size() - 1)
                return (TreeLinkNode)list.get(i + 1);
        }
        return null;
    }

    private void dfs(TreeLinkNode root) {
        if(root != null) {
            dfs(root.left);
            list.add(root);
            dfs(root.right);
        }
    }
}
