# Zugriffsschutz und Packages einer Bibliothek

# ✅ Aufgabenstellung:

**Schritt 1: Package-Struktur 📦**

Erstelle folgende Package-Struktur:

- `com.example.library`
- `com.example.main`

**Schritt 2: Klasse `Book` im Package `com.example.library` 📦**

1. Erstelle eine Klasse `Book` mit den folgenden Feldern:

   - `private String title`
   - `protected String author`
   - `String isbn` (package-private)
   - `public int year`

   [Access Modifier](https://www.notion.so/Access-Modifier-807f5f495d894332b6de09bbcf0ae20e?pvs=21)

2. Implementiere in der Klasse `Book`:
   - Einen Konstruktor, der alle Felder initialisiert
   - Getter- & Setter-Methoden für alle Felder

**Schritt 3: Klasse `Library` im Package `com.example.library` 📦**

1. Erstelle eine Klasse `Library` mit einer Liste von `Book` Objekten (verwende `ArrayList`)
2. Implementiere Methoden zum Hinzufügen und Auflisten von Büchern
3. Erstelle eine Methode `printBookDetails(Book book)`, die die Details eines Buches ausgibt. Teste die Zugänglichkeit der Felder von `Book.`

**Schritt 4: Klasse `Main` im Package `com.example.main` 📦**

1. Erstelle eine Klasse `Main` mit der `main`Methode.
2. Erstelle eine Instanz von `Library` und füge einige `Book` Objekte hinzu.
3. Rufe die Methoden der `Library` auf, um die Bücher aufzulisten und deren Details anzuzeigen.

# Bibliothek Expansion - Abstrakte Klasse

# ✅ Aufgabenstellung

**Vererbung und Polymorphismus:**

Erweitere das Projekt, um verschiedene Arten von Büchern zu unterstützen (z.B. E-Books und gedruckte Bücher).

1. Mache aus deiner Klasse Book eine **abstrakte Klasse** `Book` mit den gemeinsamen Eigenschaften (`title`, `author`, `isbn`, `year`) und Methoden (`getTitle()`, `getAuthor()`, etc.).
2. Erstelle zwei konkrete Unterklassen `EBook` und `PrintedBook`, die von `Book` erben. Jede dieser Klassen sollte spezifische Eigenschaften und Methoden haben, z.B.:
   - `EBook`: Feld `fileSize` (Dateigröße in MB), Methode `download()`.
   - `PrintedBook`: Feld `weight` (Gewicht in Gramm), Methode `ship()`.

**Interface für verschiedene Buchtypen**

1. Erstelle ein Interface `Readable` mit einer Methode `read()`.
2. Implementiere das Interface in den Klassen `EBook` und `PrintedBook`.
3. Implementiere die Methode `read()` entsprechend für jede Klasse (`EBook` könnte z.B. eine Lesesoftware öffnen, `PrintedBook` könnte die erste Seite ausgeben).

**Erweiterte Suche**

1. Implementiere eine Methode `findBooksByAuthor(String author)` in der Klasse `Library`, die alle Bücher eines bestimmten Autors zurückgibt.

### **Und weil Übung den Meister macht:**

**Benutzerverwaltung**

1. Implementiere eine einfache Benutzerverwaltung, die es ermöglicht, verschiedene Benutzer mit unterschiedlichen Rechten anzulegen (z.B. Administratoren und normale Benutzer).

**Leihsystem**

1. Implementiere ein System zum Ausleihen und Zurückgeben von Büchern.
2. Verwende eine Klasse `User` und eine Klasse `Loan`, um die Ausleihvorgänge zu verwalten.

# Vertiefte Analyse - Abstrakte Klasse

# ✅ Aufgabenstellung:

Ein weiteres Konzept ist dazu gekommen → ✨ **Abstrakte Klassen** ✨

Ordne es in deiner Analyse von gestern ein. Es ist entscheidend, genau zu wissen, wann man Vererbung, Polymorphie, abstrakte Klassen und Interfaces einsetzt. Erkläre die Rolle jeder der vier Konzepte in der objektorientierten Programmierung so einfach wie möglich. Veranschauliche die Unterschiede und die typischen Einsatzszenarien, wann welches Konzept am besten genutzt werden sollte.
