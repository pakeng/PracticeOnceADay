package util;

/**
 *  @author: Vito
 *  @Email: dai625125312@gmail.com
 *  @Date: 2019/2/18 15:18
 *  @Description: 通用工具
 */
public class Utils {

    // 二分查找
    public static <T extends Comparable> int findByBinarySearch(T target, T[] targets){
        if (target==null||targets==null||targets.length==0)
            return -1;
        int start = 0, end= targets.length-1;
        int mid = targets.length / 2;
        if (target.compareTo(targets[mid])==0){
            return mid;
        }
        while (end > start){
            mid = (end - start) / 2 + start;
            if (target.compareTo(targets[mid])<0) {
                end = mid - 1;
            } else if (target.compareTo(targets[mid])>0) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
