package org.incode.platform.lib.gebspock.wicket.ui.components.collectioncontents.ajaxtable

import geb.Module

abstract class CollectionContentsAsAjaxTablePanel extends Module {

    static base = { $(".collectionContentsAsAjaxTablePanel" ) }

    static content = {
        table(wait: true) { $("table") }
        tbody { table.$("tbody")}
        objectTitle { tbody.$("td.title-column a.entityUrlSource", it) }
    }
}
