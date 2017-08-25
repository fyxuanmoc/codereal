import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fengy on 2017/8/24.
 *
 */
public class JInZhi {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int jin=sc.nextInt();
            String[] all={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
            String[] now=new String[jin];
            for(int i=0;i<jin;i++){
                now[i]=all[i];
            }
            List<Integer> list=new ArrayList();
            StringBuffer res=new StringBuffer();
            if(n<0){
                res.append("-");
                n=-n;
            }

                while(n>0){
                    list.add(n%jin);
                    n=n/jin;
                }
                for(int i=list.size()-1;i>=0;i--){
                    res.append(now[list.get(i)]);
                }
                System.out.println(res.toString());


        }
    }
}
