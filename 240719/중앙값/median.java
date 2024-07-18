import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수열 입력 -> 홀수번째 마다 지금까지 입력받은 값의 중앙값을 출력
        int T = Integer.parseInt(br.readLine());
        for (int t=0 ; t<T ; t++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer stk = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> max_heap = new PriorityQueue<>();
            PriorityQueue<Integer> min_heap = new PriorityQueue<>(Collections.reverseOrder());
            int middle = Integer.parseInt(stk.nextToken());
            System.out.print(middle+" ");
            for (int i=1 ; i<=n/2 ; i++){
                int el1 = Integer.parseInt(stk.nextToken());
                int el2 = Integer.parseInt(stk.nextToken());

                if (el1>middle) max_heap.add(el1);
                else min_heap.add(el1);

                if (el2>middle) max_heap.add(el2);
                else min_heap.add(el2);

                if (max_heap.size()>min_heap.size()){
                    min_heap.add(middle);
                    middle = max_heap.poll();
                } else if (max_heap.size()<min_heap.size()) {
                    max_heap.add(middle);
                    middle = min_heap.poll();
                }   

                System.out.print(middle + " ");
            }
            System.out.println();
        }
    }
}