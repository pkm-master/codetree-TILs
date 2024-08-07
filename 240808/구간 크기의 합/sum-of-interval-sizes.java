import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> hash = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i=0; i<N; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            hash.put(s,1);
            hash.put(e,-1);
            q.add(s);
            q.add(e);
        }

        int sums = 0;
        int start = 0;
        int length = 0;
        while(!q.isEmpty()){
            int point = q.poll();
            int tmp_sum = sums;
            sums += hash.get(point);

            if(sums == 1 && tmp_sum == 0 ){
                start=point;
            }else if (sums == 0 && tmp_sum == 1){
                length += (point - start);
            }
        }

        System.out.println(length);
    }
}