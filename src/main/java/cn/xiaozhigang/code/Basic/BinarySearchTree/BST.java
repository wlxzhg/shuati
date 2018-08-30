package cn.xiaozhigang.code.Basic.BinarySearchTree;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BST {
    //在二叉树t中查找关键字key
    // 如果找到返回true,将该节点放到result数组中，
    // 如果没有返回false，将待插入位置的父节点放入result[0]
    public static boolean binarySearch(TreeNode t,int key,TreeNode p,TreeNode[] result) {
        if(t == null) {
            result[0] = p;
            return false;
        }

        if(t.val == key) {
            result[0] = t;
            return true;
        }

        if(t.val < key) {
            return binarySearch(t.right,key,t,result);
        } else
            return binarySearch(t.left,key,t,result);
    }

    //平衡二叉树的插入操作
    public static boolean insertBST(TreeNode t,int key) {
        if(t == null) return false;

        TreeNode n = new TreeNode(key);

        TreeNode [] result = new TreeNode[1];
        if(binarySearch(t,key,null,result) == false) {
            if(result[0].val > key)
                result[0].left = n;
            else
                result[0].right = n;
            return true;
        } else
            return false;
   }

    public static void main(String[] args) {
        int[] arr = {4,2,1,6,9};
        TreeNode root = new TreeNode(arr[0]);
        for(int i = 1; i < arr.length; i++)
            insertBST(root,arr[i]);
        System.out.println("root:" + root);
        dfs(root);
    }

    public static void dfs(TreeNode root) {
        if(root ==  null) return;
        dfs(root.left);
        System.out.println(root.val);
        dfs(root.right);
    }
}
