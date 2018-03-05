package org.isisaddons.app.kitchensink.e2etests.modules.isisapplib.ConfigurationProperty

import geb.Module
import org.incode.platform.lib.gebspock.wicket.ui.components.collectioncontents.ajaxtable.CollectionContentsAsAjaxTablePanel
import org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string.StringPanel
import org.incode.platform.lib.gebspock.wicket.ui.components.standalonecollection.StandaloneCollectionPanel
import org.incode.platform.lib.gebspock.wicket.ui.pages.standalonecollection.StandaloneCollectionPage

class ConfigurationProperty_StandaloneCollectionPage extends StandaloneCollectionPage {

    static at = {
        body.displayed
    }

    static content = {
        body(wait: true) { $(".standaloneCollectionPage").$(".isis-isisApplib-ConfigurationProperty") }

        tablePanel { module(ConfigurationProperty_CollectionContentsAsAjaxTablePanel) }
    }
}

class ConfigurationProperty_CollectionContentsAsAjaxTablePanel extends Module {

    static base = { module(StandaloneCollectionPanel).$(".isis-isisApplib-ConfigurationProperty") }

    static content = {
        columns { module(ConfigurationProperty_CollectionContentsAsAjaxTablePanel_Columns) }
    }
}

class ConfigurationProperty_CollectionContentsAsAjaxTablePanel_Columns extends CollectionContentsAsAjaxTablePanel {    static content = {
        key { tbody.$("td.isis-isis-isisApplib-ConfigurationProperty-key").module(StringPanel).columnValue(it) }
        value { tbody.$("td.isis-isis-isisApplib-ConfigurationProperty-value").module(StringPanel).columnValue(it) }
    }
}