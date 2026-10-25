import java.util.Arrays;

public class RadixSort {

    public static void radixSort(int[] numbers) {
        if (numbers.length == 0) {
            return;
        }

        int max=0;

        for (int number : numbers){
            if (number < 0){
                throw new IllegalArgumentException(
                        "This version supports only non-negative integers."
                );
            }
            max=Math.max(max, number);
        }

    for(long place = 1; max / place > 0; place *=10){
        sortByDigit(numbers,place);
        System.out.println("After sorting by place " + ": " + Arrays.toString(numbers));
    }
    }
    private static void sortByDigit(int[] numbers, long place){
        int[] output = new int[numbers.length];
        int[] counts = new int[10];

        //count ocurrences of each digit.
        for (int number : numbers){
            int digit = (int)((number / place) % 10);
            counts[digit]++;
        }

        //Convert counts into cumulative counts.
        // counts[d] now tells us how manz digits are <= d.
        for (int digit = 1; digit < counts.length; digit++){
            counts[digit] += counts[digit - 1];
        }

        // Tranverse backwards to preserve the order of equal digits.
        for (int i = numbers.length - 1; i>=0; i--){
            int digit =(int) ((numbers[i] / place) % 10);
            output[counts[digit] -1] = numbers[i];
            counts[digit]--;
        }

        // Copy the result back into the original array.
        System.arraycopy(output, 0, numbers, 0, numbers.length);
    }

    public static void main(String[] args){
        int [] numbers = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("Before: "+ Arrays.toString(numbers));

        radixSort(numbers);

        System.out.println("After: " + Arrays.toString(numbers));
    }

}