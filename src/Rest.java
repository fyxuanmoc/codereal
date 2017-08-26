import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by fengy on 2017/8/25.
 * 题目描述
 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
 输入描述:
 输入包括m+2行。
 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000)
 第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。
 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。
 输出描述:
 输出一个整数,表示最大的总预计消费金额
 示例1
 输入

3 5
2 4 2
1 3
3 5
3 7
5 9
1 10
 输出

 20
 */
class Node{
    int num;
    int money;
    public Node(){}
}
class sortNode implements Comparator<Node>{

    @Override
    public int compare(Node o1, Node o2) {
        if(o1.money!=o2.money)
            return o1.money-o2.money;
        else{
            return o2.num-o1.num;
        }
    }
}
public class Rest {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] zhuo=new int[n];
        for(int i=0;i<n;i++){
            zhuo[i]=sc.nextInt();
        }
        Arrays.sort(zhuo);
        Node[] list=new Node[m];
        for(int j=0;j<m;j++){
            Node node=new Node();
            node.num=sc.nextInt();
            node.money=sc.nextInt();
            list[j]=node;
        }
        sortNode sort=new sortNode();
        Arrays.sort(list,sort);
        System.out.println(mostMoney(zhuo,list));
    }

    private static long mostMoney(int[] zhuo, Node[] list) {
        long res=0;
        int sum=0;
        Boolean[] visit=new Boolean[zhuo.length];
        for(int i=0;i<zhuo.length;i++){
            visit[i]=false;
        }
        for(int i=list.length-1;i>=0;i--){
     //       System.out.println(list[i].num+" "+list[i].money);
            if(list[i].num>zhuo[zhuo.length-1]){
                //直接跳过
            }else{
                int index=findTable(zhuo,list[i].num);
                while(index<zhuo.length&&visit[index]==true)index++;
                if(index<zhuo.length&&visit[index]==false){
                    visit[index]=true;
                    res=res+list[i].money;
                }
            }
        }
        return res;
    }

    public static int findTable(int[] table, int people){
        int i=0,j=table.length-1;
        int index = (i+j)/2;
        while(i<=j){
         if(table[index]>=people){
                j = index - 1;
         }else{
                i = index + 1;
        }
            index = (i+j)/2;
        }
        if(table[index]<people)index++;
        return index;
    }
}
