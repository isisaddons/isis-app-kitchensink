package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject

import geb.Module
import org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject.findBusRulesObject.MenuItem_Module

class Menu_Module extends Module {

    static content = {

        menu { $("ul.navbar-nav li.dropdown.isis-busrulesobject a", 0)}

        findBusRulesObject { module(MenuItem_Module) }

    }



}
