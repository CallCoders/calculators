package mytests.calculators;

import java.io.*;

/**
 * Created by PavelOsipenko on 16.02.2016.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        //Читаем из аргумента строки имя (пусть) файла
        String fileName = args[0];

        //Читаем содержимое файла и разбираем его
        FileInputStream fis = new FileInputStream(fileName);
        byte[] byteBuffer = new byte[fis.available()];
        fis.read(byteBuffer);
        
        //Читаем формулу из файла
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < byteBuffer.length; i++) {
            if (!(byteBuffer[i] == 13) && !(byteBuffer[i] == 10)) {
                sb.append(((char) byteBuffer[i]));
            }
        }
        String formula = sb.toString();

        //Создаем экземпляр калькулятора заданного типа
        int calcType = byteBuffer[0];
//        Calc calc = createCalc(calcType);

        System.out.println("Формула: " + formula);
        SimpleCalc calc = new SimpleCalc();
        System.out.println("Результат: " + calc.calculate(formula));
    }

//    public static Calc createCalc(int typeCalc) {
//        switch (typeCalc) {
//            case 1:
//                return new SimpleCalc();
//            case 2:
//                return new MemCalc();
//            case 3:
//                return new EngineeringCalc();
//            case 4:
//                return new EngineeringMemCalc();
//            default:break;
//        }
//        return null;
//    }
}
