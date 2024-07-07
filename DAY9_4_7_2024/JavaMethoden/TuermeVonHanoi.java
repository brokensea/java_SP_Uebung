package DAY9_4_7_2024.JavaMethoden;

import java.lang.reflect.Parameter;
import java.util.Stack;

// Implementiere eine rekursive Methode in Java zur Lösung des Problems der Türme von Hanoi.Die Türme von Hanoi ist ein klassisches Problem der Informatik,das Folgendes umfasst:

// Gegeben sind drei Stäbe(A,B und C),wobei auf Stab A eine geordnete Stapelung von n Scheiben unterschiedlicher Größen liegt,die von unten(größte Scheibe)nach oben(kleinste Scheibe)abnehmend sortiert sind.Die Aufgabe besteht darin,alle Scheiben von Stab A nach Stab C unter Einhaltung der folgenden Regeln zu verschieben:

// **Regeln:**

//-Du kannst immer nur eine Scheibe auf einmal bewegen
//-Eine größere Scheibe darf nicht auf einer kleineren liegen
//-Du darfst die Scheiben nur auf die drei Stäbe legen

public class TuermeVonHanoi {

    public static void main(String[] args) {
        int n = 3; // number of discs
        TuermeVonHanoi tuermeVonHanoi = new TuermeVonHanoi();
        tuermeVonHanoi.solveHanoi(n, "A_Staff", "C_Staff", "B_Staff");
    }

    private void solveHanoi(int n, String startStaff, String helpStaff, String targetStaff) {
        if (n == 1) {
            System.out.println("Verschiebe Scheibe 1 von " + startStaff + " nach " + targetStaff);
            return;
        }

        solveHanoi(n - 1, startStaff, targetStaff, helpStaff);
        System.out.println("Verschiebe Scheibe " + n + " von " + startStaff + " nach " + targetStaff); // because of
                                                                                                       // stack
        solveHanoi(n - 1, helpStaff, startStaff, targetStaff);
    }
}
// 当 n = 3 时，递归过程如下：

// 初始调用:

// solveHanoi(3, 'A', 'C', 'B')
// 进入第一步，调用 solveHanoi(2, 'A', 'B', 'C')
// 进入第一步，调用 solveHanoi(1, 'A', 'C', 'B')
// 打印: 将圆盘 1 从柱子 A 移到柱子 C
// 打印: 将圆盘 2 从柱子 A 移到柱子 B
// 进入第三步，调用 solveHanoi(1, 'C', 'B', 'A')
// 打印: 将圆盘 1 从柱子 C 移到柱子 B
// 打印: 将圆盘 3 从柱子 A 移到柱子 C
// 进入第三步，调用 solveHanoi(2, 'B', 'C', 'A')
// 进入第一步，调用 solveHanoi(1, 'B', 'A', 'C')
// 打印: 将圆盘 1 从柱子 B 移到柱子 A
// 打印: 将圆盘 2 从柱子 B 移到柱子 C
// 进入第三步，调用 solveHanoi(1, 'A', 'C', 'B')
// 打印: 将圆盘 1 从柱子 A 移到柱子 C

// private static void solveHanoiStack(int n, char startStab, char zielStab,
// char hilfsStab) {
// Stack<HanoiStep> stack = new Stack<>();
// stack.push(new HanoiStep(n, startStab, zielStab, hilfsStab));

// while (!stack.isEmpty()) {
// HanoiStep step = stack.pop();
// n = step.n;
// startStab = step.startStab;
// zielStab = step.zielStab;
// hilfsStab = step.hilfsStab;

// if (n == 1) {
// System.out.println("Bewege Scheibe 1 von Stab " + startStab + " nach Stab " +
// zielStab);
// } else {
// // 按照递归的顺序将步骤压入栈中，先处理辅助步骤，再处理移动步骤
// stack.push(new HanoiStep(n - 1, hilfsStab, zielStab, startStab));
// stack.push(new HanoiStep(1, startStab, zielStab, hilfsStab));
// stack.push(new HanoiStep(n - 1, startStab, hilfsStab, zielStab));
// }
// }
// }

// static class HanoiStep {
// int n;
// char startStab;
// char zielStab;
// char hilfsStab;

// HanoiStep(int n, char startStab, char zielStab, char hilfsStab) {
// this.n = n;
// this.startStab = startStab;
// this.zielStab = zielStab;
// this.hilfsStab = hilfsStab;
// }
// }

// stack
// import java.util.Stack;

// public class TowerOfHanoiIterative {
// public static void main(String[] args) {
// int n = 3;
// char startStab = 'A';
// char zielStab = 'C';
// char hilfsStab = 'B';

// solveHanoi(n, startStab, zielStab, hilfsStab);
// }

// private static void solveHanoi(int n, char startStab, char zielStab, char
// hilfsStab) {
// Stack<HanoiStep> stack = new Stack<>();
// stack.push(new HanoiStep(n, startStab, zielStab, hilfsStab));

// while (!stack.isEmpty()) {
// HanoiStep step = stack.pop();
// n = step.n;
// startStab = step.startStab;
// zielStab = step.zielStab;
// hilfsStab = step.hilfsStab;

// if (n > 0) {
// stack.push(new HanoiStep(n - 1, hilfsStab, zielStab, startStab));
// stack.push(new HanoiStep(n - 1, startStab, hilfsStab, zielStab));
// }
// }
// }

// static class HanoiStep {
// int n;
// char startStab;
// char zielStab;
// char hilfsStab;

// HanoiStep(int n, char startStab, char zielStab, char hilfsStab) {
// this.n = n;
// this.startStab = startStab;
// this.zielStab = zielStab;
// this.hilfsStab = hilfsStab;
// }
// }
// }
