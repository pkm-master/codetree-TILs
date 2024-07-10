import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        HashSet<Long> A = new HashSet<>();
        HashSet<Long> B = new HashSet<>();

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++){
            A.add(Long.parseLong(stk.nextToken()));
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < m ; i++){
            B.add(Long.parseLong(stk.nextToken()));
        }

        HashSet<Long> Hap = new HashSet<>(A);
        Hap.addAll(B);
        HashSet<Long> gyo = new HashSet<>(A);
        gyo.retainAll(B);

        Hap.removeAll(gyo);

        System.out.println(Hap.size());



    }
}