import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 크레인 개수 n 입력
        int n = Integer.parseInt(br.readLine());
        
        // 크레인 배열 생성
        Integer[] cranes = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        // 박스 개수 m 입력
        int m = Integer.parseInt(br.readLine());
        
        // 박스 배열 생성
        Integer[] boxes = new Integer[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        // 박스와 크레인 모두 내림차순 정렬
        Arrays.sort(cranes, Collections.reverseOrder());
        Arrays.sort(boxes, Collections.reverseOrder());

        // 제일 무거운 박스를 못옮길 경우 -1 출력
        if (boxes[0] > cranes[0]) {
            System.out.println(-1);
            return;
        }
        
        // 박스가 옮겨진 여부를 판단하는 배열
        boolean[] moved = new boolean[m];
        int movedCount = 0; // 박스가 옮겨진 횟수
        int time = 0;       // 박스 옮기는데 소요된 시간

        // 박스가 m번 옮겨질때 동안 즉, 모두 옮겨질때 동안 반복
        while (movedCount < m) {
            time++;      // 1분 추가
            int box = 0; // 박스 번호
            for (int i = 0; i < n; i++) { // 모든 크레인 n개 동안 반복
                while (box < m) {
                    if (!moved[box] && cranes[i] >= boxes[box]) { // 박스가 옮겨진적 없고 크레인이 옮길수 있는 박스일 때
                        moved[box] = true; // 박스가 옮겨진것으로 처리
                        movedCount++;      // 옮겨진 박스 횟수 추가
                        box++;             // 다음 박스로 넘어감
                        break;
                    } else {
                        box++;  // 박스가 이미 옮겨졌거나 현재 크레인 i가 못옮기는 박스일때 다음 박스로 넘어감
                    }
                }
                if (box >= m) break;  // 모든 박스에 대해 진행했을때 반복문 탈출
            }
        }

        // 정답 출력
        System.out.println(time);
    }
}
