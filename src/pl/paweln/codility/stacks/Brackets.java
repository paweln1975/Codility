package pl.paweln.codility.stacks;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.LinkedList;

public class Brackets implements CodilitySolution {
    private final char BRACKET_OPEN_NORMAL = '(';
    private final char BRACKET_CLOSE_NORMAL = ')';
    private final char BRACKET_OPEN_TAB = '[';
    private final char BRACKET_CLOSE_TAB = ']';
    private final char BRACKET_OPEN_SET = '{';
    private final char BRACKET_CLOSE_SET = '}';

    private LinkedList<Character> stack = new LinkedList<>();

    @Override
    public int[] solution(SolutionInputParams params) {
        String s = params.getStringValue();
        int N = s.length();
        if (N > 200000) {
            throw new IllegalArgumentException("Length of input string too high.");
        }

        return new int[] {this.solution(s)};
    }


    private int solution (String s) {

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
        Character openBracket = BRACKET_OPEN_NORMAL;

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
