package day2019年2月25日;

import javax.swing.plaf.synth.SynthEditorPaneUI;

/**
 *  @author: Vito
 *  @Email: dai625125312@gmail.com
 *  @Date: 2019/2/25 10:40
 *  @Description:  从链表尾部指定位置删除元素
 */
public class Day2019年2月25日RemoveFromLinkedListTail {

    public int currPoint = 0;
    public boolean removeed = false;
    public class LinkedListNode<T>{
        T value;
        LinkedListNode nextNode;

        public LinkedListNode(T value){
            this.value = value;
        }

        public LinkedListNode(T value, LinkedListNode nextNode){
            this.value = value;
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "Node : value = "+ value.toString();
        }
    }

    // 测试方法
    public void test(){
        LinkedListNode<String> node4 = new LinkedListNode<>("5", null);
        LinkedListNode<String> node3 = new LinkedListNode<>("4", node4);
        LinkedListNode<String> node2 = new LinkedListNode<>("3", node3);
        LinkedListNode<String> node1 = new LinkedListNode<>("2", node2);
        LinkedListNode<String> node0 = new LinkedListNode<>("1", node1);

        System.out.println("raw LinkedList ->");
        LinkedListNode<String> node = node0;
        while (node!=null){
            System.out.print("\t"+node);
            node = node.nextNode;
        }
        System.out.println("\n");
//        LinkedListNode<String> resultList = remove(node0,2);
        LinkedListNode<String> resultList = removeOnceLoop(node0,5);
        System.out.println(resultList);

        System.out.println("result LinkedList ->");

        while (resultList!=null){
            System.out.print("\t"+resultList);
            resultList = resultList.nextNode;
        }

    }

    public static void main(String[] args){
        Day2019年2月25日RemoveFromLinkedListTail removeFromLinkedListTail = new Day2019年2月25日RemoveFromLinkedListTail();
        removeFromLinkedListTail.test();

    }

    public LinkedListNode remove(LinkedListNode header, int n){
        if (header==null||header.nextNode==null)
            return null;
        // 遍历获取链表长度
        int linkedListLength = 1;
        LinkedListNode next = header.nextNode;
        while (next!=null){
            linkedListLength++;
            next = next.nextNode;
        }
        int step = linkedListLength-n;
        if (step==0){
            return header.nextNode;
        }
        // 遍历的第一步
        next = header;
        // 遍历找到元素的前一个元素
        for (int i=step; i>1; i--)
            next=next.nextNode;

        next.nextNode = next.nextNode.nextNode;
        return header;
    }

    public LinkedListNode removeOnceLoop(LinkedListNode header, int n){
        if (header==null||header.nextNode==null)
            return null;

        // 定义两个"指针" 间距是n-1， 当第一个指针指向链表的最后一个元素的时候
        // 第二个指针刚好指向要删除的元素的前一个元素。
        // 只要将第二个指针指向的元素的nextNode指向它的next.next元素即可
        LinkedListNode firstPoint = header.nextNode;
        LinkedListNode secondPoint= header;
        for (int i = 0; i < n-1 ; i++) {
            firstPoint = firstPoint.nextNode;
        }
        // 如果第一个指针移到了链表的尾部的下一个，则说明要移除的是链表的头元素。直接返回链表的第二个元素即可。
        if (firstPoint==null)
            return header.nextNode;

        while (firstPoint.nextNode!=null){
            firstPoint = firstPoint.nextNode;
            secondPoint = secondPoint.nextNode;
        }
        secondPoint.nextNode = secondPoint.nextNode.nextNode;

        return header;
    }

}
