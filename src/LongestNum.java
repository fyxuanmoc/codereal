import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fengy on 2017/8/25.\
 * 题目描述
 读入一个字符串str，输出字符串str中的连续最长的数字串
 输入描述:
 个测试输入包含1个测试用例，一个字符串str，长度不超过255。
 输出描述:
 在一行内输出str中里连续最长的数字串。
 示例1
 输入

 abcd12345ed125ss123456789
 输出

 123456789
 */
public class LongestNum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            System.out.println(findLongest1(s));
        }
    }
//Trycatch去做
    private static String findLongest(String s) {
        StringBuffer ss=new StringBuffer();
        String res="";
        int count=0;
        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++){
            int temp=0;
            try{
                temp=Integer.parseInt(String.valueOf(c[i]));
                if(Integer.parseInt(String.valueOf(c[i]))<=9&&Integer.parseInt(String.valueOf(c[i]))>=0){
                    ss.append(c[i]);
                }
            }catch(NumberFormatException e){
                if(ss.length()>count){
                    res=ss.toString();
                    count=res.length();
                }
                ss=new StringBuffer();
            }
            if(ss.length()>count){
                res=ss.toString();
                count=res.length();
            }

        }
        return res;
    }
    //正则匹配!!!!!!!
    private static String findLongest1(String s) {
        StringBuffer ss=new StringBuffer();
        String res="";
        int count=0;
        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++){
            String temp=String.valueOf(c[i]);
            String regEx = "[0-9]";
            // 编译正则表达式
            Pattern pattern = Pattern.compile(regEx);
            // 忽略大小写的写法
            // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(temp);
            // 字符串是否与正则表达式相匹配
            boolean rs = matcher.matches();
            if(rs==true){
                ss.append(c[i]);
            }else{
                if(ss.length()>count){
                    res=ss.toString();
                    count=res.length();
                }
                ss=new StringBuffer();
            }
            if(ss.length()>count){
                res=ss.toString();
                count=res.length();
            }

        }
        return res;
    }
}
