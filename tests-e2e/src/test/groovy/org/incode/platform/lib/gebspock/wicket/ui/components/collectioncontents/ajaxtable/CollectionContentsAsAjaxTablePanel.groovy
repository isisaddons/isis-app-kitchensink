package org.incode.platform.lib.gebspock.wicket.ui.components.collectioncontents.ajaxtable

import geb.Module

final class CollectionContentsAsAjaxTablePanel extends Module {

    static base = { $(".collectionContentsAsAjaxTablePanel" ) }

    static content = {
        table(wait: true) { $("table") }
        titleColumn { table.$("tbody td.title-column a.entityUrlSource") }
    }
}
