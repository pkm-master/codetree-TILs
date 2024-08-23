import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        HashMap<Integer,Integer> backIdx = new HashMap<>();

        int[] arr = new int[n];
        TreeSet<Integer> numbers = new TreeSet<>();

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            numbers.add(arr[i]);
        }
        Arrays.sort(arr);

        for (int i=0; i<n; i++) backIdx.put(arr[i],i);

        PriorityQueue<Integer> setNum = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<n; i++){
            int upperbound = numbers.floor(arr[i]+k);
            int upperidx = backIdx.get(upperbound);
            setNum.add(upperidx-i+1);
        } 
        
        int ans = 0;
        for (int i=0; i<2; i++) ans += setNum.poll();

        System.out.println(ans);

        
    }
}