import java.util.Hashtable;
import java.util.Scanner;

class WordCloud {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] phrase = sc.nextLine().split(" ");

        Hash hashTable = new Hash(phrase);
        hashTable.put();

        while(true) {
            String entrada = sc.nextLine().trim();
            if (entrada.equals("fim")){
                break;
            }
            System.out.println(hashTable.get(entrada));
        }

    }

    static class Hash {

        String[] phrase;
        Hashtable<String, Integer> words = new Hashtable<>();

        public Hash(String[] phrase) {
            this.phrase = new String[phrase.length];
            this.phrase = phrase;
        }

        public void put(){
            for (String word : phrase) {
                if(words.containsKey(word)){
                    int value = words.get(word) + 1;
                    words.put(word, value);
                }
                else{
                    words.put(word, 1);
                }
            }
        }

        public int get(String key) {
            if (words.containsKey(key)){
                return words.get(key);
            }
            return -1;
        }
    }
}
