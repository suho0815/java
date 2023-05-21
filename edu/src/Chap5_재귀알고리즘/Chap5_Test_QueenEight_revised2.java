package Chap5_재귀알고리즘;

import java.util.ArrayList;
import java.util.List;

public class Chap5_Test_QueenEight_revised2 {

    static final int numberQueens = 8;

    public static void SolveQueen(int[][] d) {
        Stack3 st = new Stack3(numberQueens);
        int ix = 0;

        while (ix < numberQueens) {
            int cy = nextMove(d, ix);

            if (!st.isEmpty() && ix == st.peek().getX()) {
                Point p = st.pop();
                cy++;
            }

            while (cy < numberQueens) {
                Point px = new Point(ix, cy);
                st.push(px);
                d[ix][cy] = 1;

                // Increment cy before breaking the inner while loop
                cy++;
                break;
            }

            if (st.isEmpty() && cy >= numberQueens) {
                System.out.println("No Solution");
                return;
            }

            if (ix == numberQueens - 1) {
                System.out.println("Solution Found");
                st.dump();
                return;
            }

            // Decrement ix before the end of the outer while loop
            ix--;
        }
    }

    public static int nextMove(int[][] d, int ix) {
        int cy = -1;
        for (int i = 0; i < numberQueens; i++) {
            if (d[ix][i] == 0) {
                cy = i;
                break;
            }
        }
        return cy;
    }

    public static void main(String[] args) {
        int[][] d = new int[numberQueens][numberQueens];
        SolveQueen(d);
    }
}