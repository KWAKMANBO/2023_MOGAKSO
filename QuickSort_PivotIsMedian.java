public class QuickSort_PivotIsMedian {

    public static void quicksort(int[] a, int start, int end){
        if(start < end){
            int pivot = partition(a, start, end);

            quicksort(a, start, pivot-1);
            quicksort(a, pivot+1, end);
        }
    }

    public static int partition(int[] a, int left, int right){

        int pivot = a[(left + right)/2];
        int pivotidx = (left + right)/2;
        // swap 중간요소를 맨 오른쪽으로 이동시킴
        int temp = a[right];
        a[right] =pivot;
        a[pivotidx] = temp;

        int i = left-1;

        for(int j=left ; j < right; j++){
            if(a[j] <= pivot){
                i++;
                int tmp = a[j];
                a[j] = pivot;
                a[i] = tmp; 
            }

            temp = a[right];
            a[right] = a[i+1];
            a[i+1] = temp;
            
        }
         return i+1;
    }

    public static void printArr(int[] a){
        for(int i=0; i <  a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = { 9, 7, 5, 11, 12, 2, 14, 3, 10, 6 };
        printArr(a);


        quicksort(a, 0, a.length-1);
        printArr(a);
    
    }

   

}
