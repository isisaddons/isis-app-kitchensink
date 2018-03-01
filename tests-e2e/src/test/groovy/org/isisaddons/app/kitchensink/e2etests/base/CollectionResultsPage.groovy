package org.isisaddons.app.kitchensink.e2etests.base


import geb.Page

class CollectionResultsPage extends Page {

    static at = {
        table.displayed
    }

    static content = {
        table(wait: true) { $(".collectionContentsAsAjaxTablePanel table", 0) }

//        results {
//            $(".org-isisaddons-app-kitchensink-fixture-KitchensinkFixturesService_runFixtureScript .collectionContentsAsAjaxTablePanel table", 0) }


    }

}
