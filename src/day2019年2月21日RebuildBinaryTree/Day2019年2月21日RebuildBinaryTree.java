package day2019年2月21日RebuildBinaryTree;

import day2019年2月19日.Day2019年2月19日LinkedListReverse;
import sun.reflect.generics.tree.Tree;

/**
 *  @author: Vito
 *  @Email: dai625125312@gmail.com
 *  @Date: 2019/2/21 17:26
 *  @Description:  重建二叉树
 */
public class Day2019年2月21日RebuildBinaryTree {

    // 启动入口
    public static void main(String...args){
        Day2019年2月21日RebuildBinaryTree rebuildBinaryTree = new Day2019年2月21日RebuildBinaryTree();
        rebuildBinaryTree.test();
    }

    // 测试用例
    public void test(){
        Integer[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        Integer[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = construct(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
        printTree(root);
    }

    public <T> TreeNode <T> construct(T[] pre, T[] in, int pStartIndex, int pEndIndex, int inStartIndex, int inEndIndex){
        // 判断数据是否有效
        if (in.length > 0 && pre.length == in.length){
            TreeNode tree= new TreeNode<T>(pre[pStartIndex]);
            // 判断前序遍历是否有多个元素，如果有就继续查找，否者证明当前树没有子树
            if (pStartIndex==pEndIndex){
                return tree;
            }
            int root = 0;
            // 通过前序遍历找到对应 节点在 中序遍历中的索引
            for (root = inStartIndex; root< inEndIndex ; root++) {
                if (pre[pStartIndex]==in[root]){
                    break;
                }
            }

            // 通过在中序遍历中root位置 判断左右是否有子树
            int leftTreeLength = root - inStartIndex;
            int rightTreeLength = inEndIndex - root;

            if (leftTreeLength>0){
                tree.left = construct(pre, in, pStartIndex+1, pStartIndex+leftTreeLength, inStartIndex, root-1);
            }

            if (rightTreeLength>0){
                tree.right = construct(pre, in, pStartIndex+leftTreeLength+1, pEndIndex, root+1, inEndIndex);
            }
            return tree;
        }else{
            return null;
        }
    }




    /**
     * 二叉树节点
     * @param <T>
     */
    public class TreeNode<T>{
        T value;
        TreeNode left;
        TreeNode right;
        public TreeNode(T value){
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    // 中序遍历二叉树
    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + " ");
            printTree(root.right);
        }
    }

}
