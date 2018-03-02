package org.incode.platform.lib.gebspock.wicket.ui.pages

import geb.Page
import org.incode.platform.lib.gebspock.wicket.ui.components.header.HeaderPanel
import org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects.BusRulesObjects_DomainService

class LoggedInPage extends Page {

    static at = {
        module(HeaderPanel).tertiary.displayed
    }

    static content = {
        currentUser { module(HeaderPanel).currentUser }
        logo { module(HeaderPanel).logo }

        // menu bar
        busRulesObjects { module(BusRulesObjects_DomainService) }
    }

}
