import java.util.*;

class Solution {
    public List<Long> solution(long x, long n) {
        long b = x;
        List<Long> arrayList = new ArrayList<>();
        for(long a = 0; a< n; a++) {
         arrayList.add((long)x);
            x += b;
        }
        return arrayList;
    }
}