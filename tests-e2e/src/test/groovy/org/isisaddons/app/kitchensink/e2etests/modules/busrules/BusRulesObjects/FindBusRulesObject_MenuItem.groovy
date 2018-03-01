package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects

import geb.Module

class FindBusRulesObject_MenuItem extends Module {
    static content = {
        menuItem { $("ul.navbar-nav li.dropdown.isis-busrules-busrulesobjects li.isis-busrules-busrulesobjects-findbusrulesobject a", 0)}
        prompt { module(FindBusRulesObject_Prompt) }
    }
}
