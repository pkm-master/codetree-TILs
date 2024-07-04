import java.io.*;
import java.util.*;


public class Main {

    public static void hash_fill(Map<Integer,Integer> hash,int key){
        if (hash.containsKey(key)){
            hash.replace(key, hash.get(key)+1);
        } else {
            hash.put(key,1);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Map<Integer,Integer> hash1 = new HashMap<>();
        Map<Integer,Integer> hash2 = new HashMap<>();
        Map<Integer,Integer> hash3 = new HashMap<>();
        Map<Integer,Integer> hash4 = new HashMap<>();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++){
            hash_fill(hash1,Integer.parseInt(stk.nextToken()));
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++){
            hash_fill(hash2,Integer.parseInt(stk.nextToken()));
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++){
            hash_fill(hash3,Integer.parseInt(stk.nextToken()));
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++){
            hash_fill(hash4,Integer.parseInt(stk.nextToken()));
        }

        int ans = 0;

        for (int key1 : hash1.keySet()){
            for (int key2 : hash2.keySet()){
                for (int key3 : hash3.keySet()){
                    ans += hash1.get(key1) * hash2.get(key2) * hash3.get(key3) * hash4.getOrDefault(-key1-key2-key3,0);
                }
            }
        }
        System.out.println(ans);
    }
}