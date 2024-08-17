import java.io.*;
import java.util.*;


public class Main {
    public static int max = 100000;
    public static int n,m;
    public static int[] arr;

    // value보다 작은 것 중에서 가장 큰 곳에 있는것
    public static int find_lowerbound(int value){
        int st = 0;
        int end = n-1;
        int ans = n;
        
        while (st<=end){

            int mid = (st+end)/2;
            if (arr[mid]>=value){
                end = mid-1;
                ans = Math.min(ans,mid);

            } else{
                st = mid+1;
            }
        }

        return ans;
    }

    public static int find_upperbound(int value){
        int st = 0;
        int end = n-1;
        int ans = n;

        while (st<=end){
            // System.out.println('a');
            int mid = (st+end)/2;
            if (arr[mid]<=value){
                st = mid+1;

            } else{
                end = mid-1;
                ans = Math.min(ans,mid);
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr,0,n);
        

        for (int i=0; i<m; i++){
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            System.out.println(find_upperbound(end)-find_lowerbound(st));
            // System.out.println(find_lowerbound(st));


        }




    }
}