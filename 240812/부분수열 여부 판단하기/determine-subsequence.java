import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] arrA = new int[n];
        int[] arrB = new int[m];

        stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arrA[i] = Integer.parseInt(stk.nextToken());

        }

        stk = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++){
            arrB[i] = Integer.parseInt(stk.nextToken());
        }

        int i=0;
        for (int j=0; j<n; j++ ){
            if (i<m && arrA[j]==arrB[i]){
                i+=1;
            }
        }

        if (i == m){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}