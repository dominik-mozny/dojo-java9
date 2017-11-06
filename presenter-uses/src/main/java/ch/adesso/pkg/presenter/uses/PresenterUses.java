package ch.adesso.pkg.presenter.uses;

import java.util.ServiceLoader;

import ch.adesso.pkg.branch.Branch;

/**
 * @author dominik.mozny
 */
public class PresenterUses {
    public static void main(String[] args) {
        ServiceLoader<Branch> serviceLoader = ServiceLoader.load(Branch.class);
        Iterable<Branch> branchesIterator = serviceLoader;
        System.out.println("All available branches:");
        branchesIterator.forEach(branchProvider -> System.out.println(branchProvider.getInfo()));
    }
}
