package cn.xiaozhigang.code.DataStructure.Tree;

import java.util.LinkedList;

public class BinaryTree {
    public BinaryTree left;
    public BinaryTree right;

    public char val;

    public BinaryTree(char val) {
        this.val = val;
    }

    public static void main(String[] args) {
        BinaryTree b1 = new BinaryTree('A');
        BinaryTree b2 = new BinaryTree('B');
        BinaryTree b3 = new BinaryTree('C');
        BinaryTree b4 = new BinaryTree('D');
        BinaryTree b5 = new BinaryTree('E');
        b1.left = b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;

        System.out.println("/n前续：");
        preOrderDfs(b1);
        System.out.println();
        preOrderNoDfs(b1);

        System.out.println("/n中续：");
        inOrderDfs(b1);
        System.out.println();
        inOrderNoDfs(b1);

        System.out.println("/n后续：");
        postOrederDfs(b1);
        System.out.println();
        postOrderNoDfs(b1);

        System.out.println();
        System.out.println("先序序列化");
        preOrderSerialize(b1);

    }

    //递归先序遍历
    public static void preOrderDfs(BinaryTree root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        preOrderDfs(root.left);
        preOrderDfs(root.right);
    }

    //非递归先序遍历
    public static void preOrderNoDfs(BinaryTree root) {
        LinkedList<BinaryTree> stack = new LinkedList<BinaryTree>();

        BinaryTree p = root;
        while(p != null || stack.isEmpty() == false) {
            while(p != null) {
                stack.add(p);
                System.out.print(p.val + " ");
                p = p.left;
            }
            if(stack.isEmpty() == false) {
                p = stack.removeLast();
                p = p.right;
            }
        }
    }

    //递归中序遍历
    public static void inOrderDfs(BinaryTree root) {
        if(root == null) return;

        if(root.left != null)
            inOrderDfs(root.left);
        System.out.print(root.val + " ");
        if(root.right != null)
            inOrderDfs(root.right);
    }

    //非递归中序遍历
    public static void inOrderNoDfs(BinaryTree root) {
        LinkedList<BinaryTree> stack = new LinkedList<BinaryTree>();
        BinaryTree p = root;
        while(p != null || stack.isEmpty() == false) {
            while(p != null) {
                stack.add(p);
                p = p.left;
            }

            if(stack.isEmpty() == false) {
                p = stack.removeLast();
                System.out.print(p.val + " ");
                p = p.right;
            }
        }
    }

    //递归后序遍历
    public static void postOrederDfs(BinaryTree root) {
        if(root == null) return;

        if(root.left != null)
            postOrederDfs(root.left);
        if(root.right != null)
            postOrederDfs(root.right);

        System.out.print(root.val + " ");
    }

    //非递归后序遍历
    public static void postOrderNoDfs(BinaryTree root) {
        if(root == null) return;

        LinkedList<BinaryTree> stack = new LinkedList<BinaryTree>();
        BinaryTree cur,pre = null;
        stack.add(root);
        while(stack.isEmpty() == false) {
            cur = stack.getLast();
            if((cur.right == null && cur.left == null) ||
                    (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.print(cur.val + " ");
                stack.removeLast();
                pre = cur;
            } else {
                if(cur.right != null)
                    stack.add(cur.right);
                if(cur.left != null)
                    stack.add(cur.left);
            }
        }
    }


    public static void preOrderSerialize(BinaryTree root) {
        LinkedList<BinaryTree> stack = new LinkedList<BinaryTree>();

        BinaryTree p = root;
        while(p != null || stack.isEmpty() == false) {
            while(p != null) {
                stack.add(p);
                System.out.print(p.val);
                if(p.left == null)
                    System.out.print('#');
                if(p.right == null)
                    System.out.print('#');
                p = p.left;
            }
            if(stack.isEmpty() == false) {
                p = stack.removeLast();
                p = p.right;
            }
        }
    }
}
