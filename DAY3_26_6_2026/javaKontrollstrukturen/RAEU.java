package DAY3_26_6_2026.javaKontrollstrukturen;
// Reihenfolge der Array-Elemente umdrehen

//Gegeben ist ein Array mit Integern. Verdrehe die Reihenfolge der Elemente im Array.
// Dass heißt,aus{1,2,3,4,5,6,7,8,9}soll{9,8,7,6,5,4,3,2,1}werden

public class RAEU {
    public static void main(String args[]) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // Platz für deine Lösung
        RAEU raeu = new RAEU();
        raeu.umdrehen(arr);
    }

    private int[] umdrehen(int[] arr) {
        int[] tempArr = new int[arr.length];
        int account = 1;
        for (int ar : arr) {
            tempArr[arr.length - account] = ar;
            account++;
        }

        int account2 = 0;
        for (int ar : tempArr) {
            System.out.println(account2 + "te Zahl in new Array " + ar);
            account2++;
        }
        return tempArr;
    }
}
