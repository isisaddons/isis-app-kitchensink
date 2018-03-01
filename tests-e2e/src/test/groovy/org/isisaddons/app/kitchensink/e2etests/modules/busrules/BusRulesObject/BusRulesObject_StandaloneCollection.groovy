package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject

import org.isisaddons.app.kitchensink.e2etests.base.StandaloneCollectionModule

class BusRulesObject_StandaloneCollection extends StandaloneCollectionModule {

    static content = {
        table(wait: true) { $(".standaloneCollectionPage .isis-busrules-busrulesobjects-listallbusrulesobject .collectionContentsAsAjaxTablePanel table", 0) }
    }

}
