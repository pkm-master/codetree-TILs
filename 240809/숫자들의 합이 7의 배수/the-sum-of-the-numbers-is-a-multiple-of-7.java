import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // 연속해 있는 숫자들을 그룹으로 만듦 그룹의 합은 7의 배수
        // 만든 그룹 중 최대 크기
        // 누적합 배열 -> 특정 구간내에서 합을 구할 수 있음
        // 가장쉬운방법
        // 누적합배열을 만들고 구간 a~b들에 대해 7의 배수인걸 판별
        // K가 큰거부터 시작해서 7의 배수가 나오면 stop하고 k를 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] sums = new long[n+1];

        for (int i=1; i<=n; i++){
            sums[i] = sums[i-1] + Integer.parseInt(br.readLine());
            
        }

        int value = 0;
        boolean isFind = false;
        for (int k=n; k>0; k--){
            for (int i=n; i>k-1; i--){
                long part = sums[i] - sums[i-k];
                if (part % 7 == 0){
                    value = k;
                    isFind = true;
                    break;
                }
            }
            if(isFind) break;
        }


        System.out.println(isFind? value:0);

    }
}