import java.io.*;
import java.util.*;

public class Main {
    public static String eq;
    public static int minimumCalc(int curr, char way, int target){
        if (way == '-'){
            return curr - target;
        }else if (way == '*'){
            return curr * target;
        }else{
            return curr + target;

        }
    }
    public static int calc(){
        int currIdx = 0;
        int ans = alphaToNum(eq.charAt(currIdx));
        
        currIdx++;

        while (currIdx<eq.length()){
            char calcWay = eq.charAt(currIdx);
            currIdx++;
            int target = alphaToNum(eq.charAt(currIdx));
            currIdx++;
            ans = minimumCalc(ans, calcWay, target);
            
        }

        return ans;

    }
    public static int alphaToNum(char alpha){
        
        return selected[(int)alpha - (int)'a'];

    }
    public static int maxVal;
    public static int[] selected = new int[6];
    public static void dfs(int idx){
        if (idx == 6){
            int result = calc();
            maxVal = Math.max(maxVal, result);

        }else{
            for (int i=1; i<=4; i++){
                selected[idx] = i;
                dfs(idx+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        eq = br.readLine();
        maxVal = -Integer.MIN_VALUE;

        dfs(0);
        
        System.out.println(maxVal);
    }
}