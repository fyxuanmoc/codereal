import java.util.Scanner;

/**
 * Created by fengy on 2017/8/21.
 *题目描述
 Please create a function to extract the filename extension from the given path,return the extracted filename extension or null if none.
 输入描述:
 输入数据为一个文件路径
 输出描述:
 对于每个测试实例，要求输出对应的filename extension
 示例1
 输入

 Abc/file.txt
 输出

 txt
 */
public class Extension {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Extension h=new Extension();
        while(sc.hasNext()){
            String n=sc.next();
            System.out.println(h.filename(n));
        }
    }

    private String filename(String n) {
        int count=n.indexOf('.');
        if(count==-1){
            return "null";
        }else{
            return n.substring(count+1);
        }
    }
}
