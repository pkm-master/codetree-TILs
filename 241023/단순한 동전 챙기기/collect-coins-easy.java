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
    public static boolean[] coinVisited;
    public static int[] selectedCoint;
    public static int ans;
    public static Pair[] coinPos;
    public static Pair[] SEPos;
    public static HashSet<Integer> coinSet;

    public static void dfs(int idx, int j){
        // 3개를 방문했으면
        if(idx == 3){
            // st에서 해당 순서대로 코인을 방문하게 하고 최솟값을 구하기
            int result = minDist();
            ans = Math.min(ans,result);

            return;
        }
        for (int i=j+1;i<=9;i++){
            if (!coinVisited[i] && coinSet.contains(i)){
                coinVisited[i]=true;
                selectedCoint[idx] = i;
                dfs(idx+1, i);
                coinVisited[i]=false;
            }
        }
    } 

    public static int minDist(){
        int val = 0;
        for (int i=0; i<3; i++){
            if (i==0){
                val += Math.abs(coinPos[selectedCoint[i]].x - SEPos[0].x)+Math.abs(coinPos[selectedCoint[i]].y - SEPos[0].y);
            }else{
                val += Math.abs(coinPos[selectedCoint[i]].x - coinPos[selectedCoint[i-1]].x)+Math.abs(coinPos[selectedCoint[i]].y - coinPos[selectedCoint[i-1]].y);
            }            
        }
        val += Math.abs(coinPos[selectedCoint[2]].x - SEPos[1].x)+Math.abs(coinPos[selectedCoint[2]].y - SEPos[1].y);

        return val;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        coinPos = new Pair[10];
        SEPos = new Pair[2];
        coinSet = new HashSet<>();

        for (int i=0; i<n; i++){
            String line = br.readLine();
            for (int j=0; j<n; j++){
                if (line.charAt(j)=='S'){
                    SEPos[0] = new Pair(i,j);
                }else if(line.charAt(j)=='E'){
                    SEPos[1] = new Pair(i,j);
                }else if (line.charAt(j)!='.'){
                    int idx = (int)line.charAt(j) - (int)'0';
                    coinPos[idx] = new Pair(i,j);
                    coinSet.add(idx);
                }
            }
        }
        coinVisited = new boolean[10];
        selectedCoint = new int[3];
        ans = (int)1e9;
        dfs(0,0);

        System.out.println(ans==(int)1e9?-1:ans);

        
    }
}