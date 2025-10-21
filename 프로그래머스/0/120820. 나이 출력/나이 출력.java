class Solution {
    public int solution(int age) {
        if(0<age&&age<=120){
        int answer = 2022 - age + 1;
        return answer;
    } else {
            return -1;
        }
    }
}