import java.util.Arrays;
import java.util.Scanner;

class CountingSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        int k = sc.nextInt();

        int[] a = new int[sequencia.length];
        for (int i=0; i<sequencia.length; i++) {
            a[i] = Integer.parseInt(sequencia[i]);
        }

        countingSort(a, k);
        sc.close();
    }

    private static void countingSort(int[] a, int k) {

        int[] b = a.clone();
        int[] c = new int[k+1];

        for (int i = 0; i < a.length; i++) {
            c[a[i]] += 1;
            printArray(Arrays.toString(c));
        }

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }

        printArray("Cumulativa do vetor de contagem - " + Arrays.toString(c));

        for (int i = a.length-1; i > -1; i--) {
            a[c[b[i]]-1] = b[i];
            c[b[i]] -= 1;
        }

        printArray(Arrays.toString(c));
        printArray(Arrays.toString(a));

    }

    private static void printArray(String text) {
        System.out.println(text.replace("]", "").replace(",", "").replace("[", "").trim());
    }
}