import java.util.Arrays;

/**
 * @program: QuickSort
 * @description:
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018/9/18
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 1};
        quickSort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }

    public static int partition(int[] number, int start, int end) {
        if (end - start == 0) {
            return -1;
        }
        if (end - start == 1) {
            if (number[start] > number[end]) {
                int temp = number[start];
                number[start] = number[end];
                number[end] = temp;
            }
            return -1;
        }
        int firstNum = number[start];
        int position = start + 1;
        for (int i = start + 1; i <= end; i++) {
            if (number[i] < firstNum) {
                int temp = number[i];
                number[i] = number[position];
                number[position] = temp;
                position++;
            }
        }
        int temp = number[position - 1];
        number[position - 1] = number[start];
        number[start] = temp;
        return position;
    }

    public static void quickSort(int[] numbers, int start, int end) {
        int position = partition(numbers, start, end);
        if (position != -1) {
            quickSort(numbers, start, position - 1);
            quickSort(numbers, position, end);
        }
    }
}