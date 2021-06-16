import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int len = Integer.parseInt(sc.nextLine());
        HashSet hashSet = new HashSet(len);

        String[] entrada;


        while(true){

            entrada = sc.nextLine().trim().split(" ");

            if (entrada[0].equals("end")){break;}

            String comando = entrada[0];
            int valor = Integer.parseInt(entrada[1]);

            //menu
            if (comando.equals("put")){
                hashSet.put(valor);
            }
            else if (comando.equals("remove")){
                hashSet.remove(valor);
            }
            else{
                System.out.println(hashSet.contains(valor));
            }
        }
    }
    static class HashSet{

        private Integer[] values;
        private int size;
        int hash;

        public HashSet(int len){
            this.values = new Integer[len];
        }

        private int hash(int element) {
            return element % this.values.length;
        }

        public void put(int element) {

            int sondagem = 0;

            while(sondagem < this.values.length){

                hash = (hash(element) + sondagem) % this.values.length;

                if(!contains(element) && !podeAdd(element)){
                    this.values[hash] = element;
                    this.size += 1;
                    break;
                }

                sondagem += 1;
            }

            toArray();
        }

        private boolean podeAdd(int element) {
            if (this.values[this.hash] != null) {
                return true;
            }
            return false;
        }

        public void remove(int element) {
            int sondagem = 0;

            while(sondagem < this.values.length) {
                hash = (hash(element) + sondagem) % this.values.length;

                if (this.values[hash] != null && this.values[hash] == element) {
                    this.values[hash] = null;
                    this.size -= 1;
                    break;
                }

                sondagem += 1;
            }

            toArray();
        }

        public boolean contains(int element){
            for (int i = 0; i < this.values.length; i++) {
                if (this.values[i] != null && this.values[i] == element){
                    return true;
                }
            }
            return false;
        }

        private void toArray(){
            System.out.println(Arrays.toString(this.values));
        }
    }
}
