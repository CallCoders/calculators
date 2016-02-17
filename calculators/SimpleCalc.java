package mytests.calculators;

/**
 * Created by PavelOsipenko on 16.02.2016.
 */
public class SimpleCalc extends Calc {

    public double calculate(String s) throws Exception {
        if (s.isEmpty())
            throw new Exception("Выражение пустое");
        Result result = additionalOrSubstraction(s);
        if (!result.rest.isEmpty())
            throw new Exception("Ошибка: не могу прочитать. rest: " + result.rest);
        return result.acc;
    }



    //Умножение/Деление
    private Result multiplicationOrDevision(String s) throws Exception
    {
        Result current = Bracket(s); // проверяем есть ли скобки. Если есть, рекурсивно вычисляем выражение в них)

        double acc = current.acc;
        while (true) {
            if (current.rest.length() == 0) {
                return current;
            }
            char sign = current.rest.charAt(0);
            if ((sign != '*' && sign != '/')) return current;

            String next = current.rest.substring(1);
            Result right = Bracket(next);

            if (sign == '*') {
                acc *= right.acc;
            } else {
                acc /= right.acc;
            }

            current = new Result(acc, right.rest);
        }
    }


    // Сложение/Вычитание
    private Result additionalOrSubstraction(String s) throws Exception
    {
//        Result current = getNextNumber(s);
        Result current = multiplicationOrDevision(s);

        double acc = current.acc;

        while (current.rest.length() > 0) {
            //если не знак + или - то  обижаемся и уходим отсюда
            if (!(current.rest.charAt(0) == '+' || current.rest.charAt(0) == '-')) break;
            //Если все-таки текущий элемент  является знаком + или -, продолжаем:
            char sign = current.rest.charAt(0);
            String next = current.rest.substring(1);
            acc = current.acc;

            //Откусили знак, остаток строки опять кидаем в метод getNextNumber
            current = getNextNumber(next);
            if (sign == '+') {
                acc += current.acc;
            } else {
                acc -= current.acc;
            }
            current.acc = acc;
        }
        //После сложения/вычитания двух чисел результат заносим в асс,
        // формируем новый обьект Result в котором асс равен нашему результату, rest равено остатку строки
        // возвращаем этот обьект вызвавшему методу
        return new Result(current.acc, current.rest);

    }

    //Отделяем число (с учетом знака) от остальной строки.
    // Возвращаем обьект Result с числом в асс и остатком строки в rest
    private Result getNextNumber(String s) throws Exception
    {
        int i = 0;
        int dot_cnt = 0;
        boolean negative = false;
        //Проверяем есть ли знак минус перед числом
        if( s.charAt(0) == '-' ){
            negative = true;
            s = s.substring( 1 );
        }
        // разрешаем только цифры и точку
        while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
            // но также проверям, что в числе может быть только одна точка!
            if (s.charAt(i) == '.' && ++dot_cnt > 1) {
                throw new Exception("not valid number '" + s.substring(0, i + 1) + "'");
            }
            i++;
        }
        if( i == 0 ){ // что-либо похожее на число мы не нашли
            throw new Exception( "can't get valid number in '" + s + "'" );
        }

        double acc = Double.parseDouble(s.substring(0, i));
        if( negative ) acc = -acc;
        String rest = s.substring(i);

        return new Result(acc, rest);
    }

    private Result Bracket(String s) throws Exception
    {
        char zeroChar = s.charAt(0);
        if (zeroChar == '(') {
            Result r = additionalOrSubstraction(s.substring(1));
            if (!r.rest.isEmpty() && r.rest.charAt(0) == ')') {
                r.rest = r.rest.substring(1);
            } else {
                System.err.println("Error: not close bracket");
            }
            return r;
        }
        return getNextNumber(s);
    }
}