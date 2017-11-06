/**
 * @author dominik.mozny
 */
module ch.adesso.module.branchBern {
    requires transitive ch.adesso.module.branch;
    exports ch.adesso.branch.bern;
    provides ch.adesso.pkg.branch.Branch with ch.adesso.branch.bern.BranchBern;
}