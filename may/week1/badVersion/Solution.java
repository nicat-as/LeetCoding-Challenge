package leetCodingChallenge.may.week1.badVersion;


import java.util.Arrays;

public class Solution extends VersionControl {

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int v = firstBadVersion(10);
        System.out.println("Bad version is: " + v);
    }
}
