package DAY13_10_7_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//Verwendung von ArrayLists in Java

// In dieser Aufgabe wirst du die grundlegenden Funktionen von ArrayLists in Java kennenlernen und anwenden.Du wirst eine ArrayList erstellen,Elemente hinzufügen,entfernen,die Größe der Liste abrufen,Elemente abrufen,die Liste durchlaufen,sortieren,nach einem Element suchen,eine Teil-ArrayList erstellen und Duplikate entfernen.

// 1.**ArrayList erstellen und Elemente hinzufügen:**-Erstelle eine**`ArrayList`**-Füge die Zahlen von 1 bis 5 zur Liste hinzu.
// 2.**Elemente entfernen:**-Entferne die Zahl 3 aus der Liste.
// 3.**Größe der ArrayList:**-Gib die Größe der Liste aus.
// 4.**Elemente abrufen:**-Gib das Element an der Position 2 aus.
// 5.**ArrayList durchlaufen:**-Verwende eine Schleife,um alle Elemente in der Liste auszugeben.
// 6.**Elemente sortieren:**-Füge weitere Zahlen zur Liste hinzu und sortiere die Liste in aufsteigender Reihenfolge.-Tipp✨:Verwende die Methode`sort`
// 7.**Suche nach einem Eleme**-Überprüfe,ob die Liste die Zahl 4 enthält.-Tipp✨ :Verwende die Methode`contains`
// 8.**Teil-ArrayList erstellen:**-Erstelle eine neue ArrayList,die nur die ersten 3 Elemente der ursprünglichen Liste enthält.-Tipp✨ :Verwende die Methode`subList`
// 9.**Duplikate entfernen:**-Implementiere eine Methode,die Duplikate aus einer ArrayList entfernt und eine neue Liste ohne Duplikate zurückgibt-Tipp✨ :auch hierfür gibt es bereits eine Methode😉

// 10.**Array→ArrayList**-Dir ist ein Array mit Integer Zahlen gegeben:
// int[]data={1,5,6,11,3,15,7,8,12,21,9,1038};​ 
//Teile dieses Array auf in zwei ArrayListen auf,eine für alle geraden Zahlen und eine für alle ungeraden Zahlen.

public class VerwendungArrayLists {

    public static void main(String[] args) {
        // 1:
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList);
        // 2
        arrayList.remove(Integer.valueOf(3));
        System.out.println(arrayList);
        // 3
        int size = arrayList.size();
        System.out.println(size);
        // 4
        System.out.println(arrayList.get(1));
        System.out.println();
        // 5
        arrayList.forEach(element -> System.out.println(element));
        // 6
        for (int i = 1; i <= 10; i++) {
            arrayList.add(i);
        }
        arrayList.sort(Comparator.naturalOrder());
        System.out.println("6: ");
        System.out.println(arrayList);
        arrayList.sort((o2, o1) -> o1 - o2);
        System.out.println("6: ");
        System.out.println(arrayList);
        // 7
        boolean contains4 = arrayList.contains(4);
        System.out.println("7: ");
        System.out.println(contains4);

        // 8.
        ArrayList arrayList2;
        arrayList2 = new ArrayList<>(arrayList.subList(0, 3));
        System.out.println("8: ");
        System.out.println(arrayList2);

        // 9
        ArrayList arrayListRemovedDupli = removeDuplikate(arrayList);
        System.out.println("9: ");
        System.out.println(arrayListRemovedDupli);

        ArrayList<Integer> newList2 = arrayList.stream().distinct().collect(Collectors.toCollection(ArrayList::new));

        System.out.println("9-2: ");
        System.out.println(newList2);

        // 10
        int[] data = { 1, 5, 6, 11, 3, 15, 7, 8, 12, 21, 9, 1038 };
        ArrayList<Integer> geradenZahlen = new ArrayList<>();
        ArrayList<Integer> ungeradenZahlen = new ArrayList<>();
        for (Integer d : data) {
            if (d % 2 == 0) {
                geradenZahlen.add(d);
            } else {
                ungeradenZahlen.add(d);
            }
        }
        System.out.println("10: Gerade");
        System.out.println(geradenZahlen);
        System.out.println("10: Ungerade");
        System.out.println(ungeradenZahlen);

        System.out.println("10-2:");

        // .boxed()
        // boxed() 是 IntStream 接口中定义的一个方法，用于将原始类型的流（如 IntStream、LongStream、DoubleStream
        // 等）中的每个元素装箱为对应的包装类型。
        List<Integer> dataList = Arrays.stream(data).boxed().collect(Collectors.toList());

        //
        List<Integer> evenList = dataList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        List<Integer> oddList = dataList.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());

        // Output
        System.out.println("Gerade:");
        System.out.println(evenList);
        System.out.println("Ungerade:");
        System.out.println(oddList);

    }

    public static ArrayList<Integer> removeDuplikate(ArrayList<Integer> arrayList) {
        HashSet<Integer> set = new HashSet<>(arrayList);
        ArrayList<Integer> arrayListNew = new ArrayList<>(set);
        return arrayListNew;

    }

}
