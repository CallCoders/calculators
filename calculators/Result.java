package mytests.calculators;

/**
 * Created by PavelOsipenko on 17.02.2016.
 */
public class Result {
    public double acc; // Аккумулятор
    public String rest; // остаток строки, которую мы еще не обработали

    public Result(double v, String r) {
        this.acc = v;
        this.rest = r;
    }
}
