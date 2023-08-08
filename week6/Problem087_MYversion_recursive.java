package week6;
import java.util.*;
import java.io.*;

public class Problem087_MYversion_recursive {
    static int D[];

    static int recursive(int n){
        if(D[n] != -1){
            return D[n];
        }
        return recursive(n-1) + recursive(n-2);

    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        D = new int[n+1];

        D[1] = 1;
        D[2] = 2;
        
        // 재귀 버전
        for(int i =3; i <= n; i++){
            D[i] = -1;
        }

        int a = recursive(n);
        System.out.println(a%10007);
    }
}
