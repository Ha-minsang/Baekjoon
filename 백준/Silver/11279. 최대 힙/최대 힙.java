import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> maxHeap = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int max = Integer.parseInt(br.readLine());
        for (int i = 0; i < max; i++) {

            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                int root = poll();
                sb.append(root).append("\n");
            } else {
                maxHeap.add(input);
                siftUp(maxHeap.size() - 1);
            }
        }
        System.out.println(sb);
    }

    static int poll() {
        if (maxHeap.isEmpty()) {
            return 0;
        }
        int root = maxHeap.get(0);
        int last = maxHeap.remove(maxHeap.size() - 1);
        if (!maxHeap.isEmpty()) {
            maxHeap.set(0, last);
            siftDown(0);
        }
        return root;
    }
    static void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (maxHeap.get(parentIndex) >= maxHeap.get(index)) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    static void siftDown(int index) {
        int size = maxHeap.size();
        while (true) {
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;
            if (leftIndex >= size) {
                break;
            }
            int biggerIndex = leftIndex;                       
            if (rightIndex < size && maxHeap.get(rightIndex) > maxHeap.get(leftIndex)) {
                biggerIndex = rightIndex;                     
            }


            if (maxHeap.get(index) >= maxHeap.get(biggerIndex)) {
                break;
            }
            swap(index, biggerIndex);
            index = biggerIndex;
        }

    }

    static void swap(int index1, int index2) {
        int temp = maxHeap.get(index1);
        maxHeap.set(index1, maxHeap.get(index2));
        maxHeap.set(index2, temp);
    }
}
