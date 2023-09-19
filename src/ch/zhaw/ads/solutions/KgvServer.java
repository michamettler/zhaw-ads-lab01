package ch.zhaw.ads.solutions;

import ch.zhaw.ads.CommandExecutor;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class KgvServer implements CommandExecutor {

    @Override
    public String execute(String s) {
        String[] numbers = s.split("[ ,]+");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        return Integer.toString(kgv(a,b));
    }

    public int kgv(int a, int b) {
        if (a == 0 || b == 0) return 0;
        if (a % b == 0) return a;
        if (b % a == 0) return b;
        int first = a;
        int second = b;

        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }

        // Da das kleinste gemeinsame Vielfache (kgV) zweier Zahlen der Quotient aus ihrem Produkt und ihrem ggT ist,
        // lässt sich mit ihm auch das kgV ermitteln.
        // Source: https://www.lernhelfer.de/schuelerlexikon/mathematik/artikel/euklidischer-algorithmus#:~:text=MATHEMATIK-,Der%20sogenannte%20euklidische%20Algorithmus%20ist%20ein%20Verfahren%20zum%20Ermitteln%20des,ihm%20auch%20das%20kgV%20ermitteln.
        return first*second / a;
    }



}
