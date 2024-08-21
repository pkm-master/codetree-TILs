import java.io.*;
import java.util.*;

class Point implements Comparable<Point>{
    int x, idx;

    public Point(int x, int idx){
        this.x = x;
        this.idx = idx;
    }

    @Override
    public int compareTo(Point p){
        return this.x-p.x;
    }
    
}

public class Main {
    public static void main(String[] args) throws IOException {
        // 겹친다 : 해당선분의 x1보다 큰 x1을 지니는 동시 y1보다 작은 y1을 지니는 선분이 존재
        // 맨끝에서 부터 시작해서
        // 남의 end를 만나기전에 자기 end를 만나는데 성공하면
        // end의 left가 start보다 크기가 크면 괜찮은 
        // Ls : 특정 점의 왼쪽에 있는 것중 가장 가까운 endpoint의 좌표
        
        // 어떤 st점에서 시작했을때 그 st보다 크거나 같은 end가 같은 line -> 안겹침

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Point> startPoints = new TreeSet<>();
        TreeSet<Point> endPoints = new TreeSet<>();
        HashMap<Point,Point> lines = new HashMap<>();
        HashMap<Point,Point> reverseLines = new HashMap<>();

        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());

            Point start = new Point(x1,i);
            Point end = new Point(x2,i);

            startPoints.add(start);
            endPoints.add(end);
            lines.put(start,end);
            reverseLines.put(end,start);

        }

        ArrayList<Point> points = new ArrayList<>(startPoints);

        int ans = 0;
        int i = 0;
        while (0<i&& i<points.size()){
            Point nearEnd = endPoints.ceiling(points.get(i));
            if (nearEnd.idx == points.get(i).idx) {
                ans++;
                i++;
            }
            else {
                Point nextEnd = endPoints.higher(lines.get(points.get(i)));
                i = points.indexOf(reverseLines.get(nextEnd));

            }
        }

        System.out.println(ans);
    }
}