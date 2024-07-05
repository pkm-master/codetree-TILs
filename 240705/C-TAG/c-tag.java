import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // N : A와 B에 속한 카드그룹의 수
        // M : 각 카드그룹에 있는 종이의 수

        // M개의 자리중 3개를 픽해서 A의 것과 B의 것이 전부 다른 경우면 ok

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        HashSet<String> A = new HashSet<>();
        HashSet<String> B = new HashSet<>();

        for (int i = 0 ; i < n ; i++) A.add(br.readLine());
        for (int i = 0 ; i < n ; i++) B.add(br.readLine());

        int ans = 0;

        for (int i = 0 ; i < m ; i++){
            for (int j = i+1 ; j < m ; j++){
                for (int k = j+1 ; k < m ; k++){
                    HashSet<String> partA = new HashSet<>();
                    HashSet<String> partB = new HashSet<>();

                    for (String a : A){
                        String ap = Character.toString(a.charAt(i)) + Character.toString(a.charAt(j)) + Character.toString(a.charAt(k));
                        partA.add(ap);
                    }

                    for (String b : B){
                        String bp = Character.toString(b.charAt(i)) + Character.toString(b.charAt(j)) + Character.toString(b.charAt(k));
                        partB.add(bp);
                    }

                    boolean isDiff = true;
                    for (String ap : partA){
                        if (partB.contains(ap)){
                            isDiff = false;
                            break;
                        }
                    }
                    
                    if (isDiff) ans +=1;
                    
                }
            }
        }

        System.out.println(ans);





        
    }
}