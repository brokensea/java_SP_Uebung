package DAY2_25_6_2024.VariablenUndDatenstrukturen;

public class Temperaturumwandler {
    public static void main(String[] args) {
        Temperaturumwandler temp = new Temperaturumwandler();
        temp.temperaturumwandler(25);
    }

    private double temperaturumwandler(double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println(celsius + " Grad sind " + fahrenheit);
        return fahrenheit;
        // (°C x 9/5) + 32 = °F;

    }
}
