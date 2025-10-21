class Solution {
    public int solution(int n) {
        int sum = 0;
        for(int a = 1; a<=n; a++)
            if(n%a==0) {
                sum += a;
            }
        return sum;
    }
}