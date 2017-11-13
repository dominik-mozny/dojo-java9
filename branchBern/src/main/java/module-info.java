/**
 * @author dominik.mozny
 */
//it is also possible to use open module ch.adesso.module.branchBern and omit opens ch.adesso.branch.bern;
//for more information: https://stackoverflow.com/questions/46482364/what-is-an-open-module-in-java-9-and-how-to-use-it
module ch.adesso.module.branchBern {
    requires transitive ch.adesso.module.branch;
    exports ch.adesso.branch.bern;
    opens ch.adesso.branch.bern;
    provides ch.adesso.pkg.branch.Branch with ch.adesso.branch.bern.BranchBern;
}