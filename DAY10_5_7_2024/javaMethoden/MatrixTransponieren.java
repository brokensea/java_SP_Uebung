package DAY10_5_7_2024.javaMethoden;
// Implementiere eine Methode,die eine gegebene quadratische Matrix transponiert,d.h.,die Zeilen in Spalten und die Spalten in Zeilen umwandelt:

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// \begin{array}{rrr}  
// 1 & 2 & 3 \\  
// 4 & 5 & 6 \\  
// 7 & 8 & 9 \\  
// \end{array} \rightarrow \begin{array}{rrr}  
// 1 & 4 & 7 \\  
// 2 & 5 & 8 \\  
// 3 & 6 & 9 \\  
// \end{array}
// Erstelle außerdem eine Hilfsmethode zur Ausgabe einer Matrix.

public class MatrixTransponieren {

    public static void main(String[] args) {
        int[][] input = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
        };
        MatrixTransponieren matrixTransponieren = new MatrixTransponieren();
        int[][] output = matrixTransponieren.squareMatrixTransposed(input);
        toString(output);
    }

    private int[][] squareMatrixTransposed(int[][] input) {
        int n = input.length;
        return IntStream.range(0, n)
                .mapToObj(i -> IntStream.range(0, n)
                        .map(j -> input[j][i])
                        .toArray())
                .toArray(int[][]::new);
    }

    // private int[][] squareMatrixTransposed(int[][] input) {
    // return Arrays.stream(input)
    // .map(row -> Arrays.stream(input).mapToInt(r ->
    // r[Arrays.asList(input).indexOf(row)]).toArray())
    // .toArray(int[][]::new);
    // }

    // private int[][] squareMatrixTransposed(int[][] input) {
    // int[][] output = new int[input.length][input.length];
    // for (int i = 0; i < input.length; i++) {
    // for (int j = 0; j < input.length; j++) {
    // output[i][j] = input[j][i];
    // }
    // }
    // return output;
    // }

    public static void toString(int[][] multiArray) {
        Arrays.stream(multiArray)
                .map(arr -> Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .forEach(System.out::println);
    }
}

// IntStream.range(0,n)：

// 创建一个从 0

// 到 n-1 的索引流。.mapToObj(i->IntStream.range(0,n).map(j->input[j][i]).toArray())：

// 对每个索引 i，创建一个新的 IntStream，
// 它遍历所有行的索引 j，并映射到 input[j][i]，形成新的行。.toArray(int[][]::new)：

// 将映射结果转换为二维数组。

// 这种方法的时间复杂度同样是 O(n^2)，并且利用了Java 8的流特性，使代码更简洁。