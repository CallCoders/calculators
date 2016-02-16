package mytests.calculators;

/**
 * Created by PavelOsipenko on 16.02.2016.
 */
public class EngineeringCalc extends SimpleCalc implements Functionable {


    @Override
    public double calcSyn(double data) {
        return Math.sin(data);
    }

    @Override
    public double calcExp(double data) {
        return Math.exp(data);
    }

    @Override
    public double calcSqrt(double data) {
        return Math.sqrt(data);
    }
}
