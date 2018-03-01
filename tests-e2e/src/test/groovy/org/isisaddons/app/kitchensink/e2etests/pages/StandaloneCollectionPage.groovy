package org.isisaddons.app.kitchensink.e2etests.pages

class StandaloneCollectionPage extends LoggedInPage {

    static at = {
        body.displayed
    }

    static content = {
        body { $(".standaloneCollectionPage") }
    }

}
