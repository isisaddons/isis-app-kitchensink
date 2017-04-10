package ch.silviowangler.geb.modules

import geb.Module

class RunFixtureScriptsModule extends Module {

    static content = {

        menuItem { $("ul.top-menu-prototyping a", 0)}

        results {
            $(".org-isisaddons-app-kitchensink-fixture-KitchensinkFixturesService_runFixtureScript .collectionContentsAsAjaxTablePanel table", 0) }

    }



}
