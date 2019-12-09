package pl.paweln.codility.stacks;

import pl.paweln.codility.core.BaseCodilitySolution;

import java.util.Stack;

/**
 * A string S consisting of N characters is called properly nested if:
 *
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 *
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 *
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0,
 * as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..1,000,000];
 * string S consists only of the characters "(" and/or ")".
 */
public class Nesting extends BaseCodilitySolution {
    public final static char BRACKET_OPEN = '(';
    public final static char BRACKET_CLOSE = ')';
    public int solution(String S) {
        char[] arr = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if (c == BRACKET_OPEN) {
                stack.push(c);
            } else if (c == BRACKET_CLOSE) {
                // test empty stack
                if (stack.empty()) {
                    return 0;
                }
                char top = stack.peek();
                if (top == BRACKET_OPEN) {
                    stack.pop();
                }
            } else {
                throw new IllegalArgumentException("Illegal argument - unknown char:" + c);
            }
        }
        return stack.empty() ? 1 : 0;
    }
}
