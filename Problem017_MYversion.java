import java.util.*;
import java.io.*;

public class Problem017_MYversion {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(str);

        char[] c = str.toCharArray();


        Integer a[] = new Integer[c.length];

        for(int i = 0; i <  a.length; i++){
            a[i] = c[i] - '0';
        }
        
        for(int i = 0 ; i < a.length -1; i++){
            
            int max = a[i];

            for(int j =1; j < a.length; j++){
                if(a[j] > max){
                    max = j;
                }
            }
            
            int tmp = a[max];
            a[max] = a[i];
            a[i] = tmp;
        }

        for(int i =0; i <a.length; i++){
            System.out.println(a[i]);
        }
        }
}
