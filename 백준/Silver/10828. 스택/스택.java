import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    List<Integer> numStack = new ArrayList<Integer>();
    List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int maxNum = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= maxNum; i++) {
            String input = sc.nextLine();
            if (input.contains(" ")) {
                int inputNum = Integer.parseInt(input.split(" ")[1]);
                m.push(inputNum);
            } else {
                switch (input) {
                    case "pop": {
                        m.pop();
                        break;
                    }
                    case "top": {
                        m.top();
                        break;
                    }
                    case "size": {
                        m.size();
                        break;
                    }
                    case "empty": {
                        m.empty();
                        break;
                    }

                }
            }

        }
        for (int i = 0; i < m.answers.size(); i++) {
            System.out.println(m.answers.get(i));
        }
    }

    public void push(int num) {
        numStack.add(num);
    }

    public void pop() {
        if (numStack.isEmpty()) {
            answers.add(-1);
        } else {
            answers.add(numStack.get(numStack.size()-1));
            numStack.remove(numStack.size()-1);
        }
    }

    public void size() {
        answers.add(numStack.size());
    }

    public void empty() {
        if (numStack.isEmpty()) {
            answers.add(1);
        } else {
            answers.add(0);
        }
    }

    public void top() {
        if (numStack.isEmpty()) {
            answers.add(-1);
        } else {
            answers.add(numStack.get(numStack.size()-1));
        }
    }
}