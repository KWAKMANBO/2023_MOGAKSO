import java.util.*;
import java.io.*;

public class Problem021_Answer {

    public static int[] A, tmp;
    public static long result;
        
    public static void printArray(int[] a){
    for(int i =0; i < a.length; i++){
        System.out.print(a[i] +" ");
     }
     System.out.println();
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        tmp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i <N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        result =0;
        merge_sort(0, N-1);
        System.out.println(result);

    }

    public static void merge_sort(int s, int e){
        // s는 start, e는 end
        if (e == s){
            return;
        }

        int m = s + (e -s )/2;
        merge_sort(s, m );
        merge_sort(m +1, e);

        printArray(tmp);

        for(int i =s; i <=e; i ++){
            tmp[i] = A[i];
        }


        int k =s;
        int l = s; // 왼쪽 부분리스트의 시작 인덱스
        int r= m +1; // 오른쪽 부분 리스트의 시작 인덱스

        while(l <=m && r <= e){
            if(tmp[l] >  tmp[r]){
                A[k] = tmp[r];
                result = result + r -k;
                k++;
                r++; 
            }else{
                A[k] = tmp[l];
                k++;
                l++;
            }
        }

        while( l <= m){
            A[k] = tmp[l];
            k++;
            l++;
        }
        while( r<=e){
            A[k] = tmp[r];
            k++;
            r++;
        }

        //printArray(A);

    }
}

