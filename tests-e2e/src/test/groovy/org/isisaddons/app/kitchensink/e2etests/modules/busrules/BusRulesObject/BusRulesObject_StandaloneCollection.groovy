package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject

import org.isisaddons.app.kitchensink.e2etests.base.StandaloneCollectionModule

class BusRulesObject_StandaloneCollection extends StandaloneCollectionModule {

    static base = { $(".standaloneCollectionPage") }

    static content = {
        table(wait: true) { $(".isis-busrules-busrulesobject .collectionContentsAsAjaxTablePanel table") }
    }

}
