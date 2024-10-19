import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] visited;
    public static int[] selected;
    public static int n;
    public static void dfs(int idx){
        if(idx == n){
            for (int i=0; i<n; i++){
                System.out.print(selected[i]+" ");
            }
            System.out.println();
        } else{
            for (int i=n; i>=1; i--){
                if (!visited[i-1]){
                    visited[i-1] = true;
                    selected[idx] = i;
                    dfs(idx+1);
                    visited[i-1] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        selected = new int[n];

        dfs(0);
    }
}