import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int[] R = new int[n];
        int[] L = new int[n];
        int[] nums = new int[n];

        for (int i=0; i<n; i++){
            nums[i] = Integer.parseInt(stk.nextToken());
            if (i>=2) L[i] = Math.max(L[i-1],nums[i-2]);
        }

        for (int i=n-3; i>=0; i--){
            R[i] = Math.max(R[i+1],nums[i+2]);
        }

        int max_value = 0;

        for (int i=0; i<n; i++){
            int partial = R[i] + L[i] + nums[i];
            if (max_value < partial) max_value=partial;
        }

        System.out.println( max_value);
        
    }
}