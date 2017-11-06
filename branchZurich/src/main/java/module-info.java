/**
 * @author dominik.mozny
 */
module ch.adesso.module.branchZurich {
    requires transitive ch.adesso.module.branch;
    exports ch.adesso.branch.zurich;
    provides ch.adesso.pkg.branch.Branch with ch.adesso.branch.zurich.BranchZurich;
}