import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        if (input == 1 || input == 3) {
            System.out.println(-1);
            return;
        }
        int i = input/5;
        if ((input - i * 5) % 2 == 1) {
            i --;
        }
        int j = (input - i * 5) / 2;
        System.out.println(i + j);
    }
}