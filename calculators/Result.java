package mytests.calculators;

/**
 * Created by PavelOsipenko on 17.02.2016.
 */


public class Result {
    public double acc; // Аккумулятор
    public String startPart; // начало строки, которую мы еще не обработали
    public String lastPart; // остаток строки, которую мы еще не обработали

    /**
     *
     * @param startPart - начало строки
     * @param acc - текущее значение результата
     * @param lastPart - оставшая строка
     */
    public Result(String startPart, double acc, String lastPart) {
        this.acc = acc;
        this.startPart = startPart;
        this.lastPart = lastPart;
    }
}
