import java.util.*;
import java.io.*;

public class Problem017_MYversion {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine(); //문자열로 저장

        char[] c = str.toCharArray(); // 문자열을 문자 배열로 변경


        int a[] = new int[c.length]; // int배열을 선언 오름차순으로 정렬하기위해서

        for(int i = 0; i <  c.length; i++){
            a[i] = c[i] - '0';
        }

        for(int i = 0; i < a.length; i++){
            
            int max=i;
            
            for(int j=i+1; j < a.length; j++){
                if( a[j] > a[max] ){
                    max = j;
                }
            }

            System.out.println("a[max] : " + a[max] + " , a[i] : " + a[i]);
            int tmp = a[max];
            a[max] = a[i];
            a[i] = tmp;

        }

        for(int i =0; i <a.length; i++){
            System.out.print(a[i]);
        }
        System.out.println();
        }
}
