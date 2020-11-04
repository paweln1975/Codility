package pl.paweln.codility.stacks;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Stack;

public class StoneWall implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] H = params.getFirstArray();
        int N = H.length;
        if (N > 100000) {
            throw new IllegalArgumentException("Array to big.");
        }
        return new int[] {this.solution(H)};
    }

    private int solution (int[] H) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < H.length; i++) {
            if (stack.size() == 0) {
                count++;
                stack.push(H[i]);
            } else {
                if (stack.peek() > H[i]) {
                    while(stack.size() > 0 && stack.peek() > H[i]) {
                        stack.pop();
                    }
                    i--;
                } else if (stack.peek() < H[i]) {
                    count++;
                    stack.push(H[i]);
                }
            }
        }
        return count;
    }


}
