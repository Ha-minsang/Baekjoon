public class Solution {
    public int solution(int n) {
        int sum = 0;
        int b = 0;
        for(int a=0; Math.pow(10,a)<=n; a++ ){
            b = (int)((int)n/Math.pow(10,a))%10;
            sum += b;
        }
        return sum;
    }
}