public class SelectionSort {
    public static void main(String[] args){
        

        int[] a = new int[10];
        
        for( int i = 0; i <10; i++){
            a[i] = (int)((Math.random()*100) +1);
        }

         for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

        System.out.println();

        for(int i =0; i < 10; i++){
            
            int min = a[i];
            int index = i;

            for(int j = i + 1; j < 10; j ++){
                if(a[j] < min){
                    min = a[j];
                    index = j;
                }
            }

            int tmp = a[i];
            a[i] = min;
            a[index] = tmp;

        }

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

    }
}
