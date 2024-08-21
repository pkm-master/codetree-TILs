import java.io.*;
import java.util.*;

class Point implements Comparable<Point>{
    int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p){
        if (p.x != this.x) return this.x - p.x;
        else return this.y - p.y;
    }
}

class Tuple{
    int x1,y1,x2,y2;
    public Tuple(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}

public class Main {
    public static int n,q;
    public static Point[] points;
    public static Tuple[] queries;
    
    public static TreeSet<Integer> nums = new TreeSet<>();
    public static HashMap<Integer, Integer> mapper = new HashMap<>();
    
    public static int[][] prefix;
    
    public static int count(int x1, int y1, int x2, int y2){
        return prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1] + prefix[x1-1][y1-1];
    }

    public static int lowerBound(int x){
        if (nums.ceiling(x) != null) return mapper.get(nums.ceiling(x));
        return nums.size()+1;
    }

    public static int upperBound(int x){
        if (nums.floor(x) != null) return mapper.get(nums.floor(x));
        return 0;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        q = Integer.parseInt(stk.nextToken());
        points = new Point[n];
        queries = new Tuple[q];
    
        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            points[i] = new Point(x,y);

            nums.add(x);
            nums.add(y);
        }

        for (int i=0; i<q; i++){
            stk = new StringTokenizer(br.readLine());
            queries[i] = new Tuple(Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken()));
        }

        // 좌표압축
        int cnt=1;
        for (int num:nums){
            mapper.put(num, cnt);
            cnt++;
        }


        // 누적합 배열 구축
        prefix = new int[cnt+1][cnt+1];

        for (int i=0; i<n; i++){
            int x = points[i].x;
            int y = points[i].y;

            int mapX = mapper.get(x);
            int mapY = mapper.get(y);

            prefix[mapX][mapY] = 1;
        }

        for (int i=1; i<=cnt; i++){
            for (int j=1; j<=cnt; j++){
                prefix[i][j] += prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }


        // 점개수 구하기

        for (int i=0; i<q; i++){
            int mapX1 = lowerBound(queries[i].x1);
            int mapY1 = lowerBound(queries[i].y1);
            int mapX2 = upperBound(queries[i].x2);
            int mapY2 = upperBound(queries[i].y2);

            System.out.println(count(mapX1, mapY1, mapX2, mapY2));

        }



    }
}