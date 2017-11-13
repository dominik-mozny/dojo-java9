//example of import inside module definition

import ch.adesso.pkg.branch.Branch;
import ch.adesso.pkg.branch.zurich.BranchZurich;

/**
 * @author dominik.mozny
 */
module ch.adesso.module.branchZurich {
    requires transitive ch.adesso.module.branch;
    exports ch.adesso.pkg.branch.zurich;
    provides Branch with BranchZurich;
}