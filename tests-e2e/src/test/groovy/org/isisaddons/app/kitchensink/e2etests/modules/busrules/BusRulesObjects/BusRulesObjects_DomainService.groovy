package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects

import geb.Module
import org.incode.platform.lib.gebspock.wicket.ui.components.actionmenu.serviceactions.ServiceActionsPanel
import org.incode.platform.lib.gebspock.wicket.ui.components.actionprompt.ActionPromptModalWindow
import org.incode.platform.lib.gebspock.wicket.ui.components.actions.ActionParametersFormPanel_Abstract
import org.incode.platform.lib.gebspock.wicket.ui.components.header.HeaderPanel
import org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string.StringPanel
import org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject.BusRulesObject_StandaloneCollection

class BusRulesObjects_DomainService extends Module {
    static base = { module(HeaderPanel) }
    static content = {
        menu { $("li.dropdown.isis-busrules-busrulesobjects a", 0)}

        findBusRulesObject { module FindBusRulesObject_MenuItem }
        listAllBusRulesObject { module ListAllBusRulesObject_MenuItem }
    }
}

class FindBusRulesObject_MenuItem extends Module {
    static base = { module(HeaderPanel) }
    static content = {
        menuItem { module(ServiceActionsPanel).dropdown
                    .$(".isis-busrules-busrulesobjects li.isis-busrules-busrulesobjects-findbusrulesobject a")}
        prompt { module FindBusRulesObject_Prompt }
    }
}

class FindBusRulesObject_Prompt extends ActionParametersFormPanel_Abstract {
    static base = {
        module(ActionPromptModalWindow) // because this prompt is DIALOG, not INLINE
                .$(".isis-busrules-busrulesobjects-findbusrulesobject")
    }
    static content = {
        parameters { $("fieldset.parameters").module FindBusRulesObject_PromptParams }
    }
}

class FindBusRulesObject_PromptParams extends Module {
    static content = {
        name { $(".isis-name").module(StringPanel) }
    }
}

class ListAllBusRulesObject_MenuItem extends Module {
    static content = {
        menuItem { module(ServiceActionsPanel).dropdown
                .$(".isis-busrules-busrulesobjects li.isis-busrules-busrulesobjects-listallbusrulesobject a")}
        // no args so no prompt
        results { module BusRulesObject_StandaloneCollection }
    }
}


