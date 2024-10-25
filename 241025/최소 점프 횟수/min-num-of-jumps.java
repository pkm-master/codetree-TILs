import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int n, ans;
    
    public static void dfs(int curr, int step){
        if (curr>n){
            return;
        } 
        if (curr == n){
            ans = Math.min(ans,step);
            return;
        }
        for (int i=1; i<=arr[curr-1]; i++){
            dfs(curr+i, step+1);
        }

    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // n번 위치에 도달하기 위해 필요한 최소 점프 횟수
        // 최대점프가능거리 : 현재위치로부터 추가적으로 나아갈 수 있는 최대칸의수, 점프는 앞으로만 가능.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        ans = (int)1e9;

        arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        dfs(1, 0);
        System.out.println(ans==(int)1e9?-1:ans);


    }
}