import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] order = new int[n];
        TreeSet<Integer> deckA = new TreeSet<>();
        HashSet<Integer> deckB = new HashSet<>();

        for (int i=0; i<n; i++){
            order[i] = Integer.parseInt(br.readLine());
            deckB.add(order[i]);
        }

        for (int i=1; i<=2*n; i++){
            if (!deckB.contains(i)) deckA.add(i);
        }

        // 이길수 있을 것 같으면 딱 이길 수 있는 카드만
        // 없으면 들고있는것중에서 제일 작은 카드를 내기
        // 이길 수 있을때만 ans ++

        int ans = 0;
        for (int i=0; i<n; i++){
            if (deckA.higher(order[i]) != null) {
                deckA.remove(deckA.higher(order[i]));
                ans++;
            } else {
                deckA.remove(deckA.first());
            }
        }

        System.out.println(ans);
        
    }
}