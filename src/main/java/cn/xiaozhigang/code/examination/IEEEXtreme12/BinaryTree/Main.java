package cn.xiaozhigang.code.examination.IEEEXtreme12.BinaryTree;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * Drawing Rooted Binary Trees
 * 题目：给出二叉树的中序和先序序列，要求打印出二叉树的形状。
 * 如：
 *  a
 * b c
 * 首先由中序和先序序列可以构建出一颗二叉树；其次按形状打印二叉树的
 * 基础是按层次打印二叉树，只需要在按层打印的同时输出正确的空格即可。
 * 那么如何输出正确的空格呢？就需要知道每个节点应该在一行的第几列中
 * 出现，而这个数字正好是节点在中序序列中的顺序。
 * AC
 * */
class TreeNode {
      char val;
      TreeNode left;
      TreeNode right;

      int pos;

      TreeNode(char x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", pos=" + pos +
                '}';
    }
}
  public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String a = sc.nextLine();
            String b = sc.nextLine();

            TreeNode root = constructCore(b,a);
            printTree(root);
            if(sc.hasNextLine())
                System.out.println();
        }
    }
    private static void printTree(TreeNode root) {
          if(root == null)
              return;

          LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

          queue.add(root);
          //记录当前层有多少个节点
          int levelSize = 1;
          //记录下一层节点数，levelSize的下一个值
          int chiledLevelSize = 0;
          //记录当前行该打印第几个位置了
          int levelPos = 0;

          while (queue.isEmpty() == false) {
              chiledLevelSize = 0;
              levelPos = 0;  //从当前行0位置开始打印

              //依次打印每个节点
              for(int i = 0; i < levelSize; i++) {
                  TreeNode index = queue.poll();
                  //打印空格
                  for(int k = levelPos; k < index.pos; k++)
                      System.out.print(' ');
                  levelPos = index.pos + 1;   //打印完当前结点后，位置移到当前结点后一个
                  System.out.print(index.val); //打印当前结点

                  //有左孩子，先把左孩子加进去
                  if(index.left != null) {
                      queue.add(index.left);
                      chiledLevelSize++;
                  }

                  //有右孩子，把右孩子加入队列
                  if(index.right != null) {
                      queue.add(index.right);
                      chiledLevelSize++;
                  }
              }
              //更新层节点数
              levelSize = chiledLevelSize;
              //最后一行不需要换行
              if(chiledLevelSize != 0)
                System.out.println();
          }
      }

      /**
       * 构造二叉树
       * */
    private static TreeNode constructCore(String b,String a) {
        return constructCore(b.toCharArray(), a.toCharArray(), 0, b.length() - 1, 0, a.length() - 1);
    }

    /**
     * 由先序中序序列构造二叉树
     * pre先序序列
     * in中序序列
     * */
    private static TreeNode constructCore(char [] pre,char [] in,int preStart,int preEnd,int inStart,int inEnd) {
        TreeNode root = new TreeNode(pre[preStart]);

        //找到‘根节点’在中序序列中的位置
        int i = inStart;
        while(i <= inEnd && in[i] != pre[preStart]) i++;

        //记录位置，按形状打印二叉树时用
        root.pos = i;
        int lengthLeft = i - inStart;

        if(i == inStart) {
            //左子树为空
            root.left = null;
        } else {
            //递归构造左子树，注意数组范围写对
            root.left = constructCore(pre,in,preStart + 1,preStart + 1 + lengthLeft - 1,inStart,i - 1);
        }

        //构造右子树，同上
        if(i == inEnd) {
            root.right = null;
        } else {
            root.right = constructCore(pre,in,preStart + lengthLeft + 1,preEnd,i + 1,inEnd);
        }

        return root;
    }

}
