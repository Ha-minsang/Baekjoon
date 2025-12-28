import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static HashMap<String, Position> left = new HashMap<>();
    static HashMap<String, Position> right = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        setKey();

        Position leftNow = left.get(st.nextToken());
        Position rightNow = right.get(st.nextToken());

        String[] enter = br.readLine().split("");
        int time = 0;
        for (String s : enter) {
            if(left.containsKey(s)) {
                Position next = left.get(s);
                time += Math.abs(leftNow.x - next.x) + Math.abs(leftNow.y - next.y);
                time++;
                leftNow = next;
            } else {
                Position next = right.get(s);
                time += Math.abs(rightNow.x - next.x) + Math.abs(rightNow.y - next.y);
                time++;
                rightNow = next;
            }
        }
        System.out.println(time);
    }

    public static void setKey() {
        left.put("q", new Position(1, 1));
        left.put("w", new Position(1, 2));
        left.put("e", new Position(1, 3));
        left.put("r", new Position(1, 4));
        left.put("t", new Position(1, 5));
        left.put("a", new Position(2, 1));
        left.put("s", new Position(2, 2));
        left.put("d", new Position(2, 3));
        left.put("f", new Position(2, 4));
        left.put("g", new Position(2, 5));
        left.put("z", new Position(3, 1));
        left.put("x", new Position(3, 2));
        left.put("c", new Position(3, 3));
        left.put("v", new Position(3, 4));

        right.put("y", new Position(1, 6));
        right.put("u", new Position(1,7));
        right.put("i", new Position(1,8));
        right.put("o", new Position(1,9));
        right.put("p", new Position(1,10));
        right.put("h", new Position(2,6));
        right.put("j", new Position(2,7));
        right.put("k", new Position(2,8));
        right.put("l", new Position(2,9));
        right.put("b", new Position(3,5));
        right.put("n", new Position(3,6));
        right.put("m", new Position(3,7));
    }
}