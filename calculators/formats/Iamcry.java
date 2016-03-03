package mytests.calculators.formats;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by PavelOsipenko on 03.03.2016.
 */
public class Iamcry {
    public static void main(String[] args) {
        String str = "asssk sak asssk asdsdk ask asssssk aaaaaaaak aaak   a aaaa a a aa ka kasa asask";
        Pattern p = Pattern.compile("\\b[aA].*?[kK]\\b");
        Matcher m = p.matcher(str);

        int count = 0;
        while(m.find()) count++;
        System.out.println(count);
    }
}