import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        TreeMap<Integer, HashSet<Integer>> map = new TreeMap<>();
        HashMap<Integer,Integer> hash = new HashMap<>();

        stk = new StringTokenizer(br.readLine());
        set.add(-1);
        hash.put(-1, m+1);
        map.put(m+1,new HashSet<Integer>());
        map.get(m+1).add(-1);
        for (int i=0 ; i<m ; i++){
            int cut = Integer.parseInt(stk.nextToken());

            int distance;
            set.add(cut);
            if (set.higher(cut) != null){
                distance = set.higher(cut)-cut-1;
                hash.put(cut,distance);
            } else {
                distance = n-cut;
                hash.put(cut, n-cut);
            }

            if (map.containsKey(distance)) map.get(distance).add(cut);
            else map.put(distance,new HashSet<Integer>());

            int original = hash.get(set.lower(cut));
            int changed = cut-set.lower(cut)-1;
            map.get(original).remove(set.lower(cut));
            hash.replace(set.lower(cut), changed);
            if (map.get(original).size() == 0) map.remove(original);
            if (!map.containsKey(changed) ) map.put(changed, new HashSet<Integer>());
            map.get(changed).add(set.lower(cut));
            System.out.println(map.lastKey());
        }

    }
}