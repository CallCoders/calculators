package mytests.calculators;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by PavelOsipenko on 09.03.2016.
 */
public class SolutionTest {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String phr;
        Integer numb, lim;
        phr = String.valueOf(in.readLine());
        lim = Integer.valueOf(in.readLine());
        numb = 0;
        while (lim > numb) {
            numb++;
            System.out.println(phr);
        }
    }
}
