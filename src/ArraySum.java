import java.util.Scanner;

/**
 * Created by fengy on 2017/8/24.
 * 题目描述
 一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
 输入描述:
 输入为两行。
 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素
 第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。
 输出描述:
 所有连续子数组中和最大的值。
 示例1
 输入

 3
 -1 2 1
 输出

 3
 最大数组和思路：
 刚开始sum为第一个数 同时也要用res来记录这个值
 如果sum<0的话 就把当前sum设置为当前值（清空之前的值）
 如果sum>0的话 就加上现在的值在之前要存一下res的最大值
 */
public class ArraySum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] array=new int[n];
            for(int i=0;i<n;i++){
                array[i]=sc.nextInt();
            }
            System.out.println(mostSum(array));
        }
    }

    private static int mostSum(int[] array) {
        int sum=array[0];
        int res=Integer.MIN_VALUE;
        for(int i=1;i<array.length;i++){
            if(sum>=0){
                if(res<sum){
                    res=sum;
                }
                sum=sum+array[i];
            }else{
                if(res<sum){
                    res=sum;
                }
                sum=array[i];
            }
        }
        return sum>res?sum:res;
    }
}
