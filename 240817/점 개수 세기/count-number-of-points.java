import java.io.*;
import java.util.*;

class Line{
    int s, e;
    public Line(int s, int e){
        this.s = s;
        this.e = e;
    }
}
// n개의 점, q개의 질의에 대해 구간 내의 점 개수 출력
public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        HashSet<Integer> points_hash = new HashSet<>();

        int[] points = new int[n];
        for (int i=0; i<n; i++){
            int point = Integer.parseInt(stk.nextToken());
            points[i] = point;
            points_hash.add(point);
        }

        // q개의 질의에 대해 각 구간내에 놓인 점의 개수를 한줄에 하나씩
        // 이 방식으로 구현시 주어진 구간의 시작이 겹치면 이슈 발생

        HashSet<Integer> hash = new HashSet<>();
        Line[] lines = new Line[q];

        for (int i=0; i<q; i++){
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            hash.add(s);
            hash.add(e);
            lines[i] = new Line(s,e);
        }

        ArrayList<Integer> linespoint = new ArrayList<>(hash);
        Collections.sort(linespoint);

        HashMap<Integer,Integer> point_n = new HashMap<>();
        int number = 0;

        for (int i=0; i<linespoint.size(); i++){
            int p = linespoint.get(i);
            while (number<n && points[number] < p){;
                number++;
            }
            point_n.put(p, number);
        }

        for (int j=0; j<q; j++){
            int s = lines[j].s;
            int e = lines[j].e;
            int ans = point_n.get(e) - point_n.get(s);
            if (points_hash.contains(e)) ans +=1;

            System.out.println(ans);

        }

        // System.out.println(point_n);

    }

}