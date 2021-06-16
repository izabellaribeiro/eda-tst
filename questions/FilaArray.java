import java.util.Scanner;

public class FilaArray {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = Integer.parseInt(sc.nextLine());
        Fila fila = new Fila(capacity);

        String[] operation;

        while(true) {
            operation = sc.nextLine().trim().split(" ");
            if(operation[0].equals("end")) break;

            else if(operation[0].equals("print"))
                System.out.println(fila.toString());

            else if(operation[0].equals("add")) {
                if(!fila.add(Integer.parseInt(operation[1]))) {
                    System.out.println("full");
                }
            }
            else if(operation[0].equals("element"))
                System.out.println(fila.element());

            else if(operation[0].equals("remove"))
                if(!fila.remove())
                    System.out.println("empty");



        }
    }

}

class Fila{

    int[] fila;
    int capacidade;
    int ultimo;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.fila = new int[capacidade];
        this.ultimo = -1;
    }

    public String element() {
        if(ultimo > -1)
            return Integer.toString(fila[0]);
        return "empty";
    }

    public String toString() {
        String saida = "empty";
        if(this.ultimo > -1) {
            saida = "";
            for(int i = 0; i <= ultimo; i++) {
                saida += Integer.toString(fila[i]) + " ";
            }
        }

        return saida.trim();
    }

    public boolean add(int n) {

        if(ultimo < capacidade - 1) {
            this.ultimo++;
            fila[ultimo] = n;
            return true;
        }

        return false;
    }

    public boolean remove() {

        if(ultimo > -1) {
            for(int i = 0; i < ultimo; i++) {
                fila[i] = fila[i+1];
            }
            ultimo--;
            return true;
        }

        return false;
    }
}
