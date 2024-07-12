import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        set.add(-1);
        set.add(n+1);

        for (int i=0 ; i<m ; i++){
            int el = Integer.parseInt(stk.nextToken());
            set.add(el);
            int max_dist = 0;
            int dist = 0;
            for (int ele : set){
                if (set.lower(ele) != null) dist = ele - set.lower(ele) -1;
                if (dist>max_dist) max_dist = dist;
            }
            System.out.println(max_dist);
        }



    }
}