package code;

import java.util.*;

public class Solution57 {

    public static List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numbers.length; ++i) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = numbers.length - 1;
            while (j < k) {
                int sum = numbers[j] + numbers[k];
                if (sum > -numbers[i]) {
                    --k;
                } else if (sum < -numbers[i]) {
                    ++j;
                } else {
                    List<Integer> res = new ArrayList<>();
                    res.add(numbers[i]);
                    res.add(numbers[j]);
                    res.add(numbers[k]);
                    result.add(res);
                    --k;
                    ++j;
                    while (j < numbers.length - 1 && numbers[j] == numbers[j - 1]) {
                        ++j;
                    }
                    while (k > 0 && numbers[k] == numbers[k + 1]) {
                        --k;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-2,-3,-4,-5,-100,99,1,4,4,4,5,1,0,-1,2,3,4,5};
        List<List<Integer>> res = threeSum(input);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
