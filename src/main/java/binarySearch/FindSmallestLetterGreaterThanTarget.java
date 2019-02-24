package binarySearch;

/*
744. Find Smallest Letter Greater Than Target
Easy

190

284

Favorite

Share
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"
 */
public class FindSmallestLetterGreaterThanTarget {
    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target) {
                low = mid + 1; // find larger element
            }
            else {
                high = mid - 1;
            }
        }
        if (low == letters.length) {
            return letters[0];
        }
        else {
            return letters[low];
        }
    }

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'd';
        char nextChar = FindSmallestLetterGreaterThanTarget.nextGreatestLetter(letters, target);
        System.out.println(nextChar);

        target = 'z';
        nextChar = FindSmallestLetterGreaterThanTarget.nextGreatestLetter(letters, target);
        System.out.println(nextChar);
    }
}
