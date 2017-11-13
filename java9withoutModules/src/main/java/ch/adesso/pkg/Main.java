package ch.adesso.pkg;

import ch.adesso.branch.zurich.BranchZurich;
import ch.adesso.pkg.branch.Branch;

/**
 * @author dominik.mozny
 */
public class Main {
    public static void main(String[] args) {
        Branch branch = new BranchZurich();
        System.out.println(branch.getInfo());
    }
}
