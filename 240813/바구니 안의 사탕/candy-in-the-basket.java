import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int[] candies = new int[1000000+1];

        for (int i=0; i<N; i++){
            stk = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(stk.nextToken());
            int index = Integer.parseInt(stk.nextToken());

            candies[index] += number;
        }

        int ans = 0;
        int initial_sum = 0;

        // System.out.println(Arrays.toString(candies));

        if (K>=500000){
            System.out.println( Arrays.stream(candies).sum());
        } else{
            for (int i=0; i<2*K+1; i++){
                initial_sum += candies[i];
            }
            ans = initial_sum;

            for (int i=K+1; i<1000001-K; i++ ){
                initial_sum = initial_sum - candies[i-K-1] + candies[i+K];
                ans = Math.max(initial_sum,ans); 
            }

            System.out.println(ans);
        }



    }
}