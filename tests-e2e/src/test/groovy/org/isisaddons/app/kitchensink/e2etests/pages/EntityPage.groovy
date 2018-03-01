package org.isisaddons.app.kitchensink.e2etests.pages

class EntityPage extends LoggedInPage {

    static at = {
        body.displayed
    }

    static content = {
        body(wait:true) { $(".entityPage") }
    }

}
