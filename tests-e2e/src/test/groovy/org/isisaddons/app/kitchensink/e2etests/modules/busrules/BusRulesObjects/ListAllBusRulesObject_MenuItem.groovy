package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects

import geb.Module
import org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject.BusRulesObject_StandaloneCollection

class ListAllBusRulesObject_MenuItem extends Module {
    static content = {
        menuItem { $("ul.navbar-nav li.dropdown.isis-busrules-busrulesobjects li.isis-busrules-busrulesobjects-listallbusrulesobject a", 0)}
        // no args so no prompt
        results { module(BusRulesObject_StandaloneCollection) }
    }
}
