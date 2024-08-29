import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int compareTo(Pair p){
        if (this.y != p.y) return this.y - p.y;
        else return p.x - this.x;
    }    
}

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int currTime = 1;
        PriorityQueue<Pair> q = new PriorityQueue<>();

        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            q.add(new Pair(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));
        }

        int ans = 0;

        while (!q.isEmpty()){
            Pair bomb = q.poll();
            if (bomb.y >= currTime){
                ans += bomb.x;
                currTime++;

            }
        }

        System.out.println(ans);

    }
}