package main;

import Day2019年2月18日.Day2019年2月18日2DArrayFind;
import Day2019年2月18日.Day2019年2月18日2DArrayFind.Target;
import Day2019年2月18日.Day2019年2月18日BinaryTree;

public class Main{
    public static void main(String[] args){
        System.out.print("Exercise Test");
        Day2019年2月18日Test();
    }

    public static void Day2019年2月18日Test(){
        Day2019年2月18日BinaryTree.test();

        Day2019年2月18日2DArrayFind finder = new Day2019年2月18日2DArrayFind();

        TestNode<Float> node = new TestNode<Float>(2.1f);
        /**
         * 0 1.0
         * 2.0 3.0
         * 2.1 3.5
         */
        Target[][] targets = new Target[][]{{new Target<Float>(0.0f), new Target<Float>(1.0f)}
                ,{new Target<Float>(2.0f), new Target<Float>(3.0f)}
                ,{new Target<Float>(2.1f), new Target<Float>(3.5f)}};

        finder.findByCorner(node, targets);
        System.out.println(node);
        System.out.println(node.say());

    }

    static class TestNode<T extends Comparable> extends Target{
        public TestNode(T value) {
            super(value);
        }

        public String say(){
            return "Test Node : "+ getValue();
        }
    }


}