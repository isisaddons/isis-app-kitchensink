package org.incode.platform.lib.gebspock.wicket.ui.components.collectioncontents.ajaxtable

import geb.Module

final class CollectionContentsAsAjaxTablePanel extends Module {

    static content = {
        table(wait: true) { $(".collectionContentsAsAjaxTablePanel table", 0) }
    }

}
