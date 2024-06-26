package DAY3_26_6_2026.javaKontrollstrukturen;

// Würfeln bis eine 6 kommt
// Schreibe ein Programm,dass so lange Zufallszahlen würfelt und ausgibt,bis eine 6 gewürfelt wurde.Benutze dafür die Methode*Math.random()*aus der Java Math Standardbibliothek.

// **Kleiner Tip**:Achte auf den Wertebereich

// **Bonus:**Wenn beim ersten Mal würfeln direkt die 6 erreicht wurde,soll eine Zusatzausgabe(z.B.“WOW!Beim ersten Treffer eine 6!”)erscheinen:
public class WuerfelnBisEine6kommt {
    public static void main(String[] args) {
        WuerfelnBisEine6kommt wuerfelnBisEine6kommt = new WuerfelnBisEine6kommt();
        wuerfelnBisEine6kommt.wuerfelnBisEine6kommt();
    }

    private void wuerfelnBisEine6kommt() {
        int wuerfelZahl = 0;
        int account = 0;
        do {
            // Math.random() liefert eine Zufallszahl vom Typ double, die größer oder gleich
            // 0.0 und kleiner als 1.0 ist. Sie schließt 0.0 ein, aber 1.0 aus.
            wuerfelZahl = (int) (Math.random() * 6) + 1;
            account++;
            if (account == 1 && wuerfelZahl == 6) {
                System.out.println("WOW ! Beim ersten Treffer eine 6 !");
            } else {
                System.out.println(account + ". Wurf. Würfelzahl ist " + wuerfelZahl);
            }
        } while (wuerfelZahl != 6);
    }
}
