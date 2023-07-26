import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

import java.util.Arrays;

public class Problem029_MYversion {

    static int A[];

    // 반복문 버전
    static int binSearch(int key, int low, int high) {
        int median;

        while (low <= high) { // low가 high보다 작거나 같으면 반복
            median = (low + high) / 2;

            if (key == A[median]) {
                return 1;
            } else if (key < A[median]) {
                high = median - 1;
            } else {
                low = median + 1;
            }

        }
        return 0;// 실패
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // N을 입력받고 배열 A에 수를 저장하고 배열 A를 정렬
        int N = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        // 검색 할 수들을 정의
        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        int Num[] = new int[M];

        // 해당 숫자가 있는지 없는지를 표시할 Answer배열을 선언
        int Answer[] = new int[M];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            Num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            Answer[i] = binSearch(Num[i], 0, N - 1);
            System.out.println(Answer[i]);
        }

    }
}