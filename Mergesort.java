// TopDown 방식

public class Mergesort {

    static int[] sorted; // 정렬 원소를 배울 임시배열

    public static void mergesort(int[] a, int left, int right) {
        if (left == right) {
            // 원소가 1개, 더이상 쪼갤 수 x
            return;
        }

        int mid = (left + right) / 2; // 배열의 가운데 index

        mergesort(a, left, mid); // 왼쪽 부분 리스트
        mergesort(a, mid + 1, right); // 오른쪽 부분 리스트

        merge(a, left, mid, right); // 병합
    }

    public static void merge(int[] a, int left, int mid, int right) {
        int l = left; // 왼쪽 부분리스트의 시작점
        int r = mid + 1; // 오른쪽 부분리스트의 시작점
        int idx = left; // 채워넣을 배열의 인덱스

        while (l <= mid && r <= right) {

            // l과 r이 다 merge될때까지 반복
            if (a[l] <= a[r]) {
                // a[l]을 sorted에 삽입
                sorted[idx] = a[l];
                idx++;
                l++;
            } else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        if (l > mid) {
            // 왼쪽 부분 리스트가 sorted에 먼저 다 채워져 있는 경우
            // --> 오른족 리스트에 남아있는 것들을 다 채워줘야함
            while (r <= right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        } else {
            // 오른쪽 부분 리스트가 sorted에 먼저 다 채워져 있는 경우
            // --> 왼쪽 리스트에 남아있는 것들을 다 채워줘야함
            while (l <= mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }

        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];

        }

    }

    public static void main(String[] args) {
        int[] a = { 42, 32, 24, 60, 15, 5, 90, 45 };
        // int[] a = {1, 2, 3, 4, 15, 5, 90, 45};

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        sorted = new int[a.length];
        mergesort(a, 0, a.length - 1);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
