import java.util.Scanner;


class TeoremaMestre {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");
        System.out.println(theta(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2])));

    }

    private static String theta(int chamadasRecursivas, int tamSubproblema, int ordemFuncao) {
        int log = (int) (Math.log(chamadasRecursivas) / Math.log(tamSubproblema));
        if (log < ordemFuncao) {
            return "T(n) = theta(n**" + ordemFuncao + ")";
        } else if (log > ordemFuncao) {
            return "T(n) = theta(n**" + log + ")";
        }
        return "T(n) = theta(n**" + ordemFuncao + " * log n)";
    }
}