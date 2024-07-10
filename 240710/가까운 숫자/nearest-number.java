import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        
        int min_dist = 1000000000;

        for (int i=0 ; i<n ; i++){
            int new_ele = Integer.parseInt(stk.nextToken());
            set.add(new_ele);
            if (set.higher(new_ele) != null && set.higher(new_ele)-new_ele < min_dist ) min_dist = set.higher(new_ele)-new_ele;
            if (set.lower(new_ele) != null && new_ele-set.lower(new_ele) < min_dist ) min_dist = new_ele-set.lower(new_ele);
            System.out.println(min_dist);
        }
    }
}