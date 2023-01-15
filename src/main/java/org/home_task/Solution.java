package org.home_task;

import java.util.*;

/**
 * Generates sequence of combinations based on the given string of numeric values.
 * Solution for the problem below:
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the
 * number(s) could represent. Return the answer in any order.
 * </p>
 */
final class Solution {
    private List<String> result;
    private Map<Character, String> map;
    private String digits;

    /**
     * @param digits given input consisting of values [2-9].
     * Input value is checked for validity according to the given requirements.
     * In case of success, the input gets sorted in ascending order to achieve lexicographically sorted result,
     * otherwise the exception is thrown.
     */
    Solution(String digits) {
        result = new ArrayList<>();
        map = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );
        if (digits.length() > 4) {
            throw new IllegalArgumentException("Length of the input should be less than or equal 4!");
        }
        for (char c : digits.toCharArray()) {
            if (!Character.isDigit(c) || c == '1') {
                throw new IllegalArgumentException("Input should consist of numeric values only!");
            }
        }
        char[] chars = digits.toCharArray();
        Arrays.sort(chars);
        digits = new String(chars);
        this.digits = digits;
    }

    /**
     * @param combination StringBuilder for generating a single combination.
     * @param index       position on the input currently being checked.
     *
     * <p>For generating the result, backtracking algorithm is used. Starting from the first digit, for every letter
     *  of the current digit's letters, the method calls itself recursively with incremented index.
     *  If the index equals to the length of input string, the current combination is pushed to the resulting list of
     *  strings.
     *  </p>
     */
    private void backtrack(StringBuilder combination, int index) {
        if (combination.length() == digits.length()) {
            result.add(combination.toString());
            return;
        }

        String curr_digit = map.get(digits.charAt(index));
        for (char c : curr_digit.toCharArray()) {
            combination.append(c);
            backtrack(combination, index + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    /**
     * @return the resulting list of strings.
     */
    public List<String> returnResult() {
        backtrack(new StringBuilder(""), 0);
        return result;
    }

    /**
     * Method gets a string as an input. Instance of the Solution class is instantiated using the received input.
     * The resulting list of strings is printed.
     */
    public static void main(String[] args) {
        String input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        Solution s = new Solution(input);
        List<String> res = s.returnResult();
        for (String elem : res) {
            System.out.println(elem);
        }
    }
}
