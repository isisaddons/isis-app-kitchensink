package org.isisaddons.app.kitchensink.e2etests.modules

import geb.Module

class PrototypingMenuModule extends Module {

    static content = {

        menu { $("ul.secondary a", 0)}

        runFixtureScripts { module(RunFixtureScriptsModule) }

    }



}
