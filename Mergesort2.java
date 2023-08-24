public class Mergesort2 {

    static int sorted[]; // 정렬과정을 저장할 새로운 임시배열
    
    public static void mergesort(int[] a, int left, int right){
        
        for(int size =1; size <= right; size +=size){
            // 부분 리스트의 크기를 나타내는 변수 size
            // loop가 한번 씩 돌때마다 크기가 2배가됨
            // ex) 

            for(int l =0; l<=right - size; l +=(2*size)){
                int low =l;
                int mid = l + size -1;
                int high = Math.min(l+(2*size)-1, right);
                // 부분 리스트의 크기가 1일때  l : 0 , r : 1
                // 부분 리스트의 크기가 2일때  l : 0,  r : 3
                // 부분 리스트의 크기가 3일때  l : 0,  r : 5..
                merge(a,low,mid,high);
            }

        }

    }
    public static void merge(int[] a, int left, int mid, int right){
        int l = left; // 왼쪽 부분리스트의 시작점
        int r = mid +1; // 오른쪽 부분리스트의 시작점
        int idx = left; // 채워넣을 배열의 인덱스

        while( l <= mid && r<= right){
        
            // l과 r이 다 merge될때까지 반복
            if(a[l] <= a[r]){
                // a[l]을 sorted에 삽입 
                sorted[idx] = a[l];
                idx++;
                l++;
            }else{
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        } 

        if(l > mid){
            // 왼쪽 부분 리스트가 sorted에 먼저 다 채워져 있는 경우
            // --> 오른족 리스트에 남아있는 것들을 다 채워줘야함
           while(r <= right){
            sorted[idx] = a[r];
            idx++;
            r++;
           }
        }else{
            // 오른쪽 부분 리스트가 sorted에 먼저 다 채워져 있는 경우
            // --> 왼쪽 리스트에 남아있는 것들을 다 채워줘야함
            while(l <= mid){
            sorted[idx] = a[l];
            idx++;
            l++;
            }
        }

        for(int i = left; i <= right; i++){
            a[i] = sorted[i];

        }

    }


    public static void main(String[] args){
        int[] a = {42, 32, 24, 60, 15, 5, 90, 45};

        sorted = new int[a.length];


        for(int i =0; i < a.length; i++){
           System.out.print(a[i] + " ");
       }
       System.out.println();
       mergesort(a, 0, a.length-1);

        for(int i =0; i < a.length; i++){
           System.out.print(a[i] + " ");
       }
       System.out.println();
    }
}
