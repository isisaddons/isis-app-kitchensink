package org.incode.platform.lib.gebspock.wicket.ui.pages.standalonecollection

import org.incode.platform.lib.gebspock.wicket.ui.pages.LoggedInPage

class StandaloneCollectionPage extends LoggedInPage {

    static at = {
        body.displayed
    }

    static content = {
        body { $(".standaloneCollectionPage") }
    }

}
