import java.util.Arrays;

public class demo1 {
    public static void main(String arg[]){
        int[] arr = {8,5,32,2,21,11,7,6,3,9};
        for (int i = 0; i<arr.length-1;i++){
            int min=i;
            for (int j =i+1; j<arr.length;j++){
                if (arr[j]<arr[min]){
                    min = j;
                }
            }
            if (min!=i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;

            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
