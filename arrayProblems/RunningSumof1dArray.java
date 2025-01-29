import java.util.Arrays;

class RunningSumof1dArray{
    public static void main(String[] args){
        int arr[] = {1,2,3,5,6};
        int runsum[] = findRunningSumArray(arr);

        System.out.println("Original Array:- " +Arrays.toString(arr));

        System.out.println("Running Sum Array:- " +Arrays.toString(runsum));
    }

    public static int[] findRunningSumArray(int[] nums){
        int arr[] = new int[nums.length];

        arr[0] = nums[0]; //first sum will be always same;

        for(int i = 1; i< nums.length ; i++){
            arr[i] = arr[i-1] + nums[i]; //arr[i-1] contains sum of previous elements (if i = 2 , arr[2-1] + nums[2] = sum(arr[0]+arr[1]+arr[2]) )
        }
        return arr;
    }
}