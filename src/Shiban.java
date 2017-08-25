import java.util.Scanner;

/**
 * Created by fengy on 2017/8/24.
 * 题目描述
 小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
 这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
 例如：
 N = 4，M = 24：
 4->6->8->12->18->24
 于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板
 输入描述:
 输入为一行，有两个整数N，M，以空格隔开。
 (4 ≤ N ≤ 100000)
 (N ≤ M ≤ 100000)
 输出描述:
 输出小易最少需要跳跃的步数,如果不能到达输出-1
 示例1
 输入

 4 24
 输出

 5
 自己写的程序超时是因为在找他的所有约数时（减少一半的时间遍历）
 for(int i=2;i<=Math.sqrt(n);i++){
             if(n%i==0){
                 list.add(i);
                 if(i!=n/i)list.add(n/i);
             }
         }
 */
public class Shiban {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int res=-1;
            if(jumpLeast(n,m)==-1){
                System.out.println(res);
            }else{

                System.out.println(jumpLeast(n,m));
            }

        }
    }

    private static int jumpLeast(int n, int m) {
        int[] map=new int[m+1];
        for(int i=m;i>=n;i--){
            map[i]=-1;
        }
        map[n]=0;
        for(int i=n;i<m+1;i++){
            if(map[i]!=-1){
                for(int j=2;j<=Math.sqrt(i);j++){
                    if(i%j==0&&i+i/j<m+1){
                        if(map[i+i/j]==-1){
                            map[i+i/j]=map[i]+1;
                        }else{
                            map[i+i/j]=Math.min(map[i+i/j],map[i]+1);
                        }
                    }
                }
            }

        }
        return map[m];
    }
}
