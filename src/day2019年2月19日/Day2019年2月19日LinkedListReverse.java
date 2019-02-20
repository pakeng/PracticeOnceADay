package day2019年2月19日;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Stack;

/**
 *  @author: Vito
 *  @Email: dai625125312@gmail.com
 *  @Date: 2019/2/19 10:31
 *  @Description: 翻转链表
 */
public class Day2019年2月19日LinkedListReverse {

    /**
     * 节点
     */
    public class LinkedNode<T>{
        T value;
        LinkedNode next;

        public LinkedNode(T value){
            this.value = value;
        }
        @Override
        public String toString() {
            return "value = "+ value;
        }
    }

    // 使用递归进行翻转
    public LinkedNode reverse(LinkedNode header){
        // 如果是空或者是只有一个元素直接返回
        if (header==null||header.next==null){
            return header;
        }
        // 递归调用 返回原始链表的倒数第一个元素
        LinkedNode newHeader = reverse(header.next);
        // 返回的是新的头 ， header代表原始倒数第二个元素
        // 将倒数第一个元素的next指向倒数第二个元素
        header.next.next=header;
        // 将倒数第二个元素断链
        // 主要是清除原始的头的next指向
        header.next=null;
        return newHeader;
    }

    /**
     *  使用栈反转链表，先将链表元素从头遍历放入栈中，然后逐个弹出，重建新的链表
     * @param header 链表头
     * @return  新的链表头
     */
    public LinkedNode reverseWithStack(LinkedNode header){
        if (header==null||header.next==null){
            return header;
        }
        LinkedNode newHeader , tempTail;
        Stack<LinkedNode> stack = new Stack<>();
        // 逐个放入栈中，
        while (header!=null){
            stack.add(header);
            header=header.next;
        }
        // 保存新的链表头
        newHeader = stack.pop();
        tempTail = newHeader;
        // 开始逐个弹出，并且移动指针指向当前的链表尾部
        while (stack.size()>0){
            tempTail.next = stack.pop();
            tempTail = tempTail.next;
        }
        // 将链表尾部的指针清除
        tempTail.next = null;
        return newHeader;
    }

    /**
     * 使用循环反转列表
     * @param header 链表头
     * @return 新的链表头
     */
    public LinkedNode reverseWithLoop(LinkedNode header){
        if (header==null){
            return header;
        }
        // newHeader 反转之后的新头， temp临时变量， curr 遍历的指针
        LinkedNode newHeader = header, temp=header, curr=header.next;
        // 头部作为新的链表的尾部，需要将指向清空
        header.next = null;
        // 当curr是空则说明遍历到了源链表的尾部了
        while (curr!=null){
            temp = curr.next;
            curr.next = newHeader;
            newHeader = curr;
            curr = temp;
        }
        return newHeader;
    }

    public void test(){
        LinkedNode<String> node0 = new LinkedNode<>("0");
        LinkedNode<String> node1 = new LinkedNode<>("1");
        LinkedNode<String> node2 = new LinkedNode<>("2");
        LinkedNode<String> node3 = new LinkedNode<>("3");
        LinkedNode<String> node4 = new LinkedNode<>("4");
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        System.out.println("raw LinkedList ->");
        LinkedNode<String> node = node0;
        while (node!=null){
            System.out.print("\t"+node);
            node = node.next;
        }
        System.out.print("\n");
//        node = reverse(node0);
//        node = reverseWithStack(node0);
        node = reverseWithLoop(node0);
        System.out.println("reversed LinkedList ->");
        while (node!=null){
            System.out.print("\t"+node);
            node = node.next;
        }
    }

    public static void main(String[] args){
        Day2019年2月19日LinkedListReverse linkedListReverse = new Day2019年2月19日LinkedListReverse();
        linkedListReverse.test();
    }
}
