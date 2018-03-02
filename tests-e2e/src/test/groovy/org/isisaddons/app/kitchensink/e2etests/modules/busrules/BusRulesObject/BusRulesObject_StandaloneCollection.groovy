package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject

import geb.Module
import org.incode.platform.lib.gebspock.wicket.ui.components.standalonecollection.StandaloneCollectionPanel

class BusRulesObject_StandaloneCollection extends Module {

    static base = { module(StandaloneCollectionPanel) }

    static content = {
        table(wait: true) { $(".isis-busrules-busrulesobject .collectionContentsAsAjaxTablePanel table") }
    }

}
