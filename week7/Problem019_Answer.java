import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem019_Answer {

    public static void swap(int[] A, int i, int j){
        // 배열 요스를 swap하는 메서드
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static int partition(int[] A, int S, int E){
        if(S+1 == E){ // 입력된 정렬해야할 대상의 갯수가 단 2개라면
            if(A[S] > A[E]){ // A[S]가 A[E]보다크면 정렬해야됨
                swap(A,S,E);
            }
            return E;

        }
        
        //pivot을 반환하고 pivot을 기준으로 정렬해주는 함수
        int M = (S + E)/2; // pivotindex를 배열 중앙 인덱스로 설정
        
        swap(A, S, M); // 중앙 값을 맨 앞으로 이동
        // why? 배열 요소들의 이동을 쉽게하기위해서
        int pivot = A[S]; // pivot과 s를 swap하고 난 후 pivot을 

        int start = S+1;
        int end = E;

        while(start<=end){// start가 end보다 작을경우에만 반복
            while(pivot < A[end] && end >0){
                // A[end]가 pivot보다 작은 index를 찾음
                end--;
            }
            while( start < A.length-1 && pivot > A[start]){
                //A[start]가 pivot보다 크고, end가 start클때 만복
                // A[start]가 pivot보다 큰 index를 찾음
                start++;
             }
            if(start <=end){
            swap(A, start++,end--);
            }
        }

        A[S] = A[end];
        A[end] = pivot;
        return end;

    }

    public static void quickSort(int[] A, int S, int E, int K){
        if(S<E){ // quicksort의 시작 인덱스가, 끝인덱스보다 작다면
            int pivot = partition(A, S, E);

            if(pivot == K){
                return;
            }else if(K < pivot){
                quickSort(A, S, pivot-1, K);
            }else if(K > pivot){
                quickSort(A, pivot+1, E, K);
            }
        }
    }
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(A, 0, N-1, K-1);
        System.out.println(A[K-1]);
    }
}
