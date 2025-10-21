

class Solution {
    public int[] solution(long n) {
        long a = 0;
        long b = 0;
        int c = 0;
        
        
        for(a = 0; Math.pow(10,a)<=n; a++) {
            a = a;
        }
        
        int answer[] = new int[(int)a];
        
        int i = 0;
        while (n > 0) {
            answer[i++] = (int)(n % 10);
            n /= 10;
        }
        return answer;
    }
}