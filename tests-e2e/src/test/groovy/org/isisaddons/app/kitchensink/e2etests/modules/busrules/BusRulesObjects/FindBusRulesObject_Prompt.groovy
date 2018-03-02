package org.isisaddons.app.kitchensink.e2etests.modules.busrules.BusRulesObjects

import org.incode.platform.lib.gebspock.wicket.ui.components.actionprompt.ActionPromptModalWindow_Module
import org.incode.platform.lib.gebspock.wicket.ui.components.actions.ActionParametersFormPanel_Module

class FindBusRulesObject_Prompt extends ActionParametersFormPanel_Module {

    static content = {
        form { module(ActionPromptModalWindow_Module).$("form.isis-busrules-busrulesobjects-findbusrulesobject") }
        parameters { form.module FindBusRulesObject_PromptParams }
    }
}