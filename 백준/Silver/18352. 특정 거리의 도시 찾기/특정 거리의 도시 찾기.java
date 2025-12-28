import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
        }

        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        List<Integer> answers = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        visited[X] = true;
        distance[X] = 0;
        queue.add(X);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (visited[next]) continue;

                visited[next] = true;
                distance[next] = distance[current] + 1;
                queue.add(next);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                answers.add(i);
            }
        }

        Collections.sort(answers);

        if (answers.isEmpty()) {
            System.out.println("-1");
        }

        for (int answer : answers) {
            System.out.println(answer);
        }
    }
}