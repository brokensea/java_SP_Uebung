package DAY3_26_6_2026.javaKontrollstrukturen;

// Maximum und Minimum eines Arrays ermitteln
// Gegeben ist ein Array mit Integern. Ermittle das Größte und das Kleinste Element des Arrays und gebe es aus. 
public class MMAE {
    public static void main(String[] args) {
        MMAE mmae = new MMAE();
        int arr[] = { 3, 44, 87, 2, 4, 99, 112, -1, 9, 14, 89, 21 };

        mmae.maxUndMinInArray(arr);
    }

    private void maxUndMinInArray(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int ar : arr) {
            if (max < ar) {
                max = ar;
            }
            if (min > ar) {
                min = ar;
            }
        }
        System.out.println("Max in Array ist: " + max);
        System.out.println("Min in Array ist: " + min);
    }
}
