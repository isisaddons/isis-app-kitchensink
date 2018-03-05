package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects

import geb.Module
import org.incode.platform.lib.gebspock.wicket.ui.components.actionmenu.serviceactions.ServiceActionsPanel
import org.incode.platform.lib.gebspock.wicket.ui.components.actionprompt.ActionPromptModalWindow
import org.incode.platform.lib.gebspock.wicket.ui.components.actions.ActionParametersFormPanel
import org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string.StringPanel

class BusRulesObjects_DomainService extends Module {
    //static base = { module(HeaderPanel) }
    static content = {
        menu { $("li.dropdown.isis-busrules-busrulesobjects a", 0)}

        findBusRulesObject { module FindBusRulesObject_MenuItem }
        listAllBusRulesObject { module ListAllBusRulesObject_MenuItem }
    }
}

class FindBusRulesObject_MenuItem extends Module {
    //static base = { module(HeaderPanel) }
    static content = {
        menuItem { module(ServiceActionsPanel).dropdown
                    .$(".isis-busrules-busrulesobjects li.isis-busrules-busrulesobjects-findbusrulesobject a")}
        prompt(wait:true) { module FindBusRulesObject_Prompt }
    }
}

class FindBusRulesObject_Prompt extends ActionParametersFormPanel {
    static base = {
        module(ActionPromptModalWindow) // because this prompt is DIALOG, not INLINE
                .$(".isis-busrules-busrulesobjects-findbusrulesobject")
    }
    static content = {
        parameters { $("fieldset.parameters").module FindBusRulesObject_PromptParams }
        //ok { module(ActionParametersFormPanel).ok }
        //cancel { module(ActionParametersFormPanel).cancel }
    }
}

class FindBusRulesObject_PromptParams extends Module {
    static content = {
        name { module(FindBusRulesObject_Name) }
    }
}

class FindBusRulesObject_Name extends Module {
    static content = {
        input { $(".isis-name").module(StringPanel).input }
        feedback(wait:true) { $(".isis-name").module(StringPanel).feedback }
    }
}

class ListAllBusRulesObject_MenuItem extends Module {
    static content = {
        menuItem { module(ServiceActionsPanel).dropdown
                .$(".isis-busrules-busrulesobjects li.isis-busrules-busrulesobjects-listallbusrulesobject a")}
        // no args so no prompt
    }
}


