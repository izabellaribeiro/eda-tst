import java.util.Scanner;

class PilhaArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int capacity = Integer.parseInt(sc.nextLine());
        Pilha pilha = new Pilha(capacity);

        String[] operation;

        while(true) {
            operation = sc.nextLine().trim().split(" ");

            if(operation[0].equals("end")) break;

            else if(operation[0].equals("peek"))
                System.out.println(pilha.peek());

            else if(operation[0].equals("print"))
                System.out.println(pilha.toString());

            else if(operation[0].equals("push")) {
                if(!pilha.push(Integer.parseInt(operation[1])))
                    System.out.println("full");
            }
            else if(operation[0].equals("pop")) {
                if(!pilha.pop())
                    System.out.println("empty");
            }

        }
    }

}

class Pilha{
    int[] pilha;
    int capacity;
    int top;

    public Pilha(int capacity) {
        this.capacity = capacity;
        this.pilha = new int[capacity];
        this.top = -1;
    }

    public String peek() {
        if(top > -1)
            return Integer.toString(pilha[top]);
        return "empty";
    }

    public String toString() {
        String saida = "empty";

        if(top > -1) {
            saida = "";
            for(int i = 0; i <= top; i++) {
                saida += Integer.toString(pilha[i]) + " ";
            }
        }

        return saida.trim();
    }

    public boolean push(int n) {
        if(top < capacity - 1) {
            top++;
            pilha[top] = n;
            return true;
        }
        return false;
    }

    public boolean pop() {

        if(top > -1) {
            top--;
            return true;
        }

        return false;
    }
}