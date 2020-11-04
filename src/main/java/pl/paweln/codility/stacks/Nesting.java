package pl.paweln.codility.stacks;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Stack;

public class Nesting implements CodilitySolution {
    public final static char BRACKET_OPEN = '(';
    public final static char BRACKET_CLOSE = ')';

    @Override
    public int[] solution(SolutionInputParams params) {
        String s = params.getStringValue();
        int N = s.length();
        if (N > 1000000) {
            throw new IllegalArgumentException("Length of input string too high.");
        }

        return new int[] {this.solution(s)};
    }

    private int solution(String S) {
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
