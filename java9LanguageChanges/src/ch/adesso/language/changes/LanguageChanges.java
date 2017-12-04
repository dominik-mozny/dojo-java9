package ch.adesso.language.changes;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author dominik.mozny
 */
public class LanguageChanges {
    public static void main(String[] args) throws Exception {
        howToObtainListOfObjects();
        howToObtainSetOfObjects();
        streamIteratorWithCondition();
        streamIteratorWithTakeWhileCondition();
        streamIteratorWithDropWhileCondition();
        tryWithResourcesEffectivelyFinal();
        optionalIfPresentOrElse();
    }

    public static void howToObtainListOfObjects() {
        System.out.println("Obtaining list of objects: ");
        System.out.println(List.of(1, 2, 3, 4));
    }

    public static void howToObtainSetOfObjects() {
        System.out.println("Obtaining set of objects: ");
        System.out.println(Set.of(1, 2, 3, 4));
    }

    public static void streamIteratorWithCondition() {
        System.out.println("Stream iterator with condition: ");
        System.out.println("Java 8 way: ");
        Stream.iterate("A", s -> s + s).limit(5).forEach(System.out::println);
        System.out.println("Java 9 way: ");
        Stream.iterate("A", s -> s.length() < 5, s -> s + s).forEach(System.out::println);
    }

    public static void streamIteratorWithTakeWhileCondition() {
        System.out.println("Stream iterator with takeWhile condition: ");
        IntStream.range(0, 10).takeWhile(i -> i < 5).forEach(System.out::println);
    }

    public static void streamIteratorWithDropWhileCondition() {
        System.out.println("Stream iterator with dropWhile condition: ");
        IntStream.range(0, 10).dropWhile(i -> i < 5).forEach(System.out::println);
    }

    public static void tryWithResourcesEffectivelyFinal() throws Exception {
        AutoCloseable ac = () -> System.out.println("AutoCloseable call at the end.");
        try (ac) {
        }
    }

    public static void optionalIfPresentOrElse() {
        Optional opt = Optional.empty();
        opt.ifPresentOrElse(
                presentValue -> System.out.println("This value was set: " + presentValue),
                () -> System.out.println("No value set.")
        );

    }
}
