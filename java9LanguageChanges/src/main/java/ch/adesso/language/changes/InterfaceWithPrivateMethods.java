package ch.adesso.language.changes;

/**
 * @author dominik.mozny
 */
public interface InterfaceWithPrivateMethods {
    /**
     * New in Java 9
     */
    private void privateMethod() {
    }

    /**
     * New in Java 9
     */
    private static void staticPrivateMethod() {
    }

    /**
     * Possible since Java 8
     */
    public static void publicStaticMethod() {

    }

    /**
     * Possible since Java 8
     */
    public default void publicDefaultMethod() {

    }
}
