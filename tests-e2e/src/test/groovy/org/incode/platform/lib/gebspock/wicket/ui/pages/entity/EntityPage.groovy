package org.incode.platform.lib.gebspock.wicket.ui.pages.entity

import org.incode.platform.lib.gebspock.wicket.ui.pages.LoggedInPage

class EntityPage extends LoggedInPage {

    static at = {
        body.displayed
    }

    static content = {
        body(wait:true) { $(".entityPage") }

        objectTitle { $(".entityHeaderPanel .iconAndTitle span.entityTitle",0).text() }
    }

}
