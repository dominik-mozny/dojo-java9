package ch.adesso.pkg.without.modules;

import ch.adesso.pkg.branch.Branch;
import ch.adesso.pkg.branch.zurich.BranchZurich;

/**
 * @author dominik.mozny
 */
public class Main {
    public static void main(String[] args) {
        Branch branch = new BranchZurich();
        System.out.println(branch.getInfo());
    }
}
