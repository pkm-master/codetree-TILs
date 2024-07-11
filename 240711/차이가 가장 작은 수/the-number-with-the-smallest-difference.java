import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        TreeSet<Integer> set = new TreeSet<>();

        for (int i=0 ; i<n ; i++){
            int el = Integer.parseInt(br.readLine());
            set.add(el);

        }
         
        int min_dist = 1000000000;

        for (int el : set){
            int dist = 0;
            int target = el + m;
            if (set.ceiling(target)!=null && set.ceiling(target)-el < min_dist){
                min_dist = set.ceiling(target);
            }
        }

        System.out.println(min_dist==1000000000 ? -1 : min_dist );
    }
}