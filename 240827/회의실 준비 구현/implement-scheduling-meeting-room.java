import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int s,e;
    public Pair(int s, int e){
        this.s = s;
        this.e = e;
    }    

    @Override
    public int compareTo(Pair p){
        if (this.e != p.e) return this.e - p.e;
        else return this.s - p.s;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // 회의 끝 시간 기준으로 정렬 후, 겹치지 않게 고르기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> q = new PriorityQueue<>();

        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            q.add(new Pair(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));
        }

        int currTime = 0;
        int ans = 0;

        while (!q.isEmpty()){
            Pair curr = q.poll();
            if (curr.s >= currTime){
                currTime = curr.e;
                ans++;
            }
        }

        System.out.println(ans);

    }
}