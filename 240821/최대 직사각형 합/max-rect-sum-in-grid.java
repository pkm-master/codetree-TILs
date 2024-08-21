// -1000이상 1000이하의 숫자로 이루어진 n*n크기의 2차원 격자
// 격자를 벗어나지 않는 적절한 직사각형중 사각형 내 숫자들의 합이 최대가 되도록
import java.io.*;
import java.util.*;
class Tuple{
    int i,j;

    public Tuple(int i, int j){
        this.i = i;
        this.j = j;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] prefix = new int[n+1][n+1];
        int[][] original = new int[n][n];
        int[] dir_i = {1,0};
        int[] dir_j = {0,1};


        for (int i=1; i<=n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++){
                original[i-1][j-1] = Integer.parseInt(stk.nextToken());
                prefix[i][j] = prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+original[i-1][j-1];

            }
        }

        int ans = -1000*300*300;

        for (int i1=1; i1<=n; i1++){
            for (int j1=1; j1<=n; j1++){
                // bfs로 해당 칸에서 출발했을때 가능한 최댓값 찾기
                boolean[][] visited = new boolean[n+1][n+1];

                Queue<Tuple> q = new LinkedList<>();
                int part_ans = original[i1-1][j1-1];
                q.add(new Tuple(i1+1,j1));
                q.add(new Tuple(i1,j1+1));
                while (!q.isEmpty()){
                    Tuple curr = q.poll();
                    // System.out.println("curr : " + curr.i + " " + curr.j);
                    
                    for (int i=0; i<2; i++){
                        Tuple next = new Tuple(curr.i + dir_i[i], curr.j + dir_j[i]);
                        if (next.i<=n && next.j<=n && !visited[next.i][next.j] ){
                            int sum = prefix[next.i][next.j]-prefix[next.i][j1-1]-prefix[i1-1][next.j]+prefix[i1-1][j1-1];
                            part_ans = Math.max(part_ans,sum);
                            if (sum == part_ans) {
                                q.add(next);
                                visited[next.i][next.j] = true;
                            };
                        }
                    }

                }

                ans = Math.max(ans,part_ans);

            }
        }

        System.out.println(ans);

    }

}