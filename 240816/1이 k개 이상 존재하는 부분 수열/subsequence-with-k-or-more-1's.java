import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // 1이 k개 이상 존재하는 가장 짧은 연속 부분수열
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(stk.nextToken());

        }
        int i=0;
        int j=0;

        int tmp=0;
        int ans=1000000;
        int cnt=0;

        while (j<n){
            if (arr[j]==1){
                cnt++;
            }

            if (cnt>=k){
                while (i<j && cnt>=k){
                    if (arr[i]==1 && cnt!=k) cnt--;
                    else if (arr[i]==1 && cnt==k) break;
                    i++;
                    tmp--;
                }
            }

            j++;
            tmp++;
            // System.out.println(tmp);
            // System.out.println(i);
            if (cnt >= k ) ans = Math.min(ans,tmp);
        }
        System.out.println(ans==1000000? -1:ans);

    }


}