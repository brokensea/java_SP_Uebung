package DAY10_5_7_2024.javaMethoden;

import java.util.stream.IntStream;

// Schreibe ein Methode***public static int sumOfMainDiagonal(int[][]matrix),***die die Summe aller Elemente auf der Hauptdiagonale einer quadratischen Matrix berechnet.

// Matrix:
//1 2 3 
//4 5 6 
//7 8 9 Summe der Hauptdiagonale:15

public class DiagonalelementeSummieren {

    public static void main(String[] args) {

        int[][] input = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
        };

        DiagonalelementeSummieren diag = new DiagonalelementeSummieren();
        System.out.println(diag.sumOfMainDiagonal(input));// 15
    }

    private int sumOfMainDiagonal(int[][] input) {
        return IntStream.range(0, input.length).map(i -> input[i][i])
                .sum();
    }
}
// private int sumOfMainDiagonal(int[][] input) {
// int sum = 0;
// for (int i = 0; i < input.length; i++) {
// for (int j = 0; j < input.length; j++) {
// if (i == j) {
// sum += input[i][j];
// }

// }
// }
// return sum;

// }

// }
// IntStream.range(0,input.length)：

// 创建一个从 0 到 input.length-1 的整数流，这个范围正好是二维数组的索引范围。.map(i->input[i][i])：

// 对于流中的每个索引 i，获取 input[i][i]，即主对角线上的元素。.sum()：

// 对映射结果进行求和，得到主对角线上所有元素的和
// 。
