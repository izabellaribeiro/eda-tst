import java.util.Arrays;
import java.util.Scanner;

class SelectionRecursivo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] valuesString = sc.nextLine().split(" ");
        int[] values = new int[valuesString.length];

        for (int i = 0; i < valuesString.length; i++) {
            values[i] = Integer.parseInt(valuesString[i]);
        }

        int start = 0;
        int end = values.length;
        selectionRecursive(values, start, end);
    }

    private static void selectionRecursive(int[] array, int start, int end) {
        if (start == array.length - 1 || array.length == 0 || start > end) {
            return ;
        }

        int lowestIndex = start;

        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < (array[lowestIndex])) {
                lowestIndex = i;
            }
        }

        int temp = array[start];
        array[start] = array[lowestIndex];
        array[lowestIndex] = temp;

        System.out.println(Arrays.toString(array));
        selectionRecursive(array, start + 1, end);
    }
}
