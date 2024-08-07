import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());

        int[] Ls = new int[n];
        int[] Rs = new int[n];
        int[] nums = new int[n];

        stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            int value = Integer.parseInt(stk.nextToken());
            nums[i] = value;
            if (i>0) Ls[i] = Math.max(Ls[i-1],nums[i-1]);
        }
        for (int i=n-2; i>=0; i--){
            Rs[i] = Math.max(Rs[i+1],nums[i+1]);

        }

        for (int i=0; i<q; i++){
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            System.out.println(Math.max(Ls[s-1],Rs[e-1]));

        }



    }
}