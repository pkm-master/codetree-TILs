import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int n,m;
    public static boolean is_possible(int value){
        
        int part = 0;

        for (int i=0; i<n; i++){
            part += arr[i]/value;
        }

        if (part>=m){
            return true;
        }else {
            return false;
        }
        

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[n];

        for (int i=0; i<n; i++){
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
        }

        int st = 1;
        int end = 100000;
        
        int ans = 0;
        while (st<=end){
            int mid = (st+end)/2;
            if (is_possible(mid)){
                st = mid+1;
                ans = Math.max(ans, mid);
            } else{
                end = mid-1;
            }
        }

        System.out.println(ans);

    }
}