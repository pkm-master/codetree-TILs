import java.io.*;
import java.util.*;

class Segment implements Comparable<Segment>{
    int x1, x2;

    public Segment(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(Segment s){
        return this.x1-s.x1;
    }
    
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Segment[] lines = new Segment[n];
        int[] L = new int[n];
        int[] R = new int[n];

        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());

            lines[i] = new Segment(x1,x2);
        }

        Arrays.sort(lines);
        // x1부터 시작했을때 해당 선분이 가능한 x2의 범위를 L R을 통해 관리 

        L[0] = lines[0].x2;
        for (int i=1; i<n; i++){
            L[i] = Math.max(lines[i].x2, L[i-1]);

        }

        R[n-1] = lines[n-1].x2;
        for (int i=n-2; i>=0; i--){
            R[i] = Math.min(lines[i].x2, R[i+1]);
        }

        int ans = 0;
        for (int i=0; i<n; i++){
            if (i>0 && L[i-1] >= lines[i].x2) continue;
            if (i<n-1 && R[i+1] <= lines[i].x2) continue;

            ans++;
        }
        
        System.out.println(ans);
    }
}