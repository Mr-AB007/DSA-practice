import java.util.Arrays;

class SelectionSort{
    public static void main(String args[]){
        int num[] = {3,5,7,8,90,2,0,1,6};

        selectionSort(num,num.length);

        Arrays.stream(num).forEach(System.out::println);
    }
    public static void selectionSort(int num[], int n) {
        for (int i = 0; i < n; i++) {
            int min_index = i;  // Store index of the minimum element
    
            for (int j = i + 1; j < n; j++) {
                if (num[j] < num[min_index]) {
                    min_index = j;
                }
            }
    
            // Swap only if min_index is different from i
            if (min_index != i) {
                int temp = num[i];
                num[i] = num[min_index];
                num[min_index] = temp;
            }
        }
    }
    
}