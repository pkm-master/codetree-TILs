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

        int[][] arr = new int[4][n];

        Map<Integer,Integer> hash1 = new HashMap<>();
        Map<Integer,Integer> hash2 = new HashMap<>();
    
        StringTokenizer stk;

        for (int i = 0 ; i < 4 ; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++){
                int key = arr[0][i] + arr[1][j];
                hash_fill(hash1,key);
            }
        }

        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++){
                int key = arr[2][i] + arr[3][j];
                hash_fill(hash2,key);
            }
        }

        int ans = 0;

        for (int key1 : hash1.keySet()){
            ans += hash1.get(key1) * hash2.getOrDefault(-key1,0);
        }
        System.out.println(ans);
    }
}