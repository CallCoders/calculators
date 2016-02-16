package mytests.calculators;

/**
 * Created by PavelOsipenko on 16.02.2016.
 */
public class MemCalc extends SimpleCalc implements Memorizeble {
   private double memory;

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    @Override
    public void clearMem() {
        memory = 0;
    }

    @Override
    public void setMem(double data) {
        memory = data;
    }

    @Override
    public void addToMem(double data) {
        memory =+ data;
    }

    @Override
    public void reduceMem(double data) {
        memory =-data;
    }


}
