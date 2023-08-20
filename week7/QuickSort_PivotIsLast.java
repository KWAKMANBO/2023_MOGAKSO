public class QuickSort_PivotIsLast {

    public static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int pivot = partition(a, start, end);

            quickSort(a, start, pivot - 1);
            quickSort(a, pivot + 1, end);
        }
    }

    public static int partition(int[] a, int left, int right) {
      

        int pivot = a[right];
        int end = right - 1;
        int start = left;

        while (start <= end) {
            while (start <= end && a[start] < pivot) {
                start++;
            }
            while (start <= end && a[end] > pivot) {
                end--;

            }

            if (start < end) {
                // swap
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
                start++;
                end--;
            }
        }

        // swap
        int temp = a[right];
        a[right] = a[start];
        a[start] = temp;

        return start;

    }

    public static void main(String[] args) {
        int[] array = { 6, 2, 8, 1, 5, 3, 7, 4 };
        int n = array.length;

        System.out.println("Original Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        quickSort(array, 0, array.length - 1);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
