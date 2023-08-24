//Insertion Sort 예제

public class InsertioSort {
    
    static void insertionSort(int[] arr){
        int n =  arr.length;

        for(int i = 1;  i < n; i++){
            int key = arr[i];

            int j = i-1;

            while(j >=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;

        }
        }
    public static void main(String[] args){
    int[] a = new int[10];

    for(int i =0; i <10; i++){
        a[i] = (int)((Math.random()*100)+1);
        System.out.print(a[i] + " ");
    }
    
    System.out.println();

    insertionSort(a);

    for(int value : a){
        System.out.print(value + " ");
    }

    }
}
