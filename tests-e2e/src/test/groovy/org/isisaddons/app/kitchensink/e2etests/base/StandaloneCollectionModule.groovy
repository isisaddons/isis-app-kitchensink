package org.isisaddons.app.kitchensink.e2etests.base

import geb.Module

class StandaloneCollectionModule extends Module {

    static content = {
        table(wait: true) { $(".collectionContentsAsAjaxTablePanel table", 0) }
    }

}
