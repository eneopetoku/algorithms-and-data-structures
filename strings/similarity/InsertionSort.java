import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] numbers){

        for (int i = 1; i< numbers.length; i++){
            int current = numbers[i];
            int j = i -1;

            while(j>=0 && numbers[j]>current){
                numbers[j+1]= numbers[j];
                j--;
            }

            numbers[j + 1]= current;

        }
    }

    public static void main(String[] args){
        int[] numbers= { 5, 4, 7, 3, 2 ,9, 1};
        System.out.println("Before: "+ Arrays.toString(numbers));
        insertionSort(numbers);
        System.out.println(@)
    }

}