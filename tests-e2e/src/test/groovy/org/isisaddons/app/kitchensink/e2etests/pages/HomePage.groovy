package org.isisaddons.app.kitchensink.e2etests.pages

import org.isisaddons.app.kitchensink.e2etests.modules.ActionParametersModule
import org.isisaddons.app.kitchensink.e2etests.modules.PrototypingMenuModule
import geb.Page

class HomePage extends Page {

    static at = {
        $(".intro").text().contains(" a platform to let you rapidly develop")
    }

    static content = {

        prototypingMenu { module(PrototypingMenuModule) }
        actionParameters { module(ActionParametersModule) }

    }

}
