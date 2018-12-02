package pl.paweln.codility.stacks;

import pl.paweln.codility.core.BaseCodilitySolution;

import java.util.LinkedList;

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 *
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 *
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 *
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0,
 * as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 */
public class Brackets extends BaseCodilitySolution {
    private final char BRACKET_OPEN_NORMAL = '(';
    private final char BRACKET_CLOSE_NORMAL = ')';
    private final char BRACKET_OPEN_TAB = '[';
    private final char BRACKET_CLOSE_TAB = ']';
    private final char BRACKET_OPEN_SET = '{';
    private final char BRACKET_CLOSE_SET = '}';

    private LinkedList<Character> stack = new LinkedList<Character>();

    @Override
    public int solution (String s) {

        char[] tab = s.toCharArray();

        for (char c : tab) {
            if (c == BRACKET_CLOSE_NORMAL || c == BRACKET_CLOSE_SET || c == BRACKET_CLOSE_TAB) {
                try {
                    pop(c);
                } catch (Exception e) {
                    return 0;
                }
            } else if (c == BRACKET_OPEN_NORMAL || c == BRACKET_OPEN_SET || c == BRACKET_OPEN_TAB) {
                push(c);
            } else {
                return 0;
            }
        }

        if (this.stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }

    }

    private void push (Character c) {
        this.stack.add(c);
    }

    private void pop (Character c) throws Exception {

        if (this.stack.isEmpty()) {
            throw new Exception("Stack is empty");
        }

        Character last = this.stack.getLast();
        Character openBracket = null;

        switch (c) {
            case BRACKET_CLOSE_NORMAL:
                openBracket = BRACKET_OPEN_NORMAL;
                break;
            case BRACKET_CLOSE_TAB:
                openBracket = BRACKET_OPEN_TAB;
                break;
            case BRACKET_CLOSE_SET:
                openBracket = BRACKET_OPEN_SET;
                break;
        }

        if (last.charValue() != openBracket.charValue()) {
            throw new Exception("Unexpected bracket");
        }

        this.stack.removeLast();
    }
}
