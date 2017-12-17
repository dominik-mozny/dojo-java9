package ch.adesso.language.changes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author dominik.mozny
 */
public class LanguageChanges {
    public static void main(String[] args) throws Exception {
        howToObtainListOfObjects();
        howToObtainSetOfObjects();
        diamondOperatorCanBeUsedWithAnonymousClass();
        streamIteratorWithCondition();
        streamIteratorWithTakeWhileCondition();
        streamIteratorWithDropWhileCondition();
        tryWithResourcesEffectivelyFinal();
        optionalIfPresentOrElse();
        printLast5DaysAsLocalDate();
        writeOnlyWords();
        writeOnlyNumbers();
        startTaskAndStopThenIfRunningTooLong();
        closeNotepadWithProcessHandle();
        startProcessesAndWaitAsynchron();
    }

    public static void howToObtainListOfObjects() {
        System.out.println("Obtaining list of objects: ");
        System.out.println(List.of(1, 2, 3, 4));
    }

    public static void howToObtainSetOfObjects() {
        System.out.println("Obtaining set of objects: ");
        System.out.println(Set.of(1, 2, 3, 4));
    }

    public static void diamondOperatorCanBeUsedWithAnonymousClass() {
        Callable<Integer> callable = new Callable<>() {
            @Override
            public Integer call() throws Exception {
                return 42;
            }
        };
    }

    public static void streamIteratorWithCondition() {
        System.out.println("Stream iterator with condition: ");
        System.out.print("Java 8 way: ");
        Stream.iterate("A", s -> s + s).limit(5).forEach(str -> System.out.print(str + " "));
        System.out.println();
        System.out.print("Java 9 way: ");
        Stream.iterate("A", s -> s.length() < 5 || s.length() > 10, s -> s + s).forEach(str -> System.out.print(str + " "));
        System.out.println();
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

    public static void printLast5DaysAsLocalDate() {
        LocalDate.now().minusDays(5).datesUntil(LocalDate.now()).forEach(date -> System.out.print(date + " "));
        System.out.println();
    }

    public static void writeOnlyWords() {
        String wordsAndNumbers = "I am 70 years old not 20 years old";
        Scanner s = new Scanner(wordsAndNumbers);
        System.out.print("Only words: ");
        s.findAll("[a-zA-Z]+").forEach(matchResult -> System.out.print(matchResult.group() + " "));
        System.out.println();
    }

    public static void writeOnlyNumbers() {
        String wordsAndNumbers = "I am 70 years old not 20 years old";
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(wordsAndNumbers);
        System.out.print("Only numbers: ");
        matcher.results().forEach(matchResult -> System.out.print(matchResult.group() + " "));
        System.out.println();
    }

    public static void startTaskAndStopThenIfRunningTooLong() {
        List<Supplier<String>> suppliers = List.of(
                () -> sleepAndGetValue(100),
                () -> sleepAndGetValue(500),
                () -> sleepAndGetValue(50)
        );
        for(Supplier<String> supplier: suppliers) {
            CompletableFuture.supplyAsync(supplier)
                    .orTimeout(200, TimeUnit.MILLISECONDS)
                    .whenComplete((r, e) -> {
                        if(r != null) System.out.println("Good job: " + r);
                        if(e!= null) System.out.println("This supplier was too lazy.");
                    });
        }

    }

    private static String sleepAndGetValue(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "I am done after " + millis + " ms.";
    }

    public static void closeNotepadWithProcessHandle() throws IOException {
//        ProcessHandle.allProcesses().filter(p -> p.info().command().isPresent() &&
//                p.info().command().get().equals("C:\\Windows\\System32\\notepad.exe")).findFirst().ifPresent(p -> p.destroy());
    }

    public static void startProcessesAndWaitAsynchron() throws IOException, InterruptedException {
        Process process = new ProcessBuilder("C:\\Windows\\System32\\notepad.exe").start();
        CompletableFuture<Process> processCompletableFuture = process.onExit();
        CompletableFuture.anyOf(processCompletableFuture).thenRun(() -> System.out.println("Notepad application has been shutdown."));
        System.out.println("End of process");
        Thread.sleep(10000);
    }

}
