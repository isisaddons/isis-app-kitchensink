package org.isisaddons.app.kitchensink.e2etests.pages

import geb.Page
import org.isisaddons.app.kitchensink.e2etests.base.ActionParametersModule
import org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject.Menu_Module

class HomePage extends Page {

    static at = {
        $(".intro").text().contains(" a platform to let you rapidly develop")
    }

    static content = {

        // menu services
        busRulesObject { module(Menu_Module) }

        actionParameters { module(ActionParametersModule) }

    }

}
