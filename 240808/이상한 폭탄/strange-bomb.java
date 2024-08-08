import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        ArrayList<Integer> boms = new ArrayList<>();

        for(int i=0; i<n; i++){
            boms.add(Integer.parseInt(br.readLine()));
        }

        HashMap<Integer,Integer> logs = new HashMap<>();
        int max_bom = 0;
        for (int i=0; i<n; i++){
            int bom = boms.get(i);
            if (logs.containsKey(bom)){
                if (i-logs.get(bom)<=k){
                    if (bom > max_bom) max_bom = bom;
                }
                logs.replace(bom, i);
            }else{
                logs.put(bom,i);
            }
        }
        System.out.println(max_bom);
    }
}