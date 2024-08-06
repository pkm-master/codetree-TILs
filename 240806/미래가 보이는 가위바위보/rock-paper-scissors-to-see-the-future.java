import java.io.*;
import java.util.*;

public class Main {
    public static int RSP(String a, String b){
        if (a.equals("S") && b.equals("H")) return 1;
        else if (a.equals("P") && b.equals("S")) return 1;
        else if (a.equals("H") && b.equals("P")) return 1;
        else return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] logs = new String[n];
        int[] LH = new int[n];
        int[] RH = new int[n];
        int[] LS = new int[n];
        int[] RS = new int[n];
        int[] LP = new int[n];
        int[] RP = new int[n];

        for (int i=0; i<n; i++){
            String value = br.readLine();
            logs[i] = value;
            if (i==0){
                LH[i] = RSP(value,"H");
                LS[i] = RSP(value,"S");
                LP[i] = RSP(value,"P");
            }else{
                LH[i] = LH[i-1] + RSP(value, "H");
                LS[i] = LS[i-1] + RSP(value, "S");
                LP[i] = LP[i-1] + RSP(value, "P");
            }
        }


        for (int i=n-1; i>=0 ; i--){
            if (i==n-1){
                RH[i] = RSP(logs[i],"H");
                RS[i] = RSP(logs[i],"S");
                RP[i] = RSP(logs[i],"P");
            }else{
                RH[i] = RH[i+1] + RSP(logs[i],"H");
                RS[i] = RS[i+1] + RSP(logs[i],"S");
                RP[i] = RP[i+1] + RSP(logs[i],"P");
            }
        }

        int max_value = 0;

        for (int i=0; i<n; i++){
            int partial;
            if(i==n-1){
                partial = Math.max(Math.max(LH[i],LS[i]),LP[i]);
            }else{
                int Lmax = Math.max(Math.max(LH[i],LS[i]),LP[i]);
                int Rmax = Math.max(Math.max(RH[i+1],RS[i+1]),RP[i+1]);
                partial = Lmax + Rmax;
            }
        
            if (max_value<partial) max_value=partial;
        }

        System.out.println(max_value);
    }
}