package DAY14_11_7_2024.oop;

import java.text.DateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

// 1.**Aktuelles Datum und Uhrzeit:**

// Schreibe ein Programm,das das aktuelle Datum und die aktuelle Uhrzeit in verschiedenen Formaten ausgibt.

// 2.**Datum in die Zukunft oder Vergangenheit verschieben:**

// Schreibe ein Programm,das ein Datum um eine bestimmte Anzahl von Tagen in die Zukunft oder Vergangenheit verschiebt und das Ergebnis anzeigt.

// 3.**Alter berechnen:**

// Schreibe ein Programm,das das Alter einer Person basierend auf ihrem Geburtsdatum berechnet.

// 4.**Zeitdifferenz zwischen zwei Zeitpunkten berechnen**

// Schreibe ein Programm,das die Zeitdifferenz zwischen zwei Zeitpunkten in Stunden und Minuten berechnet.

// 5.**Wochentag eines bestimmten Datums ermitteln**

// Schreibe ein Programm,das den Wochentag eines bestimmten Datums ermittelt.
public class DateAndTime {

    public static void main(String[] args) {
        // 1.
        // aktuellesDatumUhrzeit();

        // 2.
        // zukunftOderVergangenheitVerschieben(2);

        // 3,
        // LocalDate geburtsdatum = LocalDate.of(1900, 7, 11);
        // alterBerechnen(geburtsdatum);

        // 4
        // LocalDateTime von = LocalDateTime.of(1990, 7, 11, 10, 30);
        // LocalDateTime zu = LocalDateTime.of(1991, 7, 11, 15, 45);

        // LocalDateTime von = LocalDateTime.of(2024, 7, 11, 10, 0);
        // LocalDateTime zu = LocalDateTime.of(2024, 7, 11, 15, 33);
        // String zeitdifferenz = zeitdifferenzZweiZeitpunktenBerechnen(von, zu);

        // 5
        LocalDate tag = LocalDate.of(2024, 7, 10);
        wochentagDatumsErmitteln(tag);

    }

    public static void aktuellesDatumUhrzeit() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MMM HH:mm ");

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd | MM | yyyy |-| HH | mm ");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("E dd.MMM HH:mm");

        // dd：代表两位数的日期（例如，01到31）。
        // MM：代表两位数的月份（例如，01到12）。
        // yyyy：代表四位数的年份（例如，2024）。
        // HH：代表两位数的小时（24小时制，00到23）。
        // mm：代表两位数的分钟（例如，00到59）。

        // G: 公元纪年标志（例如 AD 公元）
        // y: 年份（例如 2024）
        // M: 月份（例如 07 或者 Jul）
        // d: 月中的天数（例如 11）
        // E: 星期几（例如 Tue）
        // a: AM/PM 标志
        // H: 24小时制的小时（例如 14）
        // h: 12小时制的小时（例如 02）
        // m: 分钟（例如 30）
        // s: 秒（例如 45）
        // S: 毫秒（例如 978）
        // z: 时区缩写（例如 PDT）
        // Z: 时区偏移量（例如 -0800）
        // 'text': 用于将文本插入到格式中

        System.out.println(localDateTime.format(dateTimeFormatter));
        System.out.println(localDateTime.format(format1));
        System.out.println(localDateTime.format(format2));
    }

    public static void zukunftOderVergangenheitVerschieben(int tagen) {
        LocalDateTime localDateTime = LocalDateTime.now();
        // definit DateTimeFormatter
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd,MM,yy| - HH : mm");
        System.out.println("Aktuelles Datum und Uhrzeit: " + localDateTime.format(dateTimeFormatter));

        // verschieben
        LocalDateTime neuesDatum = localDateTime.plusDays(tagen);

        // print
        System.out.println("Verschobenes Datum und Uhrzeit: " + neuesDatum.format(dateTimeFormatter));

        // verschieben
        LocalDateTime neuesDatumVergangenheit = localDateTime.minusDays(tagen);

        // print
        System.out.println("Verschobenes Datum und Uhrzeit: " + neuesDatumVergangenheit.format(dateTimeFormatter));
    }

    public static int alterBerechnen(LocalDate geburtsdatum) {
        LocalDate heute = LocalDate.now();
        Period period = Period.between(geburtsdatum, heute);
        int alter = period.getYears();

        System.out.println("Alter ist " + alter);
        return alter;

    }

    public static String zeitdifferenzZweiZeitpunktenBerechnen(LocalDateTime von, LocalDateTime zu) {
        Duration duration = Duration.between(von, zu);

        long stunden = duration.toHours();
        long minuten = duration.toMinutes() % 60;

        String output = String.format("%d Stunden %d Minuten", stunden, minuten);
        System.out.println(output);
        return output;

    }

    public static DayOfWeek wochentagDatumsErmitteln(LocalDate lDate) {
        DayOfWeek tag;
        tag = lDate.getDayOfWeek();
        int tagNummer = tag.getValue();
        System.out.println(tag + " ; " + tagNummer + " von Woche");
        return tag;
    }

}
