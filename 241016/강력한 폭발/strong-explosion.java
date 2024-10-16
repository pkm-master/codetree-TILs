import java.io.*;
import java.util.*;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    // n번자리에 몇번 폭탄이 넣어질지결정
    public static int[] bombsN = new int[400];
    // 폭탄 자리 배열
    public static Pair[] bombs = new Pair[400];
    public static int bombNumber = 0;
    public static int maxAns = 0;
    public static int n;
    public static Pair[][] bombRange = {
        {new Pair(0,0),new Pair(0,0),new Pair(0,0),new Pair(0,0)},
        {new Pair(1,0),new Pair(2,0),new Pair(-1,0),new Pair(-2,0)},
        {new Pair(1,0),new Pair(0,1),new Pair(-1,0),new Pair(0,-1)},
        {new Pair(1,1),new Pair(-1,1),new Pair(-1,-1),new Pair(1,-1)},
    };
    
    public static int howMany(int[][] map){
        int ans = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (map[i][j]==-1){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int[][] bomb(){
        // bombs와 bombsN을 참고해서 폭탄이 터졌을때의 map을 반환 (-1로 변환)
        int[][] ans = new int[n][n];
        for (int i=0; i<bombNumber; i++){
            ans[bombs[i].x][bombs[i].y] = -1;
            for (Pair di:bombRange[bombsN[i]]){
                int nextX = bombs[i].x + di.x;
                int nextY = bombs[i].y + di.y;

                if (nextX>=0 && nextX < n && nextY >=0 && nextY < n){
                    ans[nextX][nextY] = -1;
                }
            }
        }
        return ans;
    }

    public static void bombSelect(int idx){
        if (idx == bombNumber){
            int[][] result = bomb();
            int resultN = howMany(result);
            maxAns = Math.max(maxAns,resultN);
        
        } else{
            for (int i=1; i<=3; i++){
                bombsN[idx] = i;
                bombSelect(idx+1);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                if (Integer.parseInt(stk.nextToken()) == 1){
                    bombs[bombNumber] = new Pair(i,j);
                    bombNumber++;
                }
            }
        }

        bombSelect(0);

        System.out.println(maxAns);
    }
}