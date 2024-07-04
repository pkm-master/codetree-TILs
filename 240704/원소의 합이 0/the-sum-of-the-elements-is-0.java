import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[4][n];
        Map<Integer,Integer> hash = new HashMap<>();

        for (int i = 0 ; i < 4 ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
                if (i == 3){
                    if (hash.containsKey(arr[i][j])){
                        hash.replace(arr[i][j], hash.get(arr[i][j])+1);
                    } else {
                        hash.put(arr[i][j],1);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++){
                for (int k = 0 ; k < n ; k++){
                    ans += hash.getOrDefault(-arr[0][i]-arr[1][j]-arr[2][k],0);
                }
            }
        }

        System.out.println(ans);
    }
}