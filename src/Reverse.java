import java.util.Scanner;

/**
 * Created by fengy on 2017/8/21.
 * 题目描述
 对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如:
 如果 X = 123，则rev(X) = 321;
 如果 X = 100，则rev(X) = 1.
 现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？
 输入描述:
 输入为一行，x、y(1 ≤ x、y ≤ 1000)，以空格隔开。
 输出描述:
 输出rev(rev(x) + rev(y))的值
 示例1
 输入

 123 100
 输出

 223
 */
public class Reverse {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Reverse h=new Reverse();
        while(sc.hasNext()){
           int x=sc.nextInt();
           int y=sc.nextInt();
           int res=h.rev(x,y);
           System.out.println(res);
        }
    }

    private int rev(int x, int y) {
        StringBuffer s1=new StringBuffer(x+"");
        StringBuffer s2=new StringBuffer(y+"");
        int i=0;
        while(s1.charAt(i)==0){
            s1.deleteCharAt(i);
        }
        while(s2.charAt(i)==0){
            s2.deleteCharAt(i);
        }
        StringBuffer res=new StringBuffer((Integer.valueOf(s1.reverse().toString())+Integer.valueOf(s2.reverse().toString()))+"");
        return Integer.valueOf(res.reverse().toString());


    }
}
