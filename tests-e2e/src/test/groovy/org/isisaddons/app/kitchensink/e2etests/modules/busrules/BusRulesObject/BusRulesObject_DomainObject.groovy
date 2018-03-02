package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject

import geb.Module
import org.incode.platform.lib.gebspock.wicket.ui.components.collectioncontents.ajaxtable.CollectionContentsAsAjaxTablePanel
import org.incode.platform.lib.gebspock.wicket.ui.components.scalars.primitive.BooleanPanel
import org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string.StringPanel
import org.incode.platform.lib.gebspock.wicket.ui.components.standalonecollection.StandaloneCollectionPanel
import org.incode.platform.lib.gebspock.wicket.ui.pages.standalonecollection.StandaloneCollectionPage

class BusRulesObject_StandaloneCollectionPage extends StandaloneCollectionPage {

    static at = {
        body.displayed
    }

    static content = {
        body(wait: true) { $(".standaloneCollectionPage").$(".isis-busrules-busrulesobject") }

        tablePanel { module(BusRulesObject_CollectionContentsAsAjaxTablePanel) }
    }

}

class BusRulesObject_CollectionContentsAsAjaxTablePanel extends Module {

    static base = { module(StandaloneCollectionPanel).$(".isis-busrules-busrulesobject") }

    static content = {
        table { module(CollectionContentsAsAjaxTablePanel).table }
        tbody { module(CollectionContentsAsAjaxTablePanel).tbody }
        titleColumn { module(CollectionContentsAsAjaxTablePanel).titleColumn(it) }

        nameColumn { tbody.$("td.isis-busrules-busrulesobject-name").module(StringPanel).columnValue(it) }
        enableActionsColumn { tbody.$("td.isis-busrules-busrulesobject-enableactions").module(BooleanPanel).columnValue(it) }
    }
}