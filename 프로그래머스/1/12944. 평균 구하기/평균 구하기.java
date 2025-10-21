class Solution {
    public double solution(int[] arr) {
        double sum = 0;
        for (double a : arr) {
            sum += a;
        }
        return sum/arr.length;
    }
}