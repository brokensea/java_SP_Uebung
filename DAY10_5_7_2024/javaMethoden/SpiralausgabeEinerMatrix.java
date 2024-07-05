package DAY10_5_7_2024.javaMethoden;

import java.util.Arrays;

// Implementiere eine Methode,die eine nxm Matrix spiralförmig(im Uhrzeigersinn)ausgibt:

// nxm Matrix:
// 1 2 3 4 
// 5 6 7 8 
// 9 10 11 12 
// 13 14 15 16

// spiralförmige Ausgabe:1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
public class SpiralausgabeEinerMatrix {
    public static void main(String[] args) {

        int[][] input = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
        };
        SpiralausgabeEinerMatrix spiralausgabeEinerMatrix = new SpiralausgabeEinerMatrix();
        int[] output = spiralausgabeEinerMatrix.spiralOutputMatrix(input);
        System.out.println(Arrays.toString(output));
        // [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
    }

    private int[] spiralOutputMatrix(int[][] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }
        int rows = input.length;
        int cols = input[0].length;
        int[] output = new int[rows * cols];
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        int index = 0;
        while (top <= bottom && left <= right) {
            // Traverse letf to right, along the top row
            for (int i = left; i <= right; i++) {
                output[index++] = input[top][i];
            }
            top++;

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                output[index++] = input[i][right];
            }
            right--;

            // Traverse from right to left along the bottom row
            for (int i = right; i >= left; i--) {
                output[index++] = input[bottom][i];
            }
            bottom--;

            // if (top <= bottom) {

            // }

            // Traverse from bottom to top along the left column
            for (int i = bottom; i >= top; i--) {
                output[index++] = input[i][left];
            }
            left++;

            // if (left <= right) {

            // }
        }
        return output;
    }

}
