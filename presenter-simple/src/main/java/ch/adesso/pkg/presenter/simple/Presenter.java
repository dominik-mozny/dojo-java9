package ch.adesso.pkg.presenter.simple;

import ch.adesso.pkg.branch.Branch;
import ch.adesso.pkg.branch.bern.BranchBern;

/**
 * @author dominik.mozny
 */
public class Presenter {
    public static void main(String[] args) {
        Branch branch = new BranchBern();
        System.out.println(branch.getInfo());
    }
}
