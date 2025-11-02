import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<Integer> intQueue = new ArrayList<>();
    List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < maxNum; i++) {
            String input =  br.readLine();
            if (input.contains(" ")) {
                int inputNum = Integer.parseInt(input.split(" ")[1]);
                main.push(inputNum);
            } else {
                switch (input) {
                    case "pop" : {
                        main.pop();
                        break;
                    }
                    case "size" : {
                        main.size();
                        break;
                    }
                    case "empty" : {
                        main.empty();
                        break;
                    }
                    case "front" : {
                        main.front();
                        break;
                    }
                    case "back" : {
                        main.back();
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < main.answers.size(); i++) {
            System.out.println(main.answers.get(i));
        }

    }

    public void push (int num) {
        intQueue.add(num);
    }
    public void pop() {
        if (intQueue.isEmpty()) {
            answers.add(-1);
        } else {
            answers.add(intQueue.get(0));
            intQueue.remove(0);
        }
    }

    public void size() {
        answers.add(intQueue.size());
    }

    public void empty() {
        if (intQueue.isEmpty()) {
            answers.add(1);
        } else {
            answers.add(0);
        }
    }

    public void front() {
        if (intQueue.isEmpty()) {
            answers.add(-1);
        } else {
            answers.add(intQueue.get(0));
        }
    }

    public void back() {
        if (intQueue.isEmpty()) {
            answers.add(-1);
        } else {
            answers.add(intQueue.get(intQueue.size()-1));
        }
    }
}
