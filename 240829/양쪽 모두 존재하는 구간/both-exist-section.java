import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        HashMap<Integer,Integer> inside = new HashMap<>();
        HashMap<Integer,Integer> outside = new HashMap<>();

        int[] arr = new int[n];

        stk = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){ 
            arr[i] = Integer.parseInt(stk.nextToken());
            if (outside.containsKey(arr[i])) outside.put(arr[i], outside.get(arr[i])+1);
            else outside.put(arr[i],1);

        }

        int j = 0;
        int ans = (int)Math.pow(10,6);

        for (int i=0; i<n; i++){
            while (inside.size()<m && j<n){
                if (inside.containsKey(arr[j])) inside.put(arr[j], inside.get(arr[j])+1);
                else inside.put(arr[j],1);

                outside.put(arr[j], outside.get(arr[j])-1);
                if (outside.get(arr[j])==0) outside.remove(arr[j]);
                j++;
            }

            if (outside.size()==m && inside.size()==m) ans = Math.min(ans, j-i);


            inside.put(arr[i], inside.get(arr[i])-1);
            if (inside.get(arr[i])==0) inside.remove(arr[i]);

            if (outside.containsKey(arr[i])) outside.put(arr[i], outside.get(arr[i])+1);
            else outside.put(arr[i],1);
        }

        System.out.println(ans==(int)Math.pow(10,6)? -1 : ans);


    }
}