package ch.silviowangler.geb.pages

import ch.silviowangler.geb.modules.ActionParametersModule
import ch.silviowangler.geb.modules.PrototypingMenuModule
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
