import java.io.*;
import java.util.*;


public class Main {
    public static long find(long value, long m){
        long cnt =1;
        long end = m;
        long st = 1;

        while (st<=end){
            long mid = (st+end)/2;

            if (mid == value){
                return cnt;

            } else if (mid > value){
                end = mid-1;

            } else{
                st = mid + 1;

            }

            cnt ++;

        }

        return end;

    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // 사람이 숫자 예측 -> 컴퓨터는 사람이 예측한 숫자가 큰지 작은지 알려줌
        // 같은 경우 벌칙
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long m = Long.parseLong(br.readLine()); // 컴퓨터가말할 수 있는 범위의 끝(end)
        StringTokenizer stk = new StringTokenizer(br.readLine());

        long a = Long.parseLong(stk.nextToken()); // 컴퓨터가 예측하는 값의 최소
        long b = Long.parseLong(stk.nextToken()); // 컴퓨터가 예측하는 값의 최대

        long max_ans = 0;
        long min_ans = 100000;
        for (long i=a; i<=b; i++){
            long result = find(i, m);
            max_ans = Math.max(max_ans,result);
            min_ans = Math.min(min_ans,result);

        }

        System.out.print(min_ans);
        System.out.print(" ");
        System.out.println(max_ans);


    }
}