package day2019年2月22日;

/**
 *  @author: Vito
 *  @Email: dai625125312@gmail.com
 *  @Date: 2019/2/22 16:54
 *  @Description: 替换字符串中的空格
 */
public class Day2019年2月22日ReplaceBlankChars {


    public static void main(String[] args){
        Day2019年2月22日ReplaceBlankChars replaceBlankChars = new Day2019年2月22日ReplaceBlankChars();
        replaceBlankChars.test();
    }

    public void test(){
        String src = " We are Happy ! ";
        System.out.println(replaceWithSystemApi(src));
        System.out.println(replaceInOneLoop(src));
    }

    public String replaceWithSystemApi(String src){
        src = src.replace(" ", "%20");
        return src;
    }

    /**
     * 只是用两次遍历替换，不使用系统的api
     * @param src 源字符串
     * @return str 替换结果
     */
    public String replaceInTowLoop(String src){
        int blankCount = 0;
        for (int i=0;i<src.length();i++){
            if (src.charAt(i)== ' '){
                blankCount++;
            }
        }
        // ' ' 换成 %20  增加了 2个字符长度
        int destStrLength = src.length()+blankCount*2;
        char[] chars = new char[destStrLength];
        int curIndex= destStrLength-1;
        for (int i=src.length()-1; i>=0;i--){
            if (src.charAt(i)!=' ') {
                chars[curIndex--] = src.charAt(i);
            }else {
                chars[curIndex--] = '0';
                chars[curIndex--] = '2';
                chars[curIndex--] = '%';
            }
        }
        return new String(chars);
    }

    /**
     * 使用系统的StringBuffer提供的api进行替换
     * @param src 源字符串
     * @return str 替换结果
     */

    public String replaceInOneLoop(String src){
        StringBuffer stringBuffer = new StringBuffer(src);
        int loopLength = 0;

        // 关键点在于使用的循环条件 loopLength< stringBuffer.length() 是因为每次修改字符串 对应的buffer长度都改变了不能使用src的长度。
        while (loopLength<stringBuffer.length()){
            if (stringBuffer.charAt(loopLength)==' '){
                stringBuffer.delete(loopLength, loopLength+1).insert(loopLength, "%20");
            }
            loopLength++;
        }
        return stringBuffer.toString();
    }



}
