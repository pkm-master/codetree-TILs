import java.io.*;
import java.util.*;

// 수직선 위에 서로 다른 n개의 점
// n개의 점들위에 m개의 물건 설치
// 가장 인접한 두 물건의 거리를 가능한 크게
// 가장 인접한 두 물건의 거리의 최댓값
public class Main {
    public static int[] arr;
    public static int n,m;
    public static boolean is_possible(int value){
        // 인접한 두 물건의 거리가 value일때 물건을 전부 놓을 수 있는지 확인하는 함수
        
        int before = arr[0];
        int stuff = 1;

        for (int i=1; i<n; i++){
            if (arr[i]-before >= value){
                before = arr[i];
                stuff ++;
            }
        }

        if (stuff>=m) return true;
        return false;

    }


    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr,0,n);

        int st = 0;
        int end = arr[n-1];
        int ans = 0;

        while (st<=end){
            int mid = (st+end)/2;
            if (is_possible(mid)){
                st = mid+1;
                ans = Math.max(ans,mid);
            }else{
                end = mid-1;
            }
        }
        System.out.println(ans);

    }
}