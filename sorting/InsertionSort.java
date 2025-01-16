import java.util.Arrays;
class InsertionSort{
    public static void main(String[] args){
        int num[]= {11, 9, 7, 15, 6, 10, 5, 17};
        int n = num.length;

        for(int i=1;i<n;i++){

            int key = num[i]; 
            int j = i-1;

             /* Shift elements of a[i-1 .... 0], that are greater 
            than key, to one position right of their 
            current position */ 
            while (j >= 0 && num[j] > key)
            {
                num[j + 1] = num[j];
                j = j - 1;
            }
            num[j + 1] = key;
        }

        Arrays.stream(num).forEach(System.out::println);

    }
}