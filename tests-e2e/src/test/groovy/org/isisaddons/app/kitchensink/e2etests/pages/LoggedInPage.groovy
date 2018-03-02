package org.isisaddons.app.kitchensink.e2etests.pages

import geb.Page
import org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects.BusRulesObjects_DomainService

class LoggedInPage extends Page {

    static at = {
        $(".navbar-nav.tertiary").displayed
    }

    static content = {
        currentUser { $(".tertiary span.userName") }
        logo { $( ".navbar-header a.navbar-brand") }

        // menu bar
        busRulesObjects { module(BusRulesObjects_DomainService) }
    }

}
