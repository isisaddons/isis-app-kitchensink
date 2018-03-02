package org.incode.platform.lib.gebspock.wicket.ui.pages.home

import org.incode.platform.lib.gebspock.wicket.ui.pages.LoggedInPage

class HomePage extends LoggedInPage {

    static at = {
        $(".intro").text().contains(" a platform to let you rapidly develop")
    }

    static content = {
    }

}
