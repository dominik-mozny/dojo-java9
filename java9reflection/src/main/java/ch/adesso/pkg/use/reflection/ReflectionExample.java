package ch.adesso.pkg.use.reflection;

import java.lang.reflect.Field;

import ch.adesso.pkg.branch.Branch;
import ch.adesso.pkg.branch.bern.BranchBern;

/**
 * @author dominik.mozny
 */
public class ReflectionExample {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Branch branch = new BranchBern();
        Field privateField = BranchBern.class.getDeclaredField("notVisibleField");
        privateField.setAccessible(true);
        System.out.println("Private field: " + privateField.get(branch));
    }
}
