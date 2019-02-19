package day2019年2月18日;

import java.util.LinkedList;

/**
 *  @author: Vito
 *  @Email: dai625125312@gmail.com
 *  @Date: 2019/2/18 11:01
 *  @Description:  之字形打印二叉树
 */

public class Day2019年2月18日BinaryTree {
    public static void test(){

        // 待打印的二叉树
        BinaryTreeNode<String> root = getSrcTree();
        printWithZhiZi(root);

        System.out.println("Hello Test");
    }

    private static void printWithZhiZi(BinaryTreeNode<String> root) {
        if (root == null) {
            return;
        }
        boolean flag = true; // 左到右
        // 用来遍历二叉树
        LinkedList<BinaryTreeNode<String>> current = new LinkedList<>();
        LinkedList<BinaryTreeNode<String>> tempStack = new LinkedList<>();
        current.add(root); // 将第一个元素加入
        // 遍历
        while(current.size()>0){
            BinaryTreeNode<String> node = current.remove(current.size()-1); // 移除待打印的栈顶元素
            System.out.printf("\t %s", node.toString());
            BinaryTreeNode<String> left = node.left;
            BinaryTreeNode<String> right = node.right;
            if(flag){
                if (left!=null)
                    tempStack.add(left);
                if (right!=null)
                    tempStack.add(right);
            }else {

                if (right!=null)
                    tempStack.add(right);
                if (left!=null)
                    tempStack.add(left);
            }
            if (current.size() == 0) {
                flag = !flag;
                LinkedList<BinaryTreeNode<String>> tmp = current;
                current = tempStack;
                tempStack = tmp;
                System.out.println();
            }

        }
    }

    /**
     * 原始数据
     *                               1
     *                             2    3
     *                           4  5  6  7
     *                         8  9
     * @return root
     */
    private static BinaryTreeNode<String> getSrcTree(){
        BinaryTreeNode<String> n1 = new BinaryTreeNode<>(1+"");
        BinaryTreeNode<String> n2 = new BinaryTreeNode<>(2+"");
        BinaryTreeNode<String> n3 = new BinaryTreeNode<>(3+"");
        BinaryTreeNode<String> n4 = new BinaryTreeNode<>(4+"");
        BinaryTreeNode<String> n5 = new BinaryTreeNode<>(5+"");
        BinaryTreeNode<String> n6 = new BinaryTreeNode<>(6+"");
        BinaryTreeNode<String> n7 = new BinaryTreeNode<>(7+"");
        BinaryTreeNode<String> n8 = new BinaryTreeNode<>(8+"");
        BinaryTreeNode<String> n9 = new BinaryTreeNode<>(9+"");
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        return n1;
    }


    /**
     * BinaryTreeNode 二叉树节点
     * @param <T>
     */
    static class BinaryTreeNode<T>{
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
        private T value;

        BinaryTreeNode(T value){
            this.value = value;
        }

        @Override
        public String toString() {

            return "value = "+ value;
        }
    }






}
