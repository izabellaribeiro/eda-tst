import java.util.Arrays;
import java.util.Scanner;

class InsereUltimoOrdenado {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            String[] valuesString = sc.nextLine().split(" ");
            int[] values = new int[valuesString.length];

            for (int i = 0; i < valuesString.length; i++) {
                values[i] = Integer.parseInt(valuesString[i]);
            }

            int leftIndex = 0;
            int rightIndex = values.length;
            insertionSort(values, leftIndex, rightIndex);
        }

        private static void insertionSort(int[] array, int leftIndex, int rightIndex) {
            if (rightIndex == 1 || array.length == 0 || rightIndex < leftIndex) { return; }

            for (int i = 1; i < array.length; i++) {

                int j = i;

                while (j > 0 && array[j]< array[j - 1]) {
                    int aux = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = aux;
                    j--;
                }
            }

            System.out.println(Arrays.toString(array));
        }
}
