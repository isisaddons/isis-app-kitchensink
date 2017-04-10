package org.isisaddons.app.kitchensink.e2etests.pages

import org.isisaddons.app.kitchensink.e2etests.modules.PrototypingMenuModule
import geb.Page

class CollectionResultsPage extends Page {

    static at = {
        table.displayed
    }

    static content = {
        table(wait: true) { $(".collectionContentsAsAjaxTablePanel table", 0) }
        prototypingMenu { module(PrototypingMenuModule) }
    }

}
