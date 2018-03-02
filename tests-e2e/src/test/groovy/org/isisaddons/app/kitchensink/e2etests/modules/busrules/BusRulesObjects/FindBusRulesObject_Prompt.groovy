package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects

import org.incode.platform.lib.gebspock.wicket.ui.components.actionprompt.ActionPromptModalWindow_Module
import org.incode.platform.lib.gebspock.wicket.ui.components.actions.ActionParametersFormPanel_Module

class FindBusRulesObject_Prompt extends ActionParametersFormPanel_Module {

    // because this prompt is DIALOG, not INLINE, the prompt is relative to ActionPromptModalWindow_Module
    static base = { module(ActionPromptModalWindow_Module).$(".isis-busrules-busrulesobjects-findbusrulesobject") }

    static content = {
        parameters { module FindBusRulesObject_PromptParams }
    }
}