package ch.adesso.pkg.branch.zurich;

import ch.adesso.pkg.branch.Branch;

/**
 * @author dominik.mozny
 */
public class BranchZurich implements Branch {
    @Override
    public String getInfo() {
        return "Branch Zurich, module: " + getClass().getModule().getName();
    }
}
