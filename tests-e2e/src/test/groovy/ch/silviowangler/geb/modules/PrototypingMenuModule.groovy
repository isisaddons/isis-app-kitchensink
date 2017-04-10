package ch.silviowangler.geb.modules

import geb.Module

class PrototypingMenuModule extends Module {

    static content = {

        menu { $("ul.secondary a", 0)}

        runFixtureScripts { module(RunFixtureScriptsModule) }

//        runFixtureScripts_menuItem { $("ul.top-menu-prototyping a", 0)}
//
//        runFixtureScripts_results {
//            $(".org-isisaddons-app-kitchensink-fixture-KitchensinkFixturesService_runFixtureScript .collectionContentsAsAjaxTablePanel table", 0) }

    }



}
