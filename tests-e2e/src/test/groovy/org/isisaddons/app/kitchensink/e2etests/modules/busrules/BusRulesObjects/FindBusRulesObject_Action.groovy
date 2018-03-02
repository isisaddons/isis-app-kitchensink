package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects

import geb.Module
import org.incode.platform.lib.gebspock.wicket.ui.components.actionprompt.ActionPromptModalWindow_Module
import org.incode.platform.lib.gebspock.wicket.ui.components.actions.ActionParametersFormPanel_Module
import org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string.StringPanel_Module

class FindBusRulesObject_MenuItem extends Module {
    static content = {
        menuItem { $("ul.navbar-nav li.dropdown.isis-busrules-busrulesobjects li.isis-busrules-busrulesobjects-findbusrulesobject a", 0)}
        prompt { module FindBusRulesObject_Prompt }
    }
}

class FindBusRulesObject_Prompt extends ActionParametersFormPanel_Module {

    // because this prompt is DIALOG, not INLINE, the prompt is relative to ActionPromptModalWindow_Module
    static base = { module(ActionPromptModalWindow_Module).$(".isis-busrules-busrulesobjects-findbusrulesobject") }

    static content = {
        parameters { $("fieldset.parameters").module FindBusRulesObject_PromptParams }
    }
}

class FindBusRulesObject_PromptParams extends Module {
    static content = {
        name { $(".isis-name").module(StringPanel_Module) }
    }
}

