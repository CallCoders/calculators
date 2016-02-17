package mytests.calculators;

/**
 * Created by PavelOsipenko on 16.02.2016.
 */
public class SimpleCalc extends Calc {

    public double calculate(String s) throws Exception {
        if (s.isEmpty())
            throw new Exception("Выражение пустое");
        Result result = additionalOrSubstraction(s);
        if (!result.lastPart.isEmpty())
            throw new Exception("Ошибка: не могу прочитать. lastPart: " + result.lastPart);
        return result.acc;
    }

    // Находим символ * или /
    public Result findMultOrDivSymbol(String s) throws Exception {
        int multDivIndex = -1;
        String startPart = "";
        String lastPart = "";

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '*') || (s.charAt(i) == '/')) {
                multDivIndex = i;
                startPart = s.substring(0, multDivIndex);
                lastPart = s.substring(multDivIndex);
            }
        }
        return new Result(startPart, multDivIndex, lastPart);
    }

    public Result multOrDev() {

    }
}