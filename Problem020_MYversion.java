import java.util.*;
import java.io.*;

public class Problem020_MYversion {
    static int[] sorted; // 정렬에 사용할 임시 배열

    public static void mergesort(int[] a, int left, int right){
        if(left==right){
            return;
        }

        int mid = (left + right)/2;

        mergesort(a, left, mid);
        mergesort(a, mid+1, right);

        merge(a, left,mid,right);

    }

    public static void merge(int[] a, int left, int mid, int right){
        int l = left; // 왼쪽 부분리스트의 시작점
        int r = mid +1; // 오른쪽 부분리스트의 시작점
        int idx = left; // sorted에 삽입할 인덱스

        while(l <= mid && r <=right){
            // l이 mid에 도달할때까지 또는 r이 right에 도달할때까지 loop를 반복
            if(a[l] <= a[r]){
                // a[l]이 a[r]보다 작다면 a[l]을 sorted에 추가
                sorted[idx] = a[l];
                idx++;
                l++;
            }else if(a[l] > a[r]){
                // // a[r]이 a[l]보다 작다면 a[r]을 sorted에 추가
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }
        // while문이 종료되면 왼쪽 부분 리스트 전체가 또는 오른쪽 부분 리스트의 전체가 sorted에 추가되었음

        if(l > mid){
            //  왼쪽 부분리스트가 sorted에 먼저 다 추가되었다면
            // 나머지 오른쪽 부분 리스트의 요소들을 sorted에 추가하기
            while(r <= right){
              sorted[idx] = a[r];
                idx++;
                r++;
            }
        }else{
            // 오른쪽 부분리스트가 sorted에 먼저 다 추가되있는 경우
            // 왼쪽 부분 리스트의 나머지를 sorted에 추가하기 
            while(l <=mid){
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }

        for(int i = left; i <= right; i ++){
            a[i] = sorted[i];
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        sorted = new int[n];

        for(int i = 0; i < n ; i ++){
            a[i] = Integer.parseInt(br.readLine());
        }
        
        
        mergesort(a, 0, a.length-1);

        for(int i =0; i < n; i++){
            bw.write(a[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
