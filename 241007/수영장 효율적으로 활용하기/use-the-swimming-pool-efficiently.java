import java.io.*;
import java.util.*;


public class Main {
    public static int n,m;
    public static int[] arr;

    public static boolean isPossible(int limit){

        int partial = 0;
        int part = 1;
        for (int i=0; i<n; i++){
            if (partial + arr[i] <= limit){
                partial += arr[i];

            }else{
                if (arr[i]<=limit){
                    partial = arr[i];
                    part += 1;
                }else{
                    return false;
                }
            }

            if (part > m) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int st = 0;
        int end = 1440*n;
        int ans = end;

        while(st<=end){
            int mid = (st+end)/2;

            if (isPossible(mid)){
                end = mid-1;
                ans = Math.min(ans, mid);

            } else{
                st = mid+1;
            }
        }

        System.out.println(ans);

    }
}