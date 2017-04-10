package ch.silviowangler.geb.modules

import geb.Module

class PrototypingMenuModule extends Module {

    static content = {

        menu { $("ul.secondary a", 0)}

        runFixtureScripts { module(RunFixtureScriptsModule) }

    }



}
