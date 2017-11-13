package ch.adesso.pkg.use.old.library;

import org.apache.commons.collections4.Predicate;
import org.joda.time.LocalTime;

/**
 * @author dominik.mozny
 */
public class Main {
    public static void main(String[] args) {
        //java 8 dependencies
        LocalTime t = LocalTime.now();
        System.out.println("Local time obtained from joda time: " + t);
        Predicate<Integer> p = i -> i < 5;
        System.out.println("Evaluation of predicate from apache.commons library: " + p.evaluate(6));
    }
}
