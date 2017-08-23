/**
 * Created by fengy on 2017/8/21.
 * 最长递增子序列
 *
 */
import java.util.*;
public class Main {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int pick(int[] A) {
        int[] h=new int[A.length];
        h[0]=1;
        int max=0;
        for(int i=1;i<A.length;i++){
            if(A[i]>A[i-1]){
                h[i]=h[i-1]+1;
            }else{
                h[i]=1;
            }
            for(int j=i-2;j>=0;j--){
                if(A[j]<A[i]&&h[i]<h[j]+1){
                    h[i]=h[j]+1;
                }
            }
            if(max<h[i]){
                max=h[i];
            }

        }
        return max;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int trees = Integer.parseInt(in.nextLine().trim());
        int[] peaches = new int[trees];
        for (int i = 0; i < peaches.length; i++) {
            peaches[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(pick(peaches));
    }
}