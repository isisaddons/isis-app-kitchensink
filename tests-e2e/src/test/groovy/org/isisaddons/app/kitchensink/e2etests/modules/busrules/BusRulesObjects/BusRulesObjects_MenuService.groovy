package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects

import org.isisaddons.app.kitchensink.e2etests.base.MenuServiceModule

class BusRulesObjects_MenuService extends MenuServiceModule {

    static content = {
        menu { $("ul.navbar-nav li.dropdown.isis-busrules-busrulesobjects a", 0)}

        findBusRulesObject { module(FindBusRulesObject_MenuItem) }
        listAllBusRulesObject { module(ListAllBusRulesObject_MenuItem) }
    }

}
