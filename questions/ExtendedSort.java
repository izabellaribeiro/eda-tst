import java.util.Arrays;
import java.util.Scanner;

class CountingSortExtend {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        int k = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[sequencia.length];
        for (int i=0; i<sequencia.length; i++) {
            a[i] = Integer.parseInt(sequencia[i]);
        }

        countingSortExtend(a, k, m);
        sc.close();
    }

    private static void countingSortExtend(int[] a, int k, int m) {

        int[] b = a.clone();
        int[] c = new int[k-m+1];

        for (int i = 0; i < a.length; i++) {
            c[a[i]-m] += 1;
            System.out.println(Arrays.toString(c));
        }

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }

        System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(c));

        for (int i = a.length-1; i > -1; i--) {
            a[c[b[i]-m]-1] = b[i];
            c[b[i]-m] -= 1;
        }

        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(a));

    }

}