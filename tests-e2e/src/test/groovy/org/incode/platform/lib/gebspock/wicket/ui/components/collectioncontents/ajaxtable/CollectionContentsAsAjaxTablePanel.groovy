package org.incode.platform.lib.gebspock.wicket.ui.components.collectioncontents.ajaxtable

import geb.Module

class CollectionContentsAsAjaxTablePanel extends Module {

    static base = { $(".collectionContentsAsAjaxTablePanel" ) }

    static content = {
        table(wait: true) { $("table") }
        tbody { table.$("tbody")}
        titleColumn { tbody.$("td.title-column a.entityUrlSource") }
    }
}
