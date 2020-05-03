package leetCodingChallenge.may.week1.ransomNote;

/*
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * */

public class Solution {
    public static boolean canConstruct(String ransomNote, String magazine) {
        boolean isConstruct = true;
        char[] letters = ransomNote.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            String letter = String.valueOf(letters[i]);
            if (magazine.contains(letter)) {
                magazine = magazine.replaceFirst(letter, "");
                continue;
            } else {
                isConstruct = false;
                break;
            }
        }


        return isConstruct;
    }

    public static void main(String[] args) {
        //"fffbfg"
        //"effjfggbffjdgbjjhhdegh"
        System.out.println(Solution.canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"));

    }

}
