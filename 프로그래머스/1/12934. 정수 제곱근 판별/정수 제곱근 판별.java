class Solution {
    public long solution(long n) {
        long answer = 0;
        long a = (long)Math.sqrt(n);
        if(Math.sqrt(n)%1==0) return (a+1)*(a+1);
        else return -1;
    }
}