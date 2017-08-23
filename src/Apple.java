import java.util.Scanner;

/**
 * Created by fengy on 2017/8/21.
 * 题目描述
 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
 输入描述:
 输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果
 输出描述:
 输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1
 示例1
 输入

 20
 输出

 3

 */
public class Apple {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Apple h=new Apple();
        while(sc.hasNext()){
            int n=sc.nextInt();
            System.out.println(h.leastNum(n));
        }
    }

    private int leastNum(int n) {
        int[] map=new int[n+1];
        map[0]=0;
        for(int j=1;j<6;j++){
            map[j]=-1;
        }

        for(int j=6;j<n+1;j++){
            if(j%8==0){
                map[j]=j/8;
            }
            if(j>=8){
                map[j]=(map[j-8]!=-1)?1+map[j-8]:-1;
            }
            if(map[j]<=0){
                map[j]=(map[j-6]!=-1)?1+map[j-6]:-1;
            }
        }

        return map[n];
    }
}
