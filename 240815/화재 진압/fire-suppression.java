import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // 화재가 발생할 가능성이 있는 n, 소방서 m
        // 정확히 한곳에서만 발생
        // 가장 근처의 소방서가 출동하여 진입, 1을 이동하는데 1초가 소요
        // 각 위치에서 화재가 발생하는데 이를 진압하는데 걸리는 시간 중 가장 오래걸리는 시간

        // 근처에 있는 소방서가 가장 먼 화재지점 

        // LS : 각 화재지점에서 왼쪽에서 가장 가까운 소방소지점
        // RS : 각 화재지점에서 오른쪽에서 가장 가까운 소방소 지점
        
        // 화재지점을 돌면서 각 화재지점 중 가장 가까운걸 LS,RS중에서 판별 후, 둘의 차중 제일 큰걸 ans랑 비교해서 ans 갱신

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        HashMap<Integer,Integer> Ls = new HashMap<>();
        HashMap<Integer,Integer> Rs = new HashMap<>();

        PriorityQueue<Integer> sobang = new PriorityQueue<>();
        PriorityQueue<Integer> revreseSobang = new PriorityQueue<>(Collections.reverseOrder());

        ArrayList<Integer> fire = new ArrayList<>();

        stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            fire.add(Integer.parseInt(stk.nextToken()));
        }

        stk = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++){
            int value = Integer.parseInt(stk.nextToken());
            sobang.add(value);
            revreseSobang.add(value);
        }

        Collections.sort(fire);

        int min_sobang = sobang.poll();
        for (int i=0; i<n; i++){
            int curr = fire.get(i);
            if (min_sobang > curr){
                Ls.put(curr,-1111111111);

            } else {
                while(!sobang.isEmpty() && sobang.peek()<curr){
                    min_sobang = sobang.poll();

                }
                Ls.put(curr,min_sobang);
            }
        }

        int max_sobang = revreseSobang.poll();
        for (int i=n-1; i>=0; i--){
            int curr = fire.get(i);
            if (max_sobang < curr){
                Rs.put(curr,-1111111111);

            } else {
                while(!revreseSobang.isEmpty() && revreseSobang.peek()>curr){
                    max_sobang = revreseSobang.poll();

                }
                Rs.put(curr,max_sobang);
            }
        }

        System.out.println(Ls);
        System.out.println(Rs);

        int ans = 0;
        for (int i=0; i<n; i++){
            int curr = fire.get(i);
            int value = 0;
            if (Ls.get(curr) != -1111111111 && Rs.get(curr) != -1111111111){
                value = Math.max(Math.abs(curr-Ls.get(curr)), Math.abs(curr-Rs.get(curr)));
            }else if (Ls.get(curr) != -1111111111){
                value = Math.abs(curr-Ls.get(curr));
            }else if (Rs.get(curr) != -1111111111){
                value = Math.abs(Rs.get(curr)-curr);
            }
            ans = Math.max(ans, value);
        }

        System.out.println(ans);



    }
}