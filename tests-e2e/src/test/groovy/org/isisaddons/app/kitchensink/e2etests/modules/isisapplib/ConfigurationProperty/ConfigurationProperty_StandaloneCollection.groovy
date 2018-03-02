package org.isisaddons.app.kitchensink.e2etests.modules.isisapplib.ConfigurationProperty

import geb.Module
import org.incode.platform.lib.gebspock.wicket.ui.components.collectioncontents.ajaxtable.CollectionContentsAsAjaxTablePanel
import org.incode.platform.lib.gebspock.wicket.ui.components.standalonecollection.StandaloneCollectionPanel

class ConfigurationProperty_StandaloneCollection extends Module {

    static base = { module(StandaloneCollectionPanel).$(".isis-isisapplib-configurationproperty") }

    static content = {
        table(wait:3) { module(CollectionContentsAsAjaxTablePanel).table }
    }

}
