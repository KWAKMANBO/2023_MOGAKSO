import java.util.*;
import java.io.*;


// 시간초과로 틀림

public class Problem016_MYversion {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean change =false;

        int n = Integer.parseInt(br.readLine());

        int [] a = new int[n+1];

        for(int i = 1; i <= n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= n ; i++){
            change = false;
            for(int j =1; j <= n - i; j++){
                if(a[j] > a[j+1]){
                    change = true;
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                }
            }
            if(change ==false){
                System.out.println(i);
                break;
            }

        }
    }
}
