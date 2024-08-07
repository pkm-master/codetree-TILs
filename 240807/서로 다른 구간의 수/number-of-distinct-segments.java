import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> lines = new HashMap<>();
        PriorityQueue<Integer> points = new PriorityQueue<>();
        
        for(int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            lines.put(s,1);
            lines.put(e,-1);
            points.add(s);
            points.add(e);
        }

        int sums=0;
        int cnt=0;

        while(!points.isEmpty()){
            int value = points.poll();
            int tmp_sum = sums;
            sums+=lines.get(value);
            if(tmp_sum>sums && sums==0){
                cnt++;
            }
        }

        System.out.println(cnt);
        
    }
}