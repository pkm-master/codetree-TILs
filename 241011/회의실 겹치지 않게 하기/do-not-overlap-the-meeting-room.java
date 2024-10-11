import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int st,end;
    public Pair(int st, int end){
        this.st = st;
        this.end = end;
    }

    @Override
    public int compareTo(Pair p){
        if (this.end!=p.end){
            return this.end - p.end;
        }else{
            return this.st - p.st;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> q = new PriorityQueue<>();

        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            q.add(new Pair(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));
        }

        int currTime = 0;
        int cnt = 0;
        while (!q.isEmpty()){
            Pair now = q.poll();
            if (currTime <= now.st){
                cnt++;
                currTime = now.end;
            }
        }

        System.out.println(n-cnt);
    }
}