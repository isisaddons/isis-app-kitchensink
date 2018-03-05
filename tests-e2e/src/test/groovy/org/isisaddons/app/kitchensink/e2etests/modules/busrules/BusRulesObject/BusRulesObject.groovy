package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject

import geb.Module
import org.incode.platform.lib.gebspock.wicket.ui.components.collectioncontents.ajaxtable.CollectionContentsAsAjaxTablePanel
import org.incode.platform.lib.gebspock.wicket.ui.components.scalars.primitive.BooleanPanel
import org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string.StringPanel
import org.incode.platform.lib.gebspock.wicket.ui.components.standalonecollection.StandaloneCollectionPanel
import org.incode.platform.lib.gebspock.wicket.ui.pages.entity.EntityPage
import org.incode.platform.lib.gebspock.wicket.ui.pages.standalonecollection.StandaloneCollectionPage

class BusRulesObject_EntityPage extends EntityPage {

    static at = {
        body.displayed
    }

    static content = {
        body(wait: true) { $(".entityPage.isis-busrules-BusRulesObject") }
    }
}

class BusRulesObject_StandaloneCollectionPage extends StandaloneCollectionPage {

    static at = {
        body.displayed
    }

    static content = {
        body(wait: true) { $(".standaloneCollectionPage").$(".isis-busrules-BusRulesObject") }

        tablePanel { module(BusRulesObject_CollectionContentsAsAjaxTablePanel) }
    }
}

class BusRulesObject_CollectionContentsAsAjaxTablePanel extends Module {

    static base = { module(StandaloneCollectionPanel).$(".isis-busrules-BusRulesObject") }

    static content = {
        columns { module(BusRulesObject_CollectionContentsAsAjaxTablePanel_Columns) }
    }
}

class BusRulesObject_CollectionContentsAsAjaxTablePanel_Columns extends CollectionContentsAsAjaxTablePanel {

    static content = {

        name { tbody.$("td.isis-busrules-BusRulesObject-name").module(StringPanel).columnValue(it) }
        enableActions { tbody.$("td.isis-busrules-BusRulesObject-enableActions").module(BooleanPanel).columnValue(it) }
    }
}