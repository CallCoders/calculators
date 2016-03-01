package mytests.calculators.formats;

/**
 * Created by PavelOsipenko on 01.03.2016.
 */
public class FormatTest {
    public static void main(String[] args) {
        double d = 10.5;
        String str1 = "ДЕСЯТИЧНОЕ ЗНАЧЕНИЕ С ПЛАВАЮЩЕЙ ТОЧКОЙ: ";
        String str2 = "Строковое представление аргумента: ";

        System.out.printf("%S %g", str1, d);
        System.out.printf("\n%S %s", str2, d);
    }
}
