import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Integer> selected;
    public static int n;
    public static boolean end;

    public static boolean isPossible(){
        for (int i=1; i<=n/2; i++){
            for (int j=0; j<n-1; j++){
                List<Integer> list1 = selected.subList(j,j+i);
                List<Integer> list2 = selected.subList(j+i,j+2*i);
                boolean isSame = true;
                for (int k=0; k<i; k++){
                    if (list1.get(k) != list2.get(k)){
                        isSame=false;
                        break;
                    }
                }
                if(isSame){
                    return false;
                }

            }
        }


        return true;
    }

    public static void dfs(int idx){
        if (end){
            return;
        }

        if (idx == n){
            if (isPossible()){
                for (int i=0; i<n; i++){
                    System.out.print(selected.get(i));
                }
                end = true;
            
            }
            return;
        }
        
        for (int i=4; i<=6; i++){
            selected.add(i);
            if (!end){
                dfs(idx+1);
            }
            selected.remove(selected.size()-1);

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        selected = new ArrayList<>();

        dfs(0);

    }
}