import java.util.Scanner;

/**
 * Created by fengy on 2017/8/24.
 * 题目描述
 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 输入描述:
 输入为一行，n(1 ≤ n ≤ 1000)
 输出描述:
 输出一个整数,即题目所求
 示例1
 输入

 10
 输出

 2
 */
public class Zero {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            long sum=1;
            int i=1;
            int count=0;
            while(n>0){
                count+=n/5;
                n=n/5;
            }
            System.out.println(count);
        }
    }
}
