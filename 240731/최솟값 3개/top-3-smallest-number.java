import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0 ; i<n ; i++){
            int k = Integer.parseInt(stk.nextToken());
            q.add(k);
            if (i<2){
                System.out.println(-1);
            } else{
                int[] tmp = new int[3];
                int m = 1;
                for (int j=0 ; j<3 ; j++){
                    tmp[j] = q.poll();
                    m *= tmp[j];
                }
                System.out.println(m);
                for (int j=0 ; j<3 ; j++) q.add(tmp[j]);
            }
        }
    }
}