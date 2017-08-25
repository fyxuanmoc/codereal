import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by fengy on 2017/8/24.
 * 题目描述
 小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。
 为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,0代表这个位置有障碍物,
 小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。小青蛙初始在(0,0)位置,
 地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且保证一定有起点到终点可达的路径),
 小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗体力值,当小青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。
 输入描述:
 输入包括n+1行:

 第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100)

 接下来的n行:

 每行m个0或者1,以空格分隔
 输出描述:
 如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;如果不能逃离迷宫,则输出"Can not escape!"。
 测试数据保证答案唯一
 示例1
 输入

 4 4 10
 1 0 0 1
 1 1 0 1
 0 1 1 1
 0 0 1 1
 输出

 [0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]
 */
public class Migong {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int sum=sc.nextInt();
            int[][] mig=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    mig[i][j]=sc.nextInt();
                }
            }
            findway(mig,n,m,sum);
        }
    }

    private static int[][] findway(int[][] mig, int n, int m, int sum) {
        int i=0,j=0;
        Stack<String> res=new Stack<>();
        int[][] visit=new int[n][m];
        boolean flag=false;
        Stack<String> stack=new Stack<>();
        //优先向右走
        while(i!=0&&j!=m-1&&i<n&&j<m){
            int count=0;
            if(i!=0&&mig[i-1][j]==1&&visit[i-1][j]==0){
                count++;
                stack.push(i-1+" "+j);
                j=j+1;
            }
            if(j!=0&&mig[i][j-1]==1&&visit[i][j-1]==0){
                count++;
                stack.push(i+" "+(j-1));
                j=j-1;
            }
            if(i!=n-1&&mig[i+1][j]==1&&visit[i+1][j]==0){
                count++;
                stack.push(i+1+" "+j);
                i=i+1;
            }
            if(j!=m-1&&mig[i][j+1]==1&&visit[i][j+1]==0){
                count++;
                stack.push(i+" "+j+1);
                j=j+1;
            }
            if(count==0){
                stack.pop();
                res.pop();
            }
            String[] temp=stack.peek().split(" ");
            if(i-Integer.parseInt(temp[0])>0){
                sum=sum-3;
            }
            if(i-Integer.parseInt(temp[0])<0){
                sum=sum-0;
            }else{
                sum=sum-1;
            }
            i=Integer.parseInt(temp[0]);
            j=Integer.parseInt(temp[1]);
            visit[i][j]=1;
            res.push(i+""+j);
            if(sum<0)
        }
    }
}
