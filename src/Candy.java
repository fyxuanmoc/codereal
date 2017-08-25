import java.util.Scanner;

/**
 * Created by fengy on 2017/8/24.
 *题目描述
 A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息：
 A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
 现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。
 输入描述:
 输入为一行，一共4个整数，分别为A - B，B - C，A + B，B + C，用空格隔开。
 范围均在-30到30之间(闭区间)。
 输出描述:
 输出为一行，如果存在满足的整数A，B，C则按顺序输出A，B，C，用空格隔开，行末无空格。
 如果不存在这样的整数A，B，C，则输出No
 示例1
 输入

 1 -2 3 4
 输出

 2 1 3

 容易出错的点：考虑后两个数不可能是负数 同时也要考虑 有可能除法得到的不是整数 但是我们直接用int去做
 */
public class Candy {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int q=sc.nextInt();
            int w=sc.nextInt();
            int e=sc.nextInt();
            int r=sc.nextInt();
            if(e<0||r<0){
                System.out.print("No");
            }else if((e+r-(q-w))%4==0){
                int b=(e+r-(q-w))/4;
                int a=q+b;
                int c=b-w;
                System.out.print(a+" "+b+" "+c);
            }else{
                System.out.print("No");
            }

        }
    }
}
