package day2019年2月18日;

import util.Utils;

/**
 *  @author: Vito
 *  @Email: dai625125312@gmail.com
 *  @Date: 2019/2/18 14:28
 *  @Description: 二维数组的查找
 */

public class Day2019年2月18日2DArrayFind {

    public void test(){
        /**
         * 0 1
         * 2 3
         */
        Target[][] targets = new Target[][]{{new Target<Integer>(0), new Target<Integer>(1)}
                                            ,{new Target<Integer>(2), new Target<Integer>(3)}
                                            ,{new Target<Integer>(4), new Target<Integer>(5)}};
        Target target = new Target<Integer>(2);
//        findOneByOne(target, targets);
//        System.out.println(target);
//        findBinarySearch(target, targets);
//        System.out.println(target);
        findByCorner(target, targets);
        System.out.println(target);

    }

    public static void main(String[] args){
        Day2019年2月18日2DArrayFind find = new Day2019年2月18日2DArrayFind();
        find.test();
    }

    /**
     * 暴力查找，遍历所有 复杂度O(mn)
     * @param target 查找对象
     * @param targets 要遍历的二维数组
     * @return 是否查找到
     */
    public boolean findOneByOne(Target target, Target[][] targets){
        for(int i=0;i< targets.length; i++){
            for(int j=0;j< targets[0].length; j++){
                if (target.getValue() == targets[i][j].getValue()){
                    target.setCoordinate(new Coordinate(i, j));
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 二分查找 每一行都进行二分查找 复杂度 O(mlogn)
     * @param target 查找对象
     * @param targets 要遍历的二维数组
     * @return 是否查找到
     */
    public boolean findBinarySearch(Target target, Target[][] targets){
        for (int i = 0; i < targets.length; i++) {
            Target[] targetsCol = targets[i];
            int x = Utils.findByBinarySearch(target, targetsCol);
            if (x!=-1){
                target.setCoordinate(new Coordinate(i, x));
                return true;
            }
        }
        return false;
    }
    /**
     * 从左下角或者右上角开始查找 复杂度 O(m+n)
     * @param target 查找对象
     * @param targets 要遍历的二维数组
     * @return 是否查找到
     */
    public boolean findByCorner(Target target, Target[][] targets){
        if (targets == null || targets.length == 0 || (targets.length == 1 && targets[0].length == 0)) return false;
        int i = targets.length - 1;
        int j = 0;
        while (i >= 0 && j <= targets[0].length) {
            if (target.compareTo(targets[i][j])>0) {
                j++;
            } else if (target.compareTo(targets[i][j])<0) {
                i--;
            } else {
                target.setCoordinate(new Coordinate(i, j));
                return true;
            }
        }
        return false;
    }

    public static class Target<T extends Comparable> implements Comparable<Target> {
        T value;
        Coordinate coordinate = new Coordinate();

        public Target(T value){
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Coordinate getCoordinate() {
            return coordinate;
        }

        public void setCoordinate(Coordinate coordinate) {
            this.coordinate = coordinate;
        }

        @Override
        public String toString() {
            return "value = "+ value+ " index: "+ coordinate;
        }

        @Override
        public int compareTo(Target other) {
            return value.compareTo(other.value);
        }
    }

    public static class Coordinate{
        private int x = -1;
        private int y = -1;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Coordinate(){}

        @Override
        public String toString() {
            return "x = "+x+ ", y = "+ y;
        }
    }
}
