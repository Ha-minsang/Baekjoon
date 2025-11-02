import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Main {
    List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String firstInput = sc.nextLine();
        int answer = 0;
        int n = parseInt(firstInput.split(" ")[0]);
        int m = parseInt(firstInput.split(" ")[1]);
        main.setList(n);
         
        String secondInput = sc.nextLine();
        String[] arr = secondInput.split(" ");
        int maxNum = arr.length;
        for (int i = 0; i < maxNum; i++) {
            int searchNum = Integer.parseInt(arr[i]);
            int searchNumIndex = main.list.indexOf(searchNum);
            if (searchNumIndex <= (main.list.size() - searchNumIndex)) {
                while (searchNumIndex != 0) {
                    main.rightMove();
                    answer++;
                    searchNumIndex = main.list.indexOf(searchNum);
                }
            } else {
                while (searchNumIndex != 0) {
                    main.leftMove();
                    answer++;
                    searchNumIndex = main.list.indexOf(searchNum);
                }
            }
            main.list.remove(0);
        }
        System.out.println(answer);

    }

    
    public void setList(int n) {
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
    }
    public void rightMove() {
        list.add(list.get(0));
        list.remove(0);
    }

    public void leftMove() {
        list.add(0, list.get(list.size()-1));
        list.remove(list.size()-1);
    }

}
