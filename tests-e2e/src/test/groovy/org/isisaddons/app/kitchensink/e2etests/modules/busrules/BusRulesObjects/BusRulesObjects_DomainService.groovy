package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects

import geb.Module
import org.incode.platform.lib.gebspock.wicket.ui.components.actionmenu.serviceactions.ServiceActionsPanel_Module
import org.incode.platform.lib.gebspock.wicket.ui.components.actionprompt.ActionPromptModalWindow_Module
import org.incode.platform.lib.gebspock.wicket.ui.components.actions.ActionParametersFormPanel_Module
import org.incode.platform.lib.gebspock.wicket.ui.components.header.HeaderPanel_Module
import org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string.StringPanel_Module
import org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObject.BusRulesObject_StandaloneCollection

class BusRulesObjects_DomainService extends Module {
    static base = { module(HeaderPanel_Module) }
    static content = {
        menu { $("li.dropdown.isis-busrules-busrulesobjects a", 0)}

        findBusRulesObject { module FindBusRulesObject_MenuItem }
        listAllBusRulesObject { module ListAllBusRulesObject_MenuItem }
    }
}

class FindBusRulesObject_MenuItem extends Module {
    static base = { module(HeaderPanel_Module) }
    static content = {
        menuItem { module(ServiceActionsPanel_Module).dropdown
                    .$(".isis-busrules-busrulesobjects li.isis-busrules-busrulesobjects-findbusrulesobject a")}
        prompt { module FindBusRulesObject_Prompt }
    }
}

class FindBusRulesObject_Prompt extends ActionParametersFormPanel_Module {
    static base = {
        module(ActionPromptModalWindow_Module) // because this prompt is DIALOG, not INLINE
                .$(".isis-busrules-busrulesobjects-findbusrulesobject")
    }
    static content = {
        parameters { $("fieldset.parameters").module FindBusRulesObject_PromptParams }
    }
}

class FindBusRulesObject_PromptParams extends Module {
    static content = {
        name { $(".isis-name").module(StringPanel_Module) }
    }
}

class ListAllBusRulesObject_MenuItem extends Module {
    static content = {
        menuItem { module(ServiceActionsPanel_Module).dropdown
                .$(".isis-busrules-busrulesobjects li.isis-busrules-busrulesobjects-listallbusrulesobject a")}
        // no args so no prompt
        results { module BusRulesObject_StandaloneCollection }
    }
}


