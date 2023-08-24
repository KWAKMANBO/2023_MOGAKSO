import java.io.*;
import java.util.*;

public class Problem020_Answer {
    public static int[] A,tmp; // A는 입력받을 배열, tmp는 정렬할때 사용할 임시 배열
    public static long result;


    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        A = new int[N+1];
        tmp = new int[N+1];

        for(int i = 1; i <=N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        merge_sort(1, N);
        for(int i =1; i <=N; i++){
            bw.write(A[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void merge_sort(int s, int e){
        if(e-s <1){
            return;
        }

        int m = s + (e-s)/2;

        merge_sort(s,m);
        merge_sort(m+1,e);
        for(int  i= s; i<=e; i++){
            tmp[i] = A[i];
        }

        int k = s;
        int index1 = s; // 왼쪽 부분 리스트 시작 인덱스 m은 종료 인덱스
        int index2 = m+1; // 오른족 부분 리스트 시작 인덱스 e는 종료 인덱스

        while(index1 <= m && index2 <=e){
            //  두 그룹을 병합하는 로직 
            // index1과 index2에서의 요소들의 값을 비교해서 작은 값을배열에 저장한 후
            // 선택된 index1 또는 index2의 값을 +1(오른쪽으로 한칸 이동)

            if(tmp[index1] > tmp[index2]){
                A[k] = tmp[index2];
                k++;
                index2++;
            }else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while(index1 <= m){
            A[k] = tmp[index1];
            k++;
            index1++;
        }

        while(index2 <= e){
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
