import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int Q = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int[] points = new int[10000000+1];
        int[] sums = new int[10000000+1];
        
        for (int i=1; i<=N; i++){
            points[Integer.parseInt(stk.nextToken())] = 1;
        }

        for (int i=1; i<= 10000000 ; i++ ){
            sums[i] = sums[i-1]+points[i];
        }

        for (int i=0 ; i<Q ; i++){
            stk = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            System.out.println(sums[e]-sums[s-1]);

        }
    }
}