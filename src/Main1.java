/**
 * Created by fengyx on 2017/8/25.
 */
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BooleanSupplier;


class Model{
    int price;
    int[] items;
    public Model(){}
}
public class Main1 {
/** 请完成下面这个process函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     * 输入:
     输入箱子长宽高 输入购买商品数 输入每个商品长宽高
     输出:
     输出最小箱子数
     输入范例:
10 20 30
3
1000 10 10 30
500 10 10 20
600 8 10 20
     输出范例:
     2 **/
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int[] box=new int[3];
            for(int i=0;i<3;i++){
                box[i]=scanner.nextInt();
            }

            int itemNum = scanner.nextInt();
            Model[] items = new Model[itemNum];
            for(int i=0; i<itemNum; i++){
                Model item = new Model();
                item.price = scanner.nextInt();
                int[] itemm=new int[3];
                for(int j=0;j<3;j++){
                    itemm[j]=scanner.nextInt();
                }
                item.items = itemm;
                items[i] = item;
            }
            System.out.println (process(box,items));

        }
    }
    private static int process(int[] box, Model[] items) {
        int res=0;
        Arrays.sort(box);
        int biao=box[0]*box[1]*box[2];
        int sum=1;
        int All=0;
        int flag=0;
        int prices=0;
        int count=1;
        for(int i=0;i<items.length;i++){
            sum=1;
            if(items[i].price>2000){flag=1;break;}
            Arrays.sort(items[i].items);
            for(int j=0;j<3;j++){
                if(items[i].items[j]>box[j]){
                    flag=1;
                    break;
                }
                sum=sum*items[i].items[j];
            }
            if(flag==1){
                break;
            }
            All=All+sum;
            prices=prices+items[i].price;
            if(All>count*biao||prices>count*2000){
                count++;
            }

        }
        if(flag==1){
            return -1;
        }
        return count;
    }

}
