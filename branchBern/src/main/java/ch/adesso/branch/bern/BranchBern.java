package ch.adesso.branch.bern;

import ch.adesso.pkg.branch.Branch;

/**
 * @author dominik.mozny
 */
public class BranchBern implements Branch {
    private int notVisibleField = 1234;


    @Override
    public String getInfo() {
        return "Branch Bern, module: " + getClass().getModule().getName();
    }
}
