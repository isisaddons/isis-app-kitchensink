package ch.silviowangler.geb.pages

import ch.silviowangler.geb.modules.PrototypingMenuModule
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
