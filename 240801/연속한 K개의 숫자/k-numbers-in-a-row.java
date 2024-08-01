import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // [1 1 0 0 1 0 0 0 1 1]
        // 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());

        int[] numbers = new int[N+1];

        
        for (int i=1 ; i<=N ; i++){
            numbers[i] = 1;
        }


        for (int i=0 ; i<B ; i++){
            numbers[Integer.parseInt(br.readLine())] = 0;
        }

        int[] sums = new int[N+1];

        for (int i=1; i<=N ; i++){
            sums[i] = sums[i-1]+numbers[i];
        }

        int min_value = K;
        for (int i=K ; i<=N ; i++){
            int value = sums[i] - sums[i-K];
            int diff = K-value;
            if (min_value > diff) min_value = diff;
        }

        System.out.println(min_value);

    }
}