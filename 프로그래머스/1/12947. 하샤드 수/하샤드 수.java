class Solution {
    public boolean solution(int x) {
        int i = 0;
        for (int num = x; num>0; num = num/10) {
            int a = num%10;
            i += a;
        }
        boolean answer = (x % i == 0);
        return answer;
    }
}