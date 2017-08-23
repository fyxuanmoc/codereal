import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fengy on 2017/8/21.
 * 输入描述:
 我们用每种字符代表一种宝石，A表示红宝石，B表示蓝宝石，C代表紫水晶，D代表翡翠，E代表钻石，F代表玉石，G代表玻璃等等，
 我们用一个全部为大写字母的字符序列表示项链的宝石序列，注意项链是首尾相接的。每行代表一种情况。
 输出描述:
 输出学者能够拿到的最多的宝石数量。每行一个
 示例1
 输入

 ABCYDYE
 ATTMBQECPD
 输出

 1
 3
 */
public class Diamond {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Diamond h=new Diamond();
        while(sc.hasNext()){
            String s=sc.next();
            System.out.println(h.diamondnum(s));
        }
    }
    public int diamondnum(String s) {
        int[] map=new int[5];
        int res=0;
        char[] arr={'A','B','C','D','E'};
        for(int i=0;i<5;i++){
            map[i]=s.indexOf(arr[i]);
        }
        Arrays.sort(map);
        for(int i=1;i<5;i++){
            if(res<map[i]-map[i-1]){
                res=map[i]-map[i-1];
            }
        }
        if((map[4]-map[0]+s.length())%(s.length()-1)>res){
            res=(map[4]-map[0]+s.length()-1)%(s.length()-1);
        }
        return res-1;
    }
}
