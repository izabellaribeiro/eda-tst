import java.util.Scanner;

class MaxHeap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] heap = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            heap[i] = Integer.parseInt(input[i]);
        }

        MaxHeap maxHeap = new MaxHeap(heap);
        System.out.println(maxHeap.isMax());
    }

    private int[] heap;
    private int tail;

    public MaxHeap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
    }

    private int left(int i) {
        return 2*i+1;
    }

    private int right(int i) {
        return (i+1)*2;
    }

    public boolean isMax() {
        for (int i = 0; i < this.heap.length; i++) {
            int left = left(i);
            int right = right(i);

            if (left <= this.tail && this.heap[left] > this.heap[i]){
                return false;
            }
            if (right <= this.tail && this.heap[right] > this.heap[i]) {
                return false;
            }
        }
        return true;
    }
}
