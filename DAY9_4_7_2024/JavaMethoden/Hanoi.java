package DAY9_4_7_2024.JavaMethoden;

public class Hanoi {
    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.solveHanoi(2, "A_Staff", "C_Staff", "B_Staff");
    }

    private void solveHanoi(int n, String startStaff, String helpStaff, String targetStaff) {
        if (n == 1) {
            System.out.println("move Disk 1 from " + startStaff + " to " + targetStaff);
            return;
        }

        // hanoi.solveHanoi(2, "A_Staff", "C_Staff", "B_Staff");
        solveHanoi(n - 1, startStaff, targetStaff, helpStaff);
        System.out.println("move Disk " + n + " from " + startStaff + " to " + targetStaff + "");
        solveHanoi(n - 1, helpStaff, startStaff, targetStaff);
    }
}

// 你在 solveHanoi 方法中调用了两次递归函数，每次传递不同的参数。我们需要逐步跟踪这些递归调用，以理解输出。

// 执行步骤解析 初始调用：
// java 复制代码 hanoi.solveHanoi(2,"A_Staff","C_Staff","B_Staff");第一层递归调用：

// solveHanoi(2, "A_Staff", "C_Staff", "B_Staff")

// 调用 solveHanoi(n - 1, startStaff, targetStaff, helpStaff)：

// java
// 复制代码
// solveHanoi(1, "A_Staff", "B_Staff", "C_Staff"); // 调用1
// 打印：move Disk 1 from A_Staff to C_Staff
// 打印：move Disk 2 from A_Staff to B_Staff

// 第二个递归调用 solveHanoi(n - 1, helpStaff, startStaff, targetStaff)：

// java
// 复制代码
// solveHanoi(1, "C_Staff", "A_Staff", "B_Staff"); // 调用2
// 打印：move Disk 1 from C_Staff to B_Staff
// 详细步骤
// 第一次递归调用 (n=1)：

// java
// 复制代码
// solveHanoi(1, "A_Staff", "B_Staff", "C_Staff");
// 由于 n 等于1，满足基例条件，直接打印：
// css
// 复制代码
// move Disk 1 from A_Staff to C_Staff
// 打印第2个盘子：

// java
// 复制代码
// System.out.println("move Disk 2 from " + startStaff + " to " + targetStaff);
// 打印：
// css
// 复制代码
// move Disk 2 from A_Staff to B_Staff
// 第二次递归调用 (n=1)：

// java
// 复制代码
// solveHanoi(1, "C_Staff", "A_Staff", "B_Staff");
// 由于 n 等于1，满足基例条件，直接打印：
// css
// 复制代码
// move Disk 1 from C_Staff to B_Staff
// 完整的输出：
// css
// 复制代码
// move Disk 1 from A_Staff to C_Staff
// move Disk 2 from A_Staff to B_Staff
// move Disk 1 from C_Staff to B_Staff
// 总结
// 你的代码和执行顺序是正确的，递归调用中参数的传递也正确。递归解决汉诺塔问题时，需要正确设置每次调用的参数，使得每一步都按照汉诺塔的规则移动盘子。通过递归，我们能够将问题分解成更小的子问题，并最终解决整个问题。