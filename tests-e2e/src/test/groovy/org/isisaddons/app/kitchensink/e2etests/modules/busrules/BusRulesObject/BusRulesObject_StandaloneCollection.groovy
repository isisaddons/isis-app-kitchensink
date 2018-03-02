package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject

import geb.Module
import org.incode.platform.lib.gebspock.wicket.ui.components.collectioncontents.ajaxtable.CollectionContentsAsAjaxTablePanel
import org.incode.platform.lib.gebspock.wicket.ui.components.standalonecollection.StandaloneCollectionPanel

class BusRulesObject_StandaloneCollection extends Module {

    static base = { module(StandaloneCollectionPanel).$(".isis-busrules-busrulesobject") }

    static content = {
        table { module(CollectionContentsAsAjaxTablePanel).table }
    }

}
