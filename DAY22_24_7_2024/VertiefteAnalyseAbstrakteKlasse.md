# Aufgabenstellung:

Ein weiteres Konzept ist dazu gekommen → ✨ **Abstrakte Klassen** ✨

Ordne es in deiner Analyse von gestern ein. Es ist entscheidend, genau zu wissen, wann man Vererbung, Polymorphie, abstrakte Klassen und Interfaces einsetzt. Erkläre die Rolle jeder der vier Konzepte in der objektorientierten Programmierung so einfach wie möglich. Veranschauliche die Unterschiede und die typischen Einsatzszenarien, wann welches Konzept am besten genutzt werden sollte.

/--Antworten--/

1. Vererbung (Inheritance)
   Rolle:
   Vererbung ist eine Methode, um eine Beziehung zwischen neuen Klassen und bestehenden Klassen herzustellen. Die neue Klasse (Unterklasse) erbt von der bestehenden Klasse (Oberklasse) und übernimmt deren Eigenschaften und Methoden.

Einsatzszenarien:

Wenn du eine neue Klasse erstellen möchtest, die ähnlich zur bestehenden Klasse ist, aber in einigen Punkten abweicht.
Code-Wiederverwendung, um die erneute Implementierung derselben Funktionalität zu vermeiden.
Beispiel:

java
Code kopieren
class Tier {
void essen() {
System.out.println("Dieses Tier frisst Nahrung.");
}
}

class Hund extends Tier {
void bellen() {
System.out.println("Der Hund bellt.");
}
}

2. Polymorphie (Polymorphism)
   Rolle:
   Polymorphie ermöglicht es, mit einem Verweis auf die Oberklasse verschiedene Unterklassenobjekte zu manipulieren. Dadurch kann das Programm unterschiedliche Objekttypen ohne Änderung des Codes verarbeiten.

Einsatzszenarien:

Wenn du Code schreiben möchtest, der mit verschiedenen, aber verwandten Objekttypen arbeitet.
Durch Schnittstellen oder abstrakte Klassen Polymorphie erreichen, damit verschiedene Klassen dieselben Methoden implementieren können.
Beispiel:

java
Code kopieren
Tier meinTier = new Hund();
meinTier.essen(); // Ausgabe: Dieses Tier frisst Nahrung.

3. Abstrakte Klasse (Abstract Class)
   Rolle:
   Eine abstrakte Klasse kann nicht instanziiert werden und dient nur als Basis für andere Klassen. Sie kann abstrakte Methoden (ohne Implementierung) und konkrete Methoden (mit Implementierung) enthalten.

Einsatzszenarien:

Wenn du eine gemeinsame Basis für eine Gruppe verwandter Klassen bereitstellen möchtest, die nicht instanziiert werden soll.
Wenn du einige Methoden implementieren möchtest, aber andere Methoden von den Unterklassen implementiert werden sollen.
Beispiel:

java
Code kopieren
abstract class Tier {
abstract void geraeuschMachen();

    void essen() {
        System.out.println("Dieses Tier frisst Nahrung.");
    }

}

class Hund extends Tier {
void geraeuschMachen() {
System.out.println("Der Hund bellt.");
}
}

4. Schnittstelle (Interface)
   Rolle:
   Eine Schnittstelle ist eine vollständig abstrakte Klasse, die eine Gruppe von Methoden definiert, die von den implementierenden Klassen implementiert werden müssen. Eine Schnittstelle enthält keine Felder oder Implementierungen von Methoden.

Einsatzszenarien:

Wenn du eine Gruppe von Methoden definieren möchtest, ohne deren Implementierung vorzugeben.
Wenn du möchtest, dass mehrere nicht verwandte Klassen dieselben Methoden implementieren.
Beispiel:

java
Code kopieren
interface Tier {
void geraeuschMachen();
}

class Hund implements Tier {
public void geraeuschMachen() {
System.out.println("Der Hund bellt.");
}
}
Zusammenfassung und Vergleich:
Vererbung: Wird verwendet, um Code wiederzuverwenden; Unterklassen erben die Eigenschaften und Methoden der Oberklasse.
Polymorphie: Ermöglicht die Verwendung eines Oberklasse-Verweises, um verschiedene Unterklassenobjekte zu verarbeiten und bietet so Flexibilität im Code.
Abstrakte Klasse: Dient als Basis für andere Klassen, kann nicht instanziiert werden und bietet sowohl implementierte als auch nicht implementierte Methoden.
Schnittstelle: Definiert eine Gruppe von Methoden ohne Implementierung, die von mehreren Klassen implementiert werden können.
Typische Einsatzszenarien:

Vererbung: Verwende sie zur Code-Wiederverwendung.
Polymorphie: Verwende sie, um mit verschiedenen, aber verwandten Objekttypen zu arbeiten.
Abstrakte Klasse: Verwende sie, um eine gemeinsame Basis für verwandte Klassen zu schaffen, die nicht instanziiert werden soll.
Schnittstelle: Verwende sie, um eine Gruppe von Methoden zu definieren, die von mehreren nicht verwandten Klassen implementiert werden sollen.
Diese Erklärungen sollten dir helfen, die Konzepte und ihre Anwendungsfälle besser zu verstehen.
