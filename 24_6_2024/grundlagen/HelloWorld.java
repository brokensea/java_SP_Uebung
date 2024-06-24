package grundlagen;

public class HelloWorld {
        public static void main(String[] args) {
                System.out.println(
                                "Ein guter Programmierer sollte grundlegende Kenntnisse im Umgang mit dem Terminal (auch Kommandozeile oder Shell genannt) haben.\n"
                                                + //
                                                "\n" + //
                                                "- gehe mit Hilfe des Terminals in das Verzeichnis Desktop\n" + //
                                                "- erstelle mit Hilfe des Terminals einen neuen Ordner Namens *SuperCode* und gehe in den Ordner rein\n"
                                                + //
                                                "- erstelle im Ordner *SuperCode* einen neuen Ordner mit dem Namen *Grundlagen*\n"
                                                + //
                                                "- im Ordner Grundlagen sollst du nun eine Datei namens *HelloWorld.java* erstellen\n"
                                                + //
                                                "- lass dir den aktuellen Pfad anzeigen");
                System.out.println("1. **Aktuellen Pfad anzeigen:**\n" + //
                                "\n" + //
                                "```java\n" + //
                                "pwd\n" + //
                                "```\n" + //
                                "\n" + //
                                "1. **Liste von Dateien und Verzeichnissen anzeigen:**\n" + //
                                "\n" + //
                                "```java\n" + //
                                "ls\n" + //
                                "```\n" + //
                                "\n" + //
                                "1. **Verzeichniswechsel:**\n" + //
                                "\n" + //
                                "```java\n" + //
                                "cd Verzeichnisname\n" + //
                                "```\n" + //
                                "\n" + //
                                "—> Tip: ihr müsst den Namen nicht vollständig eintippen. Sobald ihr den eindeutigen Anfang eingetippt habt, könnt ihr den Verzeichnisnamen mit der Tab Taste auffüllen lassen");
                System.out.println("Ordner erstellen:\n" + //
                                "mkdir Ordnername\n" + //
                                "​\n" + //
                                "Datei erstellen:\n" + //
                                "touch Dateiname");
        }
}