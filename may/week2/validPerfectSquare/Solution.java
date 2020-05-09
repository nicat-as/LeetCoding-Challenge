package leetCodingChallenge.may.week2.validPerfectSquare;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Solution {
    public static boolean isPerfectSquare(int num) {
        // I assume that every number's square is under the length of number/2's pow of 10.
        // Example, 16 square of 4. 16- number length is 2 and 2/2=1. Thus, 10^1=10.
        // So, square of 16 is limited between 1-10.
        // Another example, 225. len(225)=3; 3/2=1 and remainder -> 1+1=2; so, 10^2=100. 1-100;
        int length = String.valueOf(num).length();
        length = length % 2 == 0 ? length / 2 : length / 2 + 1;

        boolean is = false;
        if (num == 0 || num == 1)
            is = true;

        long start = 0, end = (long) Math.pow(10, length);
        while (start <= end) {
            //start = 0 ; end = 16
            long mid = start + (end - start) / 2;
            if (mid * mid == num) {
                is = true;
                break;
            }

            if ((mid * mid) > num) {
                end = mid - 1;
                continue;
            }

            if ((mid * mid) < num) {
                start = mid + 1;
                continue;
            }
        }
        return is;
    }

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        boolean is = Solution.isPerfectSquare(2147395600);
        Long end = System.currentTimeMillis();
        System.out.println(Duration.of(end - start, ChronoUnit.MILLIS).toMillis());
        System.out.println(is);
        System.out.println(Math.sqrt(2147395600));
    }
}
