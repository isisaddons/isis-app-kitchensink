package org.isisaddons.app.kitchensink.e2etests.modules.isisapplib.ConfigurationProperty

import org.incode.platform.lib.gebspock.wicket.ui.components.collectioncontents.ajaxtable.CollectionContentsAsAjaxTablePanel
import org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string.StringPanel
import org.incode.platform.lib.gebspock.wicket.ui.components.standalonecollection.StandaloneCollectionPanel
import org.incode.platform.lib.gebspock.wicket.ui.pages.standalonecollection.StandaloneCollectionPage

class ConfigurationProperty_StandaloneCollectionPage extends StandaloneCollectionPage {

    static at = {
        body.displayed
    }

    static content = {
        body(wait: true) { $(".standaloneCollectionPage").$(".isis-isisapplib-configurationproperty") }

        tablePanel { module(ConfigurationProperty_CollectionContentsAsAjaxTablePanel) }
    }
}

class ConfigurationProperty_CollectionContentsAsAjaxTablePanel extends CollectionContentsAsAjaxTablePanel {

    static base = { module(StandaloneCollectionPanel).$(".isis-isisapplib-configurationproperty") }

    static content = {
        keyColumn { tbody.$("td.isis-isis-isisapplib-configurationproperty-key").module(StringPanel).columnValue(it) }
        valueColumn { tbody.$("td.isis-isis-isisapplib-configurationproperty-value").module(StringPanel).columnValue(it) }
    }
}