import java.util.Arrays;

public class demo2 {
    public static void main(String arg[]){
        int[] arr = {8,5,32,2,21,11,7,6,3,9};
        int temp;
        for (int i = 0; i<arr.length;i++){
            for (int j =arr.length-1;j>i;j--){
                if (arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j]= temp;
                }
            }
        }
        System.out.print(Arrays.toString(arr));
    }
}
