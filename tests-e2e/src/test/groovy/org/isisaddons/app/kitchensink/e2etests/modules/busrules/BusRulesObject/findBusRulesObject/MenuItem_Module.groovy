package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject.findBusRulesObject

import geb.Module

class MenuItem_Module extends Module {

    static content = {

        menuItem { $("ul.navbar-nav li.dropdown.isis-busrulesobject li.isis-busrulesobject-findbusrulesobject a", 0)}

        prompt { module(Prompt_Module) }

//        results {
//            $(".org-isisaddons-app-kitchensink-fixture-KitchensinkFixturesService_runFixtureScript .collectionContentsAsAjaxTablePanel table", 0) }

    }



}
