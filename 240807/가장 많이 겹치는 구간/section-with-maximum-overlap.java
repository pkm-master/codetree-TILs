import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lines = new int[200001];

        for (int i=0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());

            lines[s] = 1;
            lines[e] = -1;
        }

        int max_value = 0;
        int sums = 0;

        for (int i=0;i<=200000;i++){
            sums += lines[i];
            if (max_value<sums){
                max_value=sums;
            }
        }
        System.out.println(max_value);

    }
}