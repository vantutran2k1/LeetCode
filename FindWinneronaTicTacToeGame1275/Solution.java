package FindWinneronaTicTacToeGame1275;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Solution {
    private record TestCase(int[][] moves, String expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}}, "A"),
                new Solution.TestCase(new int[][]{{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}}, "B"),
                new Solution.TestCase(new int[][]{{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}}, "Draw")
        );

        for (TestCase testCase : testCases) {
            System.out.println(Objects.equals(tictactoe(testCase.moves), testCase.expectedResult));
        }
    }

    public static String tictactoe(int[][] moves) {
        int[][] firstPlayerMoves = new int[5][2];
        int firstCount = 0;

        int[][] secondPlayerMoves = new int[4][2];
        int secondCount = 0;

        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0)
                firstPlayerMoves[firstCount++] = moves[i];
            else
                secondPlayerMoves[secondCount++] = moves[i];
        }

        if (isWin(firstPlayerMoves, firstCount))
            return "A";
        else if (isWin(secondPlayerMoves, secondCount))
            return "B";
        else if (moves.length == 9)
            return "Draw";
        return "Pending";
    }

    private static boolean isWin(int[][] moves, int length) {
        return existRowOrCol(moves, length) || existDiagonal(moves, length);
    }

    private static boolean existDiagonal(int[][] moves, int length) {
        int countDiagonal = 0;
        int countAntiDiagonal = 0;

        int[] move;
        for (int i = 0; i < length; i++) {
            move = moves[i];
            if (move[0] == move[1])
                countDiagonal++;

            int sum = move[0] + move[1];
            int mul = move[0] * move[1];

            if ((mul == 1) || (sum == 2 && mul == 0))
                countAntiDiagonal++;

        }

        return countDiagonal == 3 || countAntiDiagonal == 3;
    }

    private static boolean existRowOrCol(int[][] moves, int length) {
        Map<Integer, Integer> rowCounts = new HashMap<>();
        Map<Integer, Integer> colCounts = new HashMap<>();
        int[] move;
        for (int i = 0; i < length; i++) {
            move = moves[i];

            rowCounts.put(move[0], rowCounts.getOrDefault(move[0], 0) + 1);
            colCounts.put(move[1], colCounts.getOrDefault(move[1], 0) + 1);

            if (rowCounts.get(move[0]) == 3 || colCounts.get(move[1]) == 3)
                return true;
        }

        return false;
    }
}
