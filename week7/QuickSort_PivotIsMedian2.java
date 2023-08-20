public class QuickSort_PivotIsMedian2 {
    
    public static void quickSort(int[] a, int start, int end){
        int pivot = partition( a,  start,  end);

        quickSort(a, start, pivot-1);
        quickSort(a, pivot, end);
    }
    
    public static int partition(int[] a, int start, int end){
        int pivot = a[(start + end)/2];
        
        while(start<end){
            while(a[start] < pivot){
                start++;
            }
            while(a[end] > pivot){
                swap(a, start,end);
                start++;
                end--;
            }
        }
        return start;
    }
    
    public static void swap(int[] a, int s, int e){
        int tmp = a[s];
        a[s] = a[e];
        a[e] = a[s];
    }
    
    public static void main(String[] args){
        int[] a = { 9, 7, 5, 11, 12, 2, 14, 3, 10, 6 };
        
    }
}
