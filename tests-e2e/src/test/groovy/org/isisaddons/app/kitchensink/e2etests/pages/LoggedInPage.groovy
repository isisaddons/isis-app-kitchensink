package org.isisaddons.app.kitchensink.e2etests.pages

import geb.Page
import org.isisaddons.app.kitchensink.e2etests.base.ActionParametersModule
import org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects.BusRulesObjects_MenuService

class LoggedInPage extends Page {

    static at = {
        $(".navbar-nav.tertiary").displayed
    }

    static content = {

        currentUser { $(".tertiary span.userName") }

        logo { $( "div.navbar-header div.navbar-class a", 0) }

        // menu services
        busRulesObject { module(BusRulesObjects_MenuService) }

        actionParameters { module(ActionParametersModule) }

    }

}
