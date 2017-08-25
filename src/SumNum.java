import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fengy on 2017/8/24.
 * 题目描述
 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
 输入描述:
 输入为两行:

 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)

 第二行为n个正整数A[i](32位整数)，以空格隔开。
 输出描述:
 输出所求的方案数
 示例1
 输入

 5 15
 5 5 10 2 3
 输出

 4
 */
public class SumNum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] array=new int[n];
            int sum=sc.nextInt();
            for(int i=0;i<n;i++){
                array[i]=sc.nextInt();
            }
            Arrays.sort(array);
            System.out.println(getNum(array,sum));
        }
    }

    private static long getNum(int[] array, int sum) {
        long[][] map=new long[array.length][sum+1];
        for(int i=0;i<array.length;i++){
            for(int j=1;j<sum+1;j++){
                if(array[i]==j){
                    map[i][j]=1;
                    if(i>=1) {
                        map[i][j]=map[i][j]+map[i - 1][j];
                    }
                }else if(j>array[i]){
                    if(i>=1) {
                        map[i][j]=map[i-1][j-array[i]]+map[i-1][j];
                    }

                }else{
                    if(i>=1) {
                        map[i][j]=map[i-1][j];
                    }

                }
            }
        }
        return map[array.length-1][sum];
    }
}
