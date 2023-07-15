import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(int[] numbers) {
        if (Arrays.stream(numbers).max().orElseThrow() == 0)
            return "0";
        List<String> nums = Arrays.stream(numbers)
            .boxed()
            .map(n->String.valueOf(n))
            .collect(Collectors.toList());
        nums.sort((a, b) -> (a + b).compareTo(b + a) * (-1));
        return nums.stream().collect(Collectors.joining());
    }
}