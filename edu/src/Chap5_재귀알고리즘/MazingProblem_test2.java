package Chap5_재귀알고리즘;

import java.util.Stack;

public class MazingProblem_test2 {

    static class Items {
        int x, y, dir;

        @Override
        public String toString() {
            return x + "," + y + "," + dir;
        }
    }

    static class Offsets {
        int a, b;

        Offsets(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static final int N = 0;
    static final int NE = 1;
    static final int E = 2;
    static final int SE = 3;
    static final int S = 4;
    static final int SW = 5;
    static final int W = 6;
    static final int NW = 7;

    static Offsets[] moves = new Offsets[8];

    public static void main(String[] args) {
        int[][] maze = new int[100][100];
        int[][] mark = new int[100][100];

        int[][] input = {
                { 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
                { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
                { 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
                { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
                { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
                { 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }
        };

        for (int i = 0; i < 8; i++)
            moves[i] = new Offsets(0, 0);
        moves[0].a = -1;
        moves[0].b = 0;
        moves[1].a = -1;
        moves[1].b = 1;
        moves[2].a = 0;
        moves[2].b = 1;
        moves[3].a = 1;
        moves[3].b = 1;
        moves[4].a = 1;
        moves[4].b = 0;
        moves[5].a = 1;
        moves[5].b = -1;
        moves[6].a = 0;
        moves[6].b = -1;
        moves[7].a = -1;
        moves[7].b = -1;

        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 17; j++) {
                if ((i == 0) || (j == 0) || (i == 13) || (j == 16))
                    maze[i][j] = 1;
                else {
                    maze[i][j] = input[i - 1][j - 1];
                }
                mark[i][j] = 0;
            }
        }

        System.out.println("maze[12,15]::");
        for (int i = 0; i <= 13; i++) {
            for (int j = 0; j <= 16; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("mark::");
        for (int i = 0; i <= 13; i++) {
            for (int j = 0; j <= 16; j++) {
                System.out.print(mark[i][j] + " ");
            }
            System.out.println();
        }

        path(maze, mark, 12, 15);

        System.out.println("mark::");
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 15; j++) {
                System.out.print(mark[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void path(int[][] maze, int[][] mark, int m, int p) {
        mark[1][1] = 1;
        Stack<Items> stack = new Stack<>();
        Items temp = new Items();
        temp.x = 1;
        temp.y = 1;
        temp.dir = E;
        stack.push(temp);

        while (!stack.isEmpty()) {
            temp = stack.pop();
            int i = temp.x;
            int j = temp.y;
            int d = temp.dir;

            while (d < 8) {
                int g = i + moves[d].a;
                int h = j + moves[d].b;

                if ((g == m) && (h == p)) {
                    temp = stack.pop();
                    
                    System.out.println("the term near the exit: " + i + " " + j);
                    System.out.println("exit: " + m + " " + p);
                    return;
                }

                if ((maze[g][h]== 0) && (mark[g][h] == 0)) {
                    mark[g][h] = 1;
                    temp.x = i;
                    temp.y = j;
                    temp.dir = d + 1;
                    stack.push(temp);
                    i = g;
                    j = h;
                    d = N;
                } else {
                    d++;
                }
            }
        }
        System.out.println("no path in maze");
    }
}