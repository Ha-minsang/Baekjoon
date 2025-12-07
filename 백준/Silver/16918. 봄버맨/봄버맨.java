import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] graph = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                graph[i][j] = line.charAt(j);
            }
        }
        if (n == 1) { // n이 1일 경우 초기 그래프 출력
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append(graph[i][j]);
                }
                sb.append('\n');
            }
        } else if (n % 2 == 0) { // n이 짝수일 경우 모두 O인 그래프 출력
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append('O');
                }
                sb.append('\n');
            }
        } else {
            // 전부 O으로 초기화
            char[][] graph2 = new char[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    graph2[i][j] = 'O';
                }
            }

            // 초기 graph 기준으로 폭발
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (graph[i][j] == 'O') {
                        graph2[i][j] = '.';

                        // 위
                        if (i - 1 >= 0) {
                            graph2[i - 1][j] = '.';
                        }
                        // 아래
                        if (i + 1 < r) {
                            graph2[i + 1][j] = '.';
                        }
                        // 왼쪽
                        if (j - 1 >= 0) {
                            graph2[i][j - 1] = '.';
                        }
                        // 오른쪽
                        if (j + 1 < c) {
                            graph2[i][j + 1] = '.';
                        }
                    }
                }
            }
            // graph3 만들기 (전부 O로 초기화)
            char[][] graph3 = new char[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    graph3[i][j] = 'O';
                }
            }

            // graph2 기준으로 폭발
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (graph2[i][j] == 'O') {
                        graph3[i][j] = '.';  // 자기 자신

                        // 위
                        if (i - 1 >= 0) {
                            graph3[i - 1][j] = '.';
                        }
                        // 아래
                        if (i + 1 < r) {
                            graph3[i + 1][j] = '.';
                        }
                        // 왼쪽
                        if (j - 1 >= 0) {
                            graph3[i][j - 1] = '.';
                        }
                        // 오른쪽
                        if (j + 1 < c) {
                            graph3[i][j + 1] = '.';
                        }
                    }
                }
            }
            if (n % 4 == 3) {
                // graph2 출력
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        sb.append(graph2[i][j]);
                    }
                    sb.append('\n');
                }

            } else {
                // N % 4 == 1 이면 graph3 출력
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        sb.append(graph3[i][j]);
                    }
                    sb.append('\n');
                }
            }
        }

        System.out.print(sb.toString());
    }
}
